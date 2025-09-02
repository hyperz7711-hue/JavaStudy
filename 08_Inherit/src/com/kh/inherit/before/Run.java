package com.kh.inherit.before;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Desktop dt = new Desktop("LG","LG-001","사무용PC",1000000, false);
		
		System.out.println(dt.Information());
		
		TV tv = new TV("삼성","SS-001","LED TV",1500000, 55);
		
		System.out.println(tv.Information());		

	}

}
