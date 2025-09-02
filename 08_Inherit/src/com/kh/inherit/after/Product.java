package com.kh.inherit.after;

public class Product {
   //------------ 공통적인 필드 정의---------------------
	private String brand;
	private String code; 
	private String name; 
	private int price;	
   //------------ 공통적인 필드 정의---------------------
	
	//------------------생성자------------------------------
	public Product() {}
	public Product(String brand,String code, String name, int price) {
		
		this.brand = brand;
		this.code = code;
		this.name= name;
		this.price = price;

	}	
	//------------------------------------------------
	
	//----------------공통적으로 사용된 메소드--------------
	public String Information() {
		
		String info = String.format("brand: %s, code: %s, name: %s, price: %d", brand, code, name, price);
		return info;	
	}
		
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


}
