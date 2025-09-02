package com.kh.a_basic;

import java.util.Scanner;

public class OperatorPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Practice1(); */
		
		// Practice2(); 
		
		// Practice3(); 
		// Practice4(); 
		
		Practice5(); 

	}
	
	public static void Practice1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수: ");	
		int n1 = sc.nextInt();
		
		String result = n1 > 0 ? "양수다" : "양수가 아니다";
		
		System.out.printf(result);	
		
		sc.close();


	}	
	
	public static void Practice2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수: ");	
		int n1 = sc.nextInt();
		
		String result = n1 > 0 ? "양수다" : n1 == 0 ? "0이다" : "음수다";
		
		System.out.printf(result);	
		
		sc.close();


	}		
	
	public static void Practice3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수: ");	
		int n1 = sc.nextInt();
		
		String result = n1 % 2 == 0 ? "짝수다" : "홀수다";
		
		System.out.printf(result);	
		
		sc.close();


	}	
	
	public static void Practice4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인원수: ");	
		int n1 = sc.nextInt();
		
		System.out.print("사탕 개수: ");	
		int n2 = sc.nextInt();		
		
		String result = n1 % 2 == 0 ? "짝수다" : "홀수다";
		
		System.out.printf(result);	
		
		sc.close();


	}	
	
	public static void Practice5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름: ");	
		String name = sc.nextLine();
			
		
		System.out.print("학년: ");	
		chk_int(sc);
		int grade = sc.nextInt();	
		
		System.out.print("반: ");
		chk_int(sc);		
		int classNumber = sc.nextInt();	
		
		System.out.print("번호: ");	
		chk_int(sc);		
		int PersonN = sc.nextInt();		
		
		sc.nextLine();			
		
		System.out.print("성별: ");	
		chk_gender(sc);
    	String strGender = sc.nextLine().toUpperCase();	
    	
    	String genderGubun = strGender.charAt(0) == 'M' ? "남학생" : "여학생";				
		
		System.out.print("성적: ");	
		chk_double(sc);		
		double rlstNumber = sc.nextDouble();		
		
		
		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f이다.", grade,classNumber, PersonN, name, genderGubun, rlstNumber   );	
		
		sc.close();


	}	

	public static void chk_gender(Scanner sc)
	{	
		String strgender;
		
	    while (true) { // 올바른 값이 입력될 때까지 반복
	    	strgender = sc.nextLine(); // 사용자 입력 받기
            System.out.println("strgender = " + strgender.toUpperCase() );
            
	        if (strgender =="M" || strgender =="F"  ) { 
	        	
	            break; // 올바른 입력 시 루프 종료
	        } else {
	            System.out.println("잘못된 입력입니다. 성별은 M,F 로만 등록해야 합니다.");
	        }
	    }
	}
	

	
	
	public static void chk_int(Scanner sc)
	{
        while (!sc.hasNextInt())
        {
        	System.out.print("입력된 값이 정수가 아닙니다. 숫자로 재입력하세요: "  );
        	sc.next();

        }		
	}
	
	public static void chk_double(Scanner sc)
	{
        while (!sc.hasNextDouble())
        {
        	System.out.print("입력된 값이 실수가 아닙니다. 실수로 재입력하세요: "  );
        	sc.next();

        }		
	}	
		
	
}
