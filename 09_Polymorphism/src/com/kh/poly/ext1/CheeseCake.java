package com.kh.poly.ext1;

public class CheeseCake extends Cake {
	
	public void yummy() {
		System.out.println("cheese cake yummy!");
	}
	
	// sweet() 재정의
	@Override
	public void sweet() {
		System.out.println("cheese cake sweet!");		
	}
	

}
