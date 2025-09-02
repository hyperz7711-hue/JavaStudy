package com.kh.poly.ext2;

public class Tico extends Car {

	public Tico(String Color, String fuel, int year) {
		super(Color, fuel, year);
	}
	
	public void moveTico() {
		System.out.println("move Tico~");
	}
    
	@Override
	public void drive() {
		System.out.println("Tico drive ~");
	}		

}
