package com.kh.collection.map.model.vo;

public class Snack {
	
	private String flavor; // 맛
	private int calory;    // 칼로리
	public Snack() {}
	public Snack(String flavor, int calory) {

		this.flavor = flavor;
		this.calory = calory;
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	public int getCalory() {
		return calory;
	}
	public void setCalory(int calory) {
		this.calory = calory;
	}
	@Override
	public String toString() {
		return "Snack [flavor=" + flavor + ", calory=" + calory + "]";
	}
	
	// 기본 생성자
	
	

}
