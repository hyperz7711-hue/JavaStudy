package com.kh.loop;


public class B_While {
	/*
	 * while 문
	 * [표현식]
	 * 
	 * [초기식;]
	 * while (조건식) {
	 *          // 반복할 내용
	 *          [증감식;]
	 *  }
	 *  * 실행 순서
	 *      조건 식 검사 -> 조건식 결과가 true인 경우 반복할 내용 수행
	 *      -> 조건식 검사 -> 조건식 걸과가 true인 경우 반복할 내용 수행
	 *      --------- 반복 -----------
	 *      -> 조건식 검사 --> 조건식 결과 false 경우 반복문 종료
	 */
	
	
	
	public static void main(String[] args) {

      // "happy" 5번 출력 -> while문 사용
		
		int i = 0;
		
		while (i < 5) {
			
		System.out.println("Happy");
		i++;
		
		}
	}	

}
