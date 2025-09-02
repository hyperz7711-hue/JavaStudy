package com.kh.condition;
import java.util.Scanner;

public class A_If {
	
	public static void main(String[] args) {
	
		/*
		 * 조건문 If
		 * :기본적으로 프로그램은 순차적으로 실행 ( 위-->아래, 왼쪽->오른쪽)
		 * : 순차적인 흐름을 바꿀 때 제어문(조건문, 반목문)을 사용하여 제어 가능
		 * 조건문의 종류 : If, swith
		 * If 
		 * 	[1] 단독 if문
		 * 		if( 조건식) {
		 *                   // 조건식의 결과가 참(true)일 때 실행 }
		 * 	[2] if ~ else문
		 * 		if( 조건식) {
		 *                   // 조건식의 결과가 참(true)일 때 실행               
		 *                } else {  
		 *                   // 조건식의 결과가 거짓(false)일 때 실행   
		 *                   }   
		 * 	[3] if ~ else if ~ else 문
		 * 		if( 조건식1) {
		 *                   // 조건식1의 결과가 참(true)일 때 실행   
		 *                } else if (조건식2) {  
		 *                   // 조건식2의 결과가 참(true)일 때 실행   
		 *                   }                 
		 *                } else {  
		 *                   // 조건식1,2 의 결과가 거짓(false)일 때 실행   
		 *                   }   
		 */
		//method1();
		method2();
	}
	
	public static void method1() {
		
		int num;
		
		System.out.print("1 ~ 10 사이의 값을 입력 : ");
		
		Scanner sc = new Scanner(System.in);
		
		num = sc.nextInt();
		
		if ( num >= 1 && num <= 10 )
		{
			System.out.println(num);
		}
		else
		{
			System.out.println("범위를 벗어났습니다.");			
		}
		

		
	}
	
	public static void method2() {
		
		// 주민번호를 입력받아서 남자인지 여자인지 출력
		// 단 - 를 포함하여 입력받은 길이가 14가 아닌 경우 "잘못 입력하였습니다" 출력
		String psn;
		
		System.out.print("주민번호를 입력(-포함): ");
		
		Scanner sc = new Scanner(System.in);
		psn = sc.next();
		
		if ( psn.length() == 14 )
		{
			char gender = psn.charAt(7);

			
			if (gender =='1' || gender =='3' )
			{
				System.out.println("남자입니다.");	
			}
			else if (gender =='2' || gender =='4' )
			{
				System.out.println("여자입니다.");	
			}
			else
			{
				System.out.println("8번째 주민번호 자리가 허용되지 않은 숫자입니다.");					
			}
		}
		else
		{
			System.out.println("잘못 입력하였습니다.");			
		}
		

		
	}
	

		

}
