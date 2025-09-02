package com.kh.inter.ext1;

public interface Animal {

	// 상수 필드와 추상 메소드로 구성됨!
	// 추상 메소드 -> 몸체(구현)가 없는 메소드. 미완성 메소드!	
	public abstract void move();
	public /*abstract*/ void eat();
	/*public abstract*/ void makeSound();
}
