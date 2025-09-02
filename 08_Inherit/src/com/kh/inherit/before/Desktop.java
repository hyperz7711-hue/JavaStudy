package com.kh.inherit.before;

public class Desktop {
	
	private String brand;
	private String code; 
	private String name; 
	private int price;
	private boolean allInOne;
	
	public Desktop(String brand,String code, String name, int price, boolean allInOne ) {
		
		this.brand = brand;
		this.code = code;
		this.name= name;
		this.price = price;
		this.allInOne = allInOne;
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

	public boolean isAllInOne() {
		return allInOne;
	}

	public void setAllInOne(boolean allInOne) {
		this.allInOne = allInOne;
	}


	public String Information() {
		
		String info ="brand: " + brand + ", code :" + code + ", name :" + name + ", price :" + price + ", allInOne :" + allInOne;
		return info;
	}
	
	

}
