package com.kh.poly.ext2;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car c1 = new Car("red","가솔린",2024);		
		Sonata c2 = new Sonata("black","고급휘발유",2025);
		
		c1.drive();
		System.out.println(c1.toString());
		
		c2.drive();		
		System.out.println(c2.toString());	
		c2.moveSonata();
		
		Car c3 = new Tico("grey","경유",2020);
		
		((Tico)c3).moveTico();  
		// 자식 개체의 멤버에 접근하고자 한다면 강제형변환 후 접근 가능!! => "다운캐스팅"
		c3.drive();
		
		/*
		 * 다형성 : 부모타입으로부터 파생된 자식 객체들을 부모 타입 하나로 다룰 수 있는 기술!
		 * 
		 * - 장점 : 하나의 부모타입만으로 여러 자식 객체들을 다를 수 있어 
		 *        "편리"하고 "코드 길이 감소" 됨!
		 *  클래스간의 형변환 (* 상속 관계에서만 가능 *)
		 *  - 업캐스팅 ( up casting)
		 *  : 자식 타입 -> 부모타입 형변환 (자동 형변환)
		 *  ex) Car c3 = (Car)new Genesis();
		 *  
		 *  - 다운캐스팅 (Down Casting)
		 *  : 부모타입 -> 자식 타입 형변환(강제 형변환)
		 *  ex) ((Tico)c3).moveTico();  
		 *  
		 *  *동적 바인딩
		 *   : 프로그램이 실행되기 전에는 컴파일 되면서 정적 바인딩됨
		 *    실질적으로 참조하는 자식 객체에 해당하는 메소드가 "오바라이딩" 되면서
		 *    프로그램 실행 시 동적으로 해당 메소드를 찾아서 실행. 
		 * 
		 * * 다형성 적용 전
		 */
		//* 다형성 적용 전
		System.out.println("======================================================");		
		Tico[] tArr = new Tico[3]; // Tico 개체만 담을 수 있음
		tArr[0] = new Tico("black","고급휘발유",2025);
	
		
		Sonata[] sArr = new Sonata[3];
		sArr[0] = new Sonata("black","고급휘발유",2025);	
		System.out.println("======================================================");	
		
		for(Tico tico : tArr ) {
			if (tico != null) {
			tico.drive();
			}
		}
		
		for(Sonata so : sArr ) {
			if (so != null) {		
			so.drive();
			}
		}	
		
		System.out.println("======================================================");
		// * 다형성 적용 후 *
		Car[] cArr = new Car[6];
		cArr[0] = new Car("White","휘발유",2021);	
		cArr[1] = new Tico("Blue","고급유",2023);		
		cArr[2] = new Sonata("black","경유",2025);
		
		for(Car c :cArr ) {
			if (c != null) {
				c.drive();
				
				// 해당 클래스 타입으로 생성된 인스턴스(객체)인지 확인
				
				if (c instanceof Tico) {
					((Tico) c).moveTico();
				}else if ( c instanceof Sonata) {
					((Sonata) c).moveSonata();
				}
					
			}
		}
	}

}

