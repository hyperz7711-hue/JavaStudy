package com.kh.h_exception.charCheck.controller;


import com.kh.h_exception.charCheck.exception.CharCheckException;

// 예외 로직 추가 
public class CharacterController {

	public CharacterController() {
	}
    // throws 호출할 예외클래스명
	public int countAlpha(String s) throws CharCheckException {    

		 // 공백일 경우 예외클래스 호출
		if (s.contains(" ") ) throw new CharCheckException("체크할 문자열 안에 공백이 포함되어 있습니다.");

		 // 문자열 갯수 찾기
			int result = 0;
			
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if ((c >='A' && c>='Z') || (c >='a' && c>='z')  )
					result++;
			}
			
			return result;
		}


}

