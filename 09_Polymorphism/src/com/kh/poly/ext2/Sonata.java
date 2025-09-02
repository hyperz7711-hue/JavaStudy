package com.kh.poly.ext2;

public class Sonata extends Car{
	


	public Sonata(String Color, String fuel, int year) {
		super(Color, fuel, year);
	}

	public void moveSonata() {
		System.out.println("move Sonata");
	}
    
	@Override
	public void drive() {
		System.out.println("Sonata~ drive =");
	}	
	
}
