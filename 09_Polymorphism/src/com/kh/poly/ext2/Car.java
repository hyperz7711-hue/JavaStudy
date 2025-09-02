package com.kh.poly.ext2;

public class Car {

	private String Color;
	private String fuel;
	private int year;
	
	public Car() {
		
	}

	public Car(String Color, String fuel, int year ) {
		
		this.Color = Color;
		this.fuel = fuel;
		this.year = year;
		}
	
	public void drive() {
		System.out.println("car driven =");
	}
	

	@Override
	public String toString() {
		return "Car [Color=" + Color + ", fuel=" + fuel + ", year=" + year + "]";
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
}
