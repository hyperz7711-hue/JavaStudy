package com.kh.object.practice2.model.vo;

public class Book {
	
	
	// 변수 선언
	private String title;
	private String publisher;
	private String author;
	private int price;
	private double discountRate;
	
	
	 // ---- 생성자 부 ----------------------
	public Book() {	
	}
	public Book(String title, String publisher, String author ) {	
		
		this.title = title;
		this.publisher = publisher;
		this.author = author;		
	}
	public Book(String title, String publisher, String author, int price, double discountRate) {
		
		this.title = title;
		this.publisher = publisher;
		this.author = author;		
		this.price = price;	
		this.discountRate = discountRate;			
	}	

	// ---- 메소드 부 ---------------------
	public void inform() {
		System.out.printf("도서명: %s 저자명: %s 출판사 : %s 가격 : %d 할인율 : %.2f  \n", title,author, publisher, price,discountRate  );
	}
	
	// getter / setter 
	public String getTitle() {
		return title;

	}
	
	public void setTitle(String title) {			
		this.title = title;		
	}	
	
	public String getPublisher() {
		return publisher;

	}
	
	public void setPublisher(String publisher) {			
		this.publisher = publisher;		
	}		
	
	public String getAuthor() {
		return author;

	}
	
	public void setAuthor(String author) {			
		this.author = author;		
	}		
	
	public int getPrice() {
		return this.price;

	}
	
	public void setPrice(int price) {			
		this.price = price;
		
	}	
	
	public double getDiscountRate() {
		return this.price;

	}
	
	public void setDiscountRate(double discountRate) {			
		this.discountRate = discountRate;
		
	}		
	
}
