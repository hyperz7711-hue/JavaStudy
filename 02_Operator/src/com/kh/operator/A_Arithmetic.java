package com.kh.operator;

public class A_Arithmetic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 *	산술연산자 (이항 연산자) => + - * / %
		 * 	우선순위 * / % > + -
		*/
		
		method1();
	}
	
	public static void method1() {
		// 정수형 변수 n1 선언하고, 10을 대입
		int n1 = 10;
		int n2 = 3;
		
		System.out.println("n1 + n2 = " + (n1 + n2));
		System.out.println("n1 - n2 = " + (n1 - n2));		
		System.out.println("n1 * n2 = " + n1 * n2);
		System.out.println("n1 / n2 = " + n1 / n2);		
		System.out.println("n1 % n2 = " + n1 % n2);		// 짝수/홀수 판별	
		
		System.out.println("n1은 짝수인가? = " + (n1 % 2 == 0));		// 짝수/홀수 판별	
		System.out.println("n2은 짝수인가? = " + (n2 % 2 == 0));		// 짝수/홀수 판별			
		
		// 짝수 : (변수 % 2 == 0)
		// 홀수 : (변수 % 2 != 0)
		
	}

}
