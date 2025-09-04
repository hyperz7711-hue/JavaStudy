package com.kh.ott.repository;

import java.util.*;

public class TopCharts {
	private final Map<String, List<Long>> charts = new LinkedHashMap<>(); // HashMap에 순서를 기억하며 성능이 좀 더 우수함

	public void put(String provider, List<Long> ids) {
		charts.put(provider, ids);
	}

	public boolean has(String provider) {
		return charts.containsKey(provider);
	}

	public List<Long> get(String provider) {
		return charts.getOrDefault(provider, java.util.Collections.emptyList()); // 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환하는 메서드
	}

	public Set<String> providers() {
		return charts.keySet(); // 모든 key를 가져와 Set 객체로 반환
	}

	public boolean isEmpty() {
		return charts.isEmpty();
	}
}
