package com.kh.object.capsule;


public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person p1 = new Person();
		
//		p1.name = "홍길동"; // 직접 접근 불가
		
		p1.setName("홍길동"); // 직접 값을 변경하는 것이 아니라 setter를 통해 값을 간접적으로 변경
		
		// private 멤버 접근 x --> 클래스가 다르기 때문
		
		p1.introduce();
		
		// person 객체 생성 -> 내 이름, 나이 저장하여 출력하기
		Person my = new Person();	
		
		my.setName("정재환");
		my.setAge(30);	
		
		System.out.println(my.getName());
		System.out.println(my.getAge());		
		my.introduce();
				
//		System.out.println(test.privateField); 
//		test.privateField();	
		
		// => private 제한자 사용 이유
		// : 객체의 데이터를 외부로부터 안전하게 보호하기 위함 (정보은닉)
		// 객체 지향 핵심 원리 중 하나인 캡슐화를 실현하는 데 사용		

	}

}
