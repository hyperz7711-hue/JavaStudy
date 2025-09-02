package com.kh.run;

import java.util.Scanner;

import com.kh.model.vo.Student;

public class Run {
	/*
	 * 	// * 객체 배열 : 여라 개의 객체를 저장하는 구조
	 * 
	 * * 선언
	 *        클래스명[] 변수명;
	 *        클래스명 변수명[];
	 * * 할당(생성)
	 *        변수명 = new 클래스명[배열크기];
	 *        
	 * * 배열에 값을 초기화(대입)
	 *        변수명[인덱스] = new 클래스명();
	 *                      
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 크기가 3인 정수형 배열 선언 및 할당
		// * 자료형[] 배열명 = new 자료형[배열크기];
		
		int[] num = new int[3];
		
		String name;
		int age;
		double score;
		
		
		Scanner sc = new Scanner(System.in);
		
		Student[] st = new Student[3];
		
//		st[0] = new Student("가릉기", 22, 90.5);
//		st[1] = new Student("나도한", 24, 70.5);	
//		st[2] = new Student("미르기", 26, 80.4);	
//		
//		
//		st = new Student[] {new Student("aaa", 22, 90.5), new Student("bbb", 24, 70.5), new Student("ccc", 26, 80.4) };

		
		for (int i = 0 ; i < st.length; i++) {
	
			System.out.print("이름 : ");
			name = sc.next();
			System.out.print("나이 : ");
			age = sc.nextInt();
			
			
			System.out.print("성적 : ");
			score = sc.nextDouble();

			st[i] = new Student(name, age, score);
			

		}		
		
		for (Student s :st) {
			
		   s.printInfo();
		}
	}

}
