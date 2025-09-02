package com.kh.loop;

public class E_Continue {

	/*
	 * 분기문 : continue;
	 * ==> continue를 만나면 뒤에 문장들이 수행되지 않고 (무시되고)
	 *     증감식(for) 또는 조건식(while)으르 이동
	 */	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1~100까지의 합을 구하는데 3의 배수와 5의 배수는 합산에서 제외

		int total = 0;
		
		for(int i= 1; i <=100; i++) {
			
			if (i%3==0 || i%5==0) 
				continue;
			
			total += i;
		}
		System.out.println("1부터 100까지의 합 (3의 배수와 5의 배수는 제외) :"+ total);
	}

}
