package com.kh.object.practice2;

import java.util.Scanner;

import com.kh.object.practice2.model.vo.Book;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Book b1 = new Book();
		Book b2 = new Book();
		Book b3 = new Book();
		
		// GETTER와 SETTER를 사용하여 변수 입력 후 출력
		b1.setTitle("객체지향의 사실과 오해");
		b1.setAuthor("조영호");
		b1.setPublisher("위키북스");
		b1.setPrice(25000);
		b1.setDiscountRate(0.1);
		
	    b1.inform();
	    
		
		b2.setTitle("클린 코드");
		b2.setAuthor("로버트 C. 마틴");
		b2.setPublisher("인사이트");
		b2.setPrice(38000);
		b2.setDiscountRate(0.15);		
		
	    b2.inform();	 
	    
				
		
		b3.setTitle("실용주의 프로그래머");
		b3.setAuthor("앤드류 헌트, 데이비드 토마스");
		b3.setPublisher("인사이트");
		b3.setPrice(35000);
		b3.setDiscountRate(0.15);		
		
	    b3.inform();	 	    
	    
	   // 클래스에 변수 입력 후 출력
	    System.out.println("=======다른 대입방법2=============");	    
	    b2= new Book("클린 코드","로버트 C. 마틴", "인사이트"  );
	    b3 = new Book("실용주의 프로그래머","앤드류 헌트, 데이비드 토마스", "인사이트", 35000, 0.15  );
	    
	    b1.inform();
	    b2.inform();	
	    b3.inform();
	    
	    // 하나의 클래스에 반복해서 변수를 변경하여 출력
	    System.out.println("=======다른 대입방법3=============");
	    
		Book b4 = new Book();
		
		b4.setTitle("객체지향의 사실과 오해");
		b4.setAuthor("조영호");
		b4.setPublisher("위키북스");
		b4.setPrice(25000);
		b4.setDiscountRate(0.1);	
		
		b4.inform();
		
		b4 = new Book("클린 코드","로버트 C. 마틴", "인사이트"  );
		
		b4.setPrice(38000);
		b4.setDiscountRate(0.15);	
		
		b4.inform();		
		
		b4 = new Book("실용주의 프로그래머","앤드류 헌트, 데이비드 토마스", "인사이트", 35000, 0.15  );
		
		b4.inform();
		
	    // 클래스 배열을 사용하여 입력값을 지정한 뒤 출력
	    System.out.println("=======클래스 배열 학습 후 입력값으로 도서정보 출력=============");
	    
		 String title;
		 String publisher;
		 String author;
		 int price;
		 double discountRate;	    
	    
		Book[] bm = new Book[3];
		
		Scanner sc = new Scanner(System.in);
		
		for (int i =0; i < bm.length; i++)
		{
			System.out.print("도서명: ");
			title = sc.next();
			System.out.print("저자명: ");
			publisher = sc.next();			
			System.out.print("출판사: ");
			author = sc.next();		
			System.out.print("가격: ");
			price = sc.nextInt();		
			System.out.print("할인율: ");
			discountRate = sc.nextDouble();					
			bm[i] = new Book(title, publisher,author, price, discountRate );
		}
		
		for (Book bt : bm )
		{
			bt.inform();
		}

	}

}
