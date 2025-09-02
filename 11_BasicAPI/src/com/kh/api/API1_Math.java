package com.kh.api;

public class API1_Math {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 상수 파이
		System.out.println("파이 : " + Math.PI);
		
		// 상수 파이
		System.out.println("랜덤값 : " + Math.random());	
		
		// 절대값 알려주는 메소드 (ABS)
		int num = -123;
		System.out.println("절대값 : " + Math.abs(num) );				
	
		// 제곱값 알려주는 메소드 (pow)
		System.out.println("절대값 : " + Math.pow(2,10) );
		
		// 올림 메소드 (ceil)
	    double num2 = 12.49;		
		System.out.println("올림 : " + Math.ceil(num2) );		
		
		
		// 반올림 메소드 (round)	
		System.out.println("반올림 : " + Math.round(num2) );	// 정수형 리턴 			
		
		// 버림 메소드 (floor)	
		System.out.println("버럼 : " + Math.floor(num2) );	// 정수형 리턴		
		
		
		// Math math = new Math();  --> 객체 생성이 불가능
		
        /*
         * Math 클래스
         * - 패키지 경로 : java.lang
         * * 모든 필드는 상수 필드, 모든 메소드는 stattic 메소드
         *   생성자가 private 으로 되어 있어서 생성 불가능
         *   한번만 메모리 영역에 올려놓고 재사용하는 개념 => 싱글톤 패턴
         *   
         */
	}

}
