package com.kh.object.access;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // AccessTest 객체 생성
		
		AccessTest test = new AccessTest();
		
		// public 멤버 접근
		
		System.out.println(test.publicField); 
		test.publicMethod();
		
		// protected 멤버 접근 o --> 같은 패키지 (상속도 가능)
		System.out.println(test.protectedField); 
		test.protectedMethod();		
		
		// default 멤버 접근 o --> 같은 패키지
		
		System.out.println(test.defaultField); 
		test.defaultMethod();			
		
		// private 멤버 접근 x --> 클래스가 다르기 때문
		
//		System.out.println(test.privateField); 
//		test.privateField();	
		
		// => private 제한자 사용 이유
		// : 객체의 데이터를 외부로부터 안전하게 보호하기 위함 (정보은닉)
		// 객체 지향 핵심 원리 중 하나인 캡슐화를 실현하는 데 사용
		
		
		
	}

}

