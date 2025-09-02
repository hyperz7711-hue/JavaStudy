package com.kh.api;

public class API4_Wrapper {
	/* 
	 *  Wrapper 클래스 : 기본 자료형을 객체화해주는 클래스
	 *  
	 *  boolean  ---> Boolean
	 *    char   ---> Character
	 *    byte   ---> Byte
	 *    short  ---> Short
	 *    int    ---> Integer
	 *    long   ---> Long
	 *    float  ---> Float
	 *    double ---> Double
	 *    
	 *   기본자료형을 객체화하는 이유
	 *   - 다형성을 적용시키고 싶을 때
	 *   - 메소드 호출 시 매개변수가 기본자료형이 아닌 객체 타입만 요구될 때 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// * Boxing : 기본자료형 ->  Wrapper 클래스 (객체화)
		
		int n1 = 100;
		int n2 = 200;
		
		// n1.equals(n2) --> 기본자료형은 equals 사용 불가
		
		// 레퍼 클래스를 사용하여 변환
		
		Integer i1 = Integer.valueOf(n1);
		Integer i2 = Integer.valueOf(n2);
		
		System.out.println(i1); 	
		System.out.println(i2); 
		System.out.println(i1.equals(i2)); 	
		System.out.println(i1.compareTo(i2)); // 앞쪽의 값이 크기 1, 뒤쪽의 값이 크기 -1, 같으면 0을 반환
		
		// 레퍼 클리스 없이 반환
		
		Integer i3 = n1;
		Integer i4 = n2;	
		System.out.println("=".repeat(20));
		
		System.out.println(i3); 	
		System.out.println(i4); 
		System.out.println(i3.equals(i4)); 	
		System.out.println(i3.compareTo(i4)); // 앞쪽의 값이 크기 1, 뒤쪽의 값이 크기 -1, 같으면 0을 반환
		
		Integer i5 = Integer.valueOf("500");
		Integer i6 = Integer.valueOf("700");	
		
		System.out.println(i5); 	
		System.out.println(i6); 		
		
		// unboxing Wrapper 클래스 ==> 기본자료형
		// 레퍼클래스에서 제공하는 메소드 사용
		
		int n3 = i3.intValue();
		int n4 = i4.intValue();
		
		int n5 = i5;
		
	}

}
