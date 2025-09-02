package com.kh.operator;

import java.util.Scanner;

public class B_Comparison {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
         * 비교 연산자 ( 이항 연산자)
         * 연산 수행 결과는 true 또는 false
         * - 조건을 만족하는 경우 true
         * - 조건을 만족하지 않는 경우 false
         * 
         * 대소 비교 연산자: > < >= <=
         * 동등 비교 연산자: == !=
		 */
		method1();
		
	}
	
	public static void method1() {
		
		// Scanner 준비시키기! [1] 포함하기 [2] 준비하기( 셍성)
		
		int n1, n2;
		
		Scanner sc = new Scanner(System.in);
		
		// 정수 2개를 입력받아서 변수에 저장
		
		System.out.print("첫번째 정수를 입력하세요: ");	
		n1 = sc.nextInt();
		System.out.print("두번째 정수를 입력하세요: ");	
		n2 = sc.nextInt();		
		
		System.out.printf("n1 : %d, n2 : %d\n", n1, n2);
		System.out.println("첫번째 숫자의 두번째 숫자는 같은 값인가? " + (n1 == n2));		
		System.out.println("첫번째 숫자가 두번째 숫자보다 큰가? " + (n1 > n2));	
		System.out.println("두번째 숫자는 짝수인가? "+ (n2 % 2 == 0));			
       // 문자 ==> 숫자와 매칭되어 있음! 유니코드, ASCII 코드
		System.out.println("두번째 숫자는 'A'의 유니코드인가? "+ (n2 == 'A'));			
	}	

}
