package com.kh.loop;

public class A_For {
	// TODO Auto-generated method stub
	/*
	 *  반복문 : 프로그램 흐름을 제어하는 문법 중 하나로 특정코드를 반복적으로 수행
	 *  
	 *  for문
	 *  [표현식]
	 *  for(초기식;조건식;증감식){
	 *  // 반복적으로 수행할 코드
	 *  }
	 *  초기식 : 반목문이 수행될 때 "최초" 한번만 실행하는 식
	 *  조건식 : 반복문이 "수행될 조건"을 작성하는 식
	 *  - 조건식의 결과가 true일 때 중괄호 안의 내용을 실행
	 *  - 조건식의 결과가 false일 때 반복문 종료
	 *  증감식 : 반복문을 제어하는 변수의 값을 증감시키는 식
	 *  [for문 실행 순서]
	 *   초기식-> 조건식 검사 -> 결과가 true인 경우 반복할 내용 수행 -> 증감식 
	 *        -> 조건석 검사 -> 결과가 true인 경우 반복할 내용 수행 -> 증감식 
	 *    ---------- 계속 반복 --------------------
	 *       -> 조건식 검사 -> 결과가 false인 경우 반복문 종료
	 *       
	 *    참고 : 초기식, 조건식, 증감식은 생략가능!
	 *         ==> 세미콜론 ;는 반드시 작성해야 함!!
	 *         - 증감식 생략 => for ( 초기식; 조건식;) {}
	 *         - 조건식 생략 => for(초기식;; 증감식) {}
	 *         - 초기식 생략 => for(;조건식;증감식) {}
	 */
	public static void main(String[] args) {

		//method1();
//		method2();
//		method3();
//		method4();
		method5();
	}
	
	/*
	 * HAPPY 5번 출력
	 */
	
	public static void method1() {	
	
//		System.out.println("HAPPY");
//		System.out.println("HAPPY");
//		System.out.println("HAPPY");
//		System.out.println("HAPPY");
//		System.out.println("HAPPY");
		
//		for (int i= 0; i < 5; i ++)
//		{
//			System.out.println("HAPPY");
//		}
		
//		for (int i= 1; i < 6; i++)
//		{
//			System.out.println("HAPPY");
//		}
		
		for (int i= 10 ; i > 0 ; i--)
		{
			System.out.print(i + " ");
		}
		
	}
	
	public static void method2() {	
		
		for (int i= 10 ; i > 0 ; i--)
		{
			System.out.print(i + " ");
		}
		
	}	
	
	public static void method3() {	
		
		int total = 0;
		
		for (int i= 1 ; i <= 10  ; i++)
		{
			total += i;				
		}
		System.out.print("1~10까지 총 합 : " + total);
	}
	/*
	 * 랜던값을 추출하여 1부터 그 값까지의 총 합
	 * 
	 * 렌덤값을 구하는 방법
	 * - math : java.lang.math
	 *  Math.random() 호출하여 사용
	 *  0.0 ~ 0.9999..... (0.0 <= 랜덤값 < 1.0 )
	 *  ex) 1부터 10까지의 랜덤값 호출
	 *  Math.random(10) * 10 => 0.0 ~ 9.999999
	 *  Math.random(10) * 1 + 1 => 1.0 ~ 10.999999
	 *  (int)(Math.random()* 10 + 1) => 1 ~ 10
	 * 
	 */
	public static void method4() {	
		
		int random = (int)(Math.random() * 10 + 1 );
		
		int total = 0;
		// 1부터 random값 까지의 총합
		for (int i= 1 ; i <= random  ; i++)
		{
			total += i;				
		}
		
		System.out.printf("1~%d까지 총 합 : %d", random, total);
	}	

	/*
	 * 구구단을 출력 ( 2단 ~ 9단 출력)
	 * 
	 */
	public static void method5() {	
		
		for (int dan = 2; dan <=9; dan ++)
		{
			for(int j = 1; j <= 9; j++ )
			{
				System.out.printf("%d X %d = %d \n", dan, j, dan*j );
			}
		}
	}	
	
	
}
