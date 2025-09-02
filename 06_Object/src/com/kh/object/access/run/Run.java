package com.kh.object.access.run;

import com.kh.object.access.AccessTest;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // AccessTest 객체 생성
		
		AccessTest test = new AccessTest();
		
		// public 멤버 접근
		
		System.out.println(test.publicField); 
		test.publicMethod();
		
		// protected 멤버 접근 x --> 패키지가 다르기 때문
		
//		System.out.println(test.protectedField); 
//		test.protectedMethod();		
		
		// default 멤버 접근 x --> 패키지가 다르기 때문
		
//		System.out.println(test.defaultField); 
//		test.defaultMethod();			
		
		// private 멤버 접근 x --> 패키지가 다르기 때문
		
//		System.out.println(test.privateField); 
//		test.privateField();	
		
	}

}
