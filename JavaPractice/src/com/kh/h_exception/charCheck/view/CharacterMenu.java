package com.kh.h_exception.charCheck.view;

import java.util.Scanner;

import com.kh.h_exception.charCheck.controller.CharacterController;
import com.kh.h_exception.charCheck.exception.CharCheckException;

public class CharacterMenu {

	public CharacterMenu() {
		super();
	}

	public void menu() {

		Scanner sc = new Scanner(System.in);

		System.out.print("문자열 : ");

		String s;

		s = sc.nextLine();

		CharacterController cc = new CharacterController();

		int result = 0;
		try {
			result = cc.countAlpha(s);
			System.out.printf("'%s'에 포함된 영문자 개수 : %d", s, result);

		} catch (CharCheckException e) // CharCheckException 에러 클래스 리턴
		{
			e.printStackTrace(); // 에러 메시지 표기
		}

	}

}
