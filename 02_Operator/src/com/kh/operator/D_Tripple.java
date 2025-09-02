package com.kh.operator;

import java.util.Scanner;

public class D_Tripple {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 삼항연산자
		 * 조건식 ? 조건의 결과가 true인 경우 사용할 값 (식);
		 *      : 조건의 결과가 false인 경우 사용할 값 (식);
   
		 */
		 method1();


	}	
	
	public static void method1() {
		
		// 입력받은 값이 1 ~ 10 사이의 값인지 확인
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자를 입력하세요: ");	
		char ch = sc.next().charAt(0);	
        String Result = ch == 'x' || ch == 'X' ? "종료합니다." : "계속 진행합니다.";    
		
		// 입력받은 값이 'x' 또는 'X'인 경우 "종료합니다. 출력하고 그렇지 않으면 "계속 진행합니다." 츨력

		System.out.printf(Result);	
		
		sc.close();
		
		
	}
		

}
