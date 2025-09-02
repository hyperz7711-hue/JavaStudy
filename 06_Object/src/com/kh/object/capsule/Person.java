package com.kh.object.capsule;

public class Person {
	// ---------------- 필드 정의
		// 이름 -> String name;
		// 나이 -> int age;
		
		private String name;     // 이름
		private int age;	
		
		// ---------------- 생성자부 정의 ----------	
//		public Person() {} // 기본연산자
		// 클래스 오버로딩
		public Person() {}
		public Person(String name, int age) {}		
		// * private 변수의 값을 조회 또는  변경하기 위한 메소드
		// => getter / setter 메소드 정의
		//     - getter : 해당 필드의 값을 반환 (조회용)
		//     - setter : 해당 필드의 값을 전달된 값으로 변경 (변경용)  
		
		// name 필드의 getter 메소드 정의
		public String getName() {
			return name;
			// return this.name;
		}
		
		// name 필드의 setter 메소드 정의
		public void setName(String name) {			
			this.name = name;		
		}	
		
		// age 필드의 getter 메소드 정의
		public int getAge() {
			return this.age;
			// return this.name;
		}
		
		// age 필드의 setter 메소드 정의
		public void setAge(int age) {			
			this.age = age;
			
		}

		// ---------------- 메소드 정의 ----------	

		public void introduce ( ) {
		 System.out.println("안녕하세요.");
		 System.out.println("저는 " + name +"입니다. " );
		 System.out.println("나이는 " + age  +"살입니다. " );
		}
	}

