package com.kh.object.basic;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 정의해 둔 Person 클래스 사용
		// => 사용하기 위해서 객체를 생성해야 함!
		
		// * 변수 선언 : 클래스명 변수명;
		
		Person p1;  // 선언만 했을 경우, 변수는 null 값을 가지고 있는 상태일 것임!
		
		// * 객체 생성 (인스턴스 생성) 및 할당
		//  변수명 = new 클래스명(); => 클래스명 : 생성자
		p1 = new Person();
		
		// * 인스턴스(객체) 변수에 접근 : 변수명.필드명
		p1.name = "정재환";
		p1.age = 40;
		
		// * 인스턴스 메소드에 접근 : 변수명.인스턴스메소드명()
		
		p1.introduce();
		
		// * 선언과 할당을 동시에
		
		Person p2 = new Person();
		
		p2.name = "정진성";
		p2.age = 25;		
		p2.introduce();
		
		Person p3 = new Person("아이유", 33);	
		p3.introduce();		
	}

}
