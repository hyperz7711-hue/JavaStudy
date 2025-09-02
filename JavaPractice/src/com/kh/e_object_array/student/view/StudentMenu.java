package com.kh.e_object_array.student.view;

import com.kh.e_object_array.student.controller.StudentController;
import com.kh.e_object_array.student.model.vo.Student;

public class StudentMenu {
	
	private StudentController ssm = new StudentController();
	
	public StudentMenu() {
		
		Student[] sArr = new Student[5];
		
		sArr = ssm.printStudent();
		
		int sumScore = ssm.sumScore();
		double avgScore = ssm.avgScore()[1];
		
		System.out.println("========== 학생 정보 출력 ==========");
		
		 for(Student s: sArr) {
			 
			 System.out.println(s.inform());
		 }
		 
			System.out.println("========== 학생 정보 출력 ==========");	
			
			 System.out.println("학생 성적 합계 : " + sumScore);	
			 System.out.println("학생 점수 평균 : " + avgScore);				 
			 
			System.out.println("========== 성적 결과 출력 ==========");
			
			String ctext = "학생은 ";
			String cPass ="통과입니다.";
			String cFail ="재시험 대상입니다.";
			
			 for(Student s: sArr) {
				 
				 if (s.getScore() >= ssm.CUT_LINE){
					 System.out.println(s.getName() + ctext + cPass);
				 }
				 else{
					 System.out.println(s.getName() + ctext + cFail);				 
				 }
			 }
			 

		
		
	}

}
