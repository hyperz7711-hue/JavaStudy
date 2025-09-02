package com.kh.method;

/*
 * 메소드에서 return의 의미!
 * : (1) 반환 값을 돌려줌 -> return 값;
 *   (2) 메소드 종료 -> return;
 *  
 */

public class Method3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		divide(50, 7);
		
		divide(100, 0);

	}
	
	public static void divide(int n1, int n2) {
		
		if (n2==0) {
			System.out.printf("0으로 나눌 수 없습니다.");
			return;
		}
			
		
		System.out.printf("%d / %d = %d \n", n1, n2, n1/n2);
	}

}
