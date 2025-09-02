package com.kh.poly.ext1;

public class Run {
/*
 *  클래스명 참조변수            = new 클래스생성자;
 *  
 *  부모클래스가 올 수 있음        | 자식클래스로 생성할 수 있음
 *  
 *  실제로 어디까지 접근할 수 있는가? |  실제로 어떤 형태로 메모리에 생성되었는가? 
 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		Cake c1 = new CheeseCake();
		// ==> c1이라는 변수는 Cake의 멤버까지 접근 가능

		c1.sweet(); // =>sweet() : 오버라이딩된 메소드는 실제 메모리에 있는 재정의된 메소드가 실행됨!
		c1.milky();

		//c1.yummy(); // 실행불가 cake 멤버에 속하지 않기 때문
		
//		CheeseCake c2 = new Cake();
//		
//		// sweet()      sweet()
//		// milky()      milky() 
//		// yummy()      x  ==> 실행 불가
		
	}

}
