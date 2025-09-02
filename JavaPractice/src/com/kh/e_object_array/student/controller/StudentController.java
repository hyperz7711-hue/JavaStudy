package com.kh.e_object_array.student.controller;

import com.kh.e_object_array.student.model.vo.Student;

public class StudentController {
	
	public final int CUT_LINE = 60;
	

	Student[] sArr = new Student[5];
	
	
	public StudentController() {
		
	}
	
	public Student[] printStudent() {
		
		sArr[0] = new Student("김길동", "자바", 100);
		sArr[1] = new Student("박길동", "디비", 50);
		sArr[2] = new Student("이길동", "디비", 85); 
		sArr[3] = new Student("정길동", "서버", 60);
		sArr[4] = new Student("홍길동", "자바", 20);
		
		return sArr;
	}
	
	public int sumScore() {
		
		int sumScore = 0;
		
		for (int i =0; i < sArr.length; i++) {
			sumScore += sArr[i].getScore();
		}
		
		return sumScore;
	}	
	
	
	public double[] avgScore() {
		double[] avgScore = new double[2];
		double sum = sumScore();
		double avg = sArr.length;
		
		avgScore[0] = sum;
		
		avgScore[1] = sum / avg;
		
		return avgScore;
		
	}		

}
