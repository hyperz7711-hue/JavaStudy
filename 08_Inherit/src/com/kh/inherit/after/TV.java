package com.kh.inherit.after;

public class TV extends Product{

	private int inch;
	
	public TV(String brand, String code, String name, int price, int inch) {
		super(brand, code, name, price);
		
		this.inch = inch;
		
	}

	@Override
	public String Information() {
		
		String info =  String.format("%s, inch : %d ",super.Information(), inch);
		
		return info;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}
	
}
