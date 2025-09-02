package com.kh.loop;

public class D_Break {
	/*
	 * 분기문 : break;
	 * ==> 반복문 내에서 사용 시 가장 가까운 반복문을 종료!
	 */
	public static void main(String[] args) {

		// 1 ~ 100사이의 랜덤값을 추출하여 출력 => 랜덤값 : 
		// 단, 해당값이 짝수일 경우 반복문 종료

		while(true)
		{
			int random = (int)(Math.random() * 100 + 1 );
			if (random % 2 == 0) {
				System.out.printf("반복문 종료 -->  %d \n", random);	
				break;
			}
			System.out.printf("랜덤값 :  : %d \n", random);		
			
		}
		
		
	}
}
