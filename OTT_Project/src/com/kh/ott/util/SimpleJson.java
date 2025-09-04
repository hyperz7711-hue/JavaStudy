package com.kh.ott.util;

import java.util.*;

// Very small JSON parser for objects/arrays/strings/numbers/booleans/null
public class SimpleJson {
	public static Object parse(String s) {
		return new Parser(s).parseValue();
	}

	private static class Parser {
		private final String s;
		private int i = 0, n;

		Parser(String s) {
			this.s = s;
			this.n = s.length();
		}

		private void skip() {
			while (i < n && Character.isWhitespace(s.charAt(i)))
				i++;
		}

		Object parseValue() {
			skip();
			if (i >= n)
				return null;
			char c = s.charAt(i);
			if (c == '{')
				return parseObject();
			if (c == '[')
				return parseArray();
			if (c == '"')
				return parseString();
			if (c == 't' && s.startsWith("true", i)) {
				i += 4;
				return Boolean.TRUE;
			}
			if (c == 'f' && s.startsWith("false", i)) {
				i += 5;
				return Boolean.FALSE;
			}
			if (c == 'n' && s.startsWith("null", i)) {
				i += 4;
				return null;
			}
			return parseNumber();
		}

		Map<String, Object> parseObject() {
			Map<String, Object> m = new LinkedHashMap<>();
			i++;
			skip();
			if (i < n && s.charAt(i) == '}') {
				i++;
				return m;
			}
			while (true) {
				skip();
				String k = parseString();
				skip();
				if (s.charAt(i) != ':')
					throw new RuntimeException("Expected : at " + i);
				i++;
				Object v = parseValue();
				m.put(k, v);
				skip();
				if (s.charAt(i) == '}') {
					i++;
					break;
				}
				if (s.charAt(i) != ',')
					throw new RuntimeException("Expected , at " + i);
				i++;
			}
			return m;
		}

		List<Object> parseArray() {
			List<Object> a = new ArrayList<>();
			i++;
			skip();
			if (i < n && s.charAt(i) == ']') {
				i++;
				return a;
			}
			while (true) {
				Object v = parseValue();
				a.add(v);
				skip();
				if (s.charAt(i) == ']') {
					i++;
					break;
				}
				if (s.charAt(i) != ',')
					throw new RuntimeException("Expected , at " + i);
				i++;
			}
			return a;
		}

		String parseString() {
			if (s.charAt(i) != '"')
				throw new RuntimeException("Expected string at " + i);
			i++;
			StringBuilder sb = new StringBuilder();
			while (i < n) {
				char c = s.charAt(i++);
				if (c == '"')
					break;
				if (c == '\\') {
					if (i >= n)
						break;
					char e = s.charAt(i++);
					switch (e) {
					case '"':
						sb.append('"');
						break;
					case '\\':
						sb.append('\\');
						break;
					case '/':
						sb.append('/');
						break;
					case 'b':
						sb.append('\b');
						break;
					case 'f':
						sb.append('\f');
						break;
					case 'n':
						sb.append('\n');
						break;
					case 'r':
						sb.append('\r');
						break;
					case 't':
						sb.append('\t');
						break;
					case 'u':
						String hex = s.substring(i, i + 4);
						i += 4;
						sb.append((char) Integer.parseInt(hex, 16));
						break;
					default:
						sb.append(e);
					}
				} else
					sb.append(c);
			}
			return sb.toString();
		}

		Number parseNumber() {
			int j = i;
			while (i < n) {
				char c = s.charAt(i);
				if ((c >= '0' && c <= '9') || c == '-' || c == '+' || c == '.' || c == 'e' || c == 'E')
					i++;
				else
					break;
			}
			String num = s.substring(j, i);
			if (num.indexOf('.') >= 0 || num.indexOf('e') >= 0 || num.indexOf('E') >= 0)
				return Double.valueOf(num);
			return Long.valueOf(num);
		}
	}
}
