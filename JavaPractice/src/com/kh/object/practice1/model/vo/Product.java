package com.kh.object.practice1.model.vo;

public class Product {
    // 필드부
	/*
	 *  - productName : String
	 *  - price : int
	 *  - brand : String
	 *  - => private 접근제한자
	 *  productName => 변수명
	 *  String => 자료형
	 *  
	 *  접근제한자 변수명 : 자료형
	 */
	private String productName;
	private int price;	
	private String brand;	
	
    // ---- 생성자 부 ----------------------
	/*
	 *  + Product()
	 *  + => public 접근제한자
	 *  Product() => 기본생성자
	 *  접근제한자 생성자 
	 */
	public Product(){}
	
    // --------메소드 부 -----------
	/*
	 *  + setter()/getter()
	 *  + information() : void
	 *  
	 *  setter()/getter() -> private 필드에 대한 set메소드, get메소드
	 *  
	 *  접근제한자 메소드명([매개변수]) : 반환형
	 */
	// productName : String
    public String getProductName() {
    	
    	return this.productName;
    }
    
    public void setProductName(String productName) {
    	
    	this.productName = productName;
    }
       
    //price : int
    public int getPrice() {
    	return this.price;
    }
    
    public void setPrice(int price) {
    	this.price = price;
    }
      
    // brand : String
    public String getBrand() {
    	return this.brand;
    }
    
    public void setBrand(String brand) {
    	this.brand = brand;
    }   
	

    
    public void information() {
    	
    	// 출력결과 참고하여 기능 추가
    	// "이름 / 가격 / 브랜드 " 출력!
    	System.out.printf("%s / %d / %s \n", productName, price, brand);
//    	System.out.print(this.productName + "/ ");
//    	System.out.print(this.price + "/ ");
//    	System.out.print(this.brand );  	
//    	System.out.println();
    }
}
