package com.kh.operator;

import java.util.Scanner;

public class C_Logical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 논리연산자 (이항 연산자)
		 * : 논리값을 비교하는 연산자 (true, false)
		 * : 결과값도 논리값
		 * : && ( and) || (or)
		 * A && B : A, B 모두 true 여야 true
		 * true && true => true
		 * true && false => false
		 * false && true => false
		 * false && false => false
		 * - OR 연산 : ||
		 * A || B : A 또는 B 중에 하나라도 true 면 true
		 * true || true => true
		 * true || false => true
		 * false || true => true
		 * false || false => false
		 * 단축평가(SCE)
		 * && 연산자 : 왼쪽(A) 조건이 false 라면 오른쪽(b) 연산이 수행되지 않음!
		 * || 연산자 : 왼쪽(A) 조건이 true 라면 오른쪽(b) 연산이 수행되지 않음!
		 */
		// method1();
		method2();

	}
	
	public static void method1() {
		
		// 입력받은 값이 1 ~ 10 사이의 값인지 확인
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");	
		int n1 = sc.nextInt();	
		boolean result1 = n1 >= 1 && n1 <= 10;
		boolean result2 = n1 < 1 || n1 > 10;		
		System.out.println("입력받은 값이 1 ~ 10 사이의 값인가? : " + result1);	
		System.out.println("입력받은 값이 1 ~ 10 사이를 벗어나는가? : " + result2);			
		
		sc.close();
		
	}
	
	
	public static void method2() {
		
		// 입력받은 문자가 소문자인지 확인
		Scanner sc = new Scanner(System.in);
		System.out.print("알파벳을 입력하세요: ");	
		String alpha = sc.nextLine();	
		char chAlpha = alpha.charAt(0);
		boolean isSmall = chAlpha >= 'a'  && chAlpha <= 'z';
		boolean isBig = chAlpha >= 'A'  && chAlpha <= 'Z';
		System.out.printf("%c 는 소문자인가? : %b \n" , chAlpha,  isSmall);	
		System.out.printf("%c 는 대문자인가? : %b \n", chAlpha,  isBig);			
		
		sc.close();
		
	}		

}
