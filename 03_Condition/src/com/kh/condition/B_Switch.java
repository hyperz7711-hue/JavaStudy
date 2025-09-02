package com.kh.condition;

import java.util.Scanner;

public class B_Switch {
	
	public static void main(String[] args) {
		
		/*
		 * switch
		 * :if 문과 동일한 조건문이지만, 동등비교를 통해 흐름을 제어
		 * : 실행할 코드만 실행하고 종료하기 위해서 break 를 사용
		 * : 순차적인 흐름을 바꿀 때 제어문(조건문, 반목문)을 사용하여 제어 가능
		 * 조건문의 종류 : swith
		 * switch (비교대상) { 
		 * 		case 값1 :
		 *                // 비교대상== 값1 경우 실행할 내용
		 *                break;
		 * 		case 값2:
		 *                // 비교대상== 값2 경우 실행할 내용
		 *                break;
		 * 	    default :
		 *                // if문의 else에 해당
		 *                // 모든 케이스에 해당하지 않을 때    
		 */
		method1();
	}	
	
	public static void method1() {
		
		/*
		 * 정수를 입력받아 아래조건에 맞게 출력
		 * 1 : 빨간색
		 * 2 : 노란색
		 * 3 : 파란색
		 * 그외 : 초록색 
		 */		
		
		int num;

		System.out.print("정수입력 : ");

		Scanner sc = new Scanner(System.in);

		num = sc.nextInt();

		switch(num){
		
		case 1:
			System.out.println("빨간색");
			break;
			
		case 2:
			System.out.println("노란색");
			break;
			
		case 3:
			System.out.println("파란색");
			break;
						
		default :
			System.out.println("초록색");
			break;			
			
			
		}

		
	}	

}
