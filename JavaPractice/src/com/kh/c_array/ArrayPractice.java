package com.kh.c_array;

import java.util.Scanner;


public class ArrayPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Practice1();
		// Practice2();
		// Practice3();
		// Practice4();
		// Practice5();
		// Practice6();
		// Practice7();
	}

	public static void Practice1() {
        
		int[] num = new int[10];
		
        for (int i=0; i < num.length; i++) {
        	
        	num[i] = i + 1;
        	 System.out.print(num[i] + " ");
        }
    	
    		
	}
		
	public static void Practice2() {
        
		int[] num = new int[10];
		
        for (int i=0; i < num.length; i++) {
        	
        	num[i] = num.length - i;
        	 System.out.print(num[i] + " ");
        }
    	
    		
	}
			
	public static void Practice3() {
        
		
		Scanner sc = new Scanner(System.in);
		
				
        System.out.print("양의 정수 : ");
        
		if (chk_int(sc) == false)
			return;       
        
    	int cnt = sc.nextInt();
        
    	int[] num = new int[cnt];
    	

    	
    	if ( cnt > 0 ) {
    		
            for (int i=0; i < num.length; i++) {
            	
            	num[i] = i + 1;
            	 System.out.print(num[i] + " ");
            } 			
    	}
    	else{
            System.out.print("잘못 입력하였습니다."); 	
    	}
    	
    		
	}
			
	public static void Practice4() {
        
		String[] week = {"월","화","수","목","금","토","일"};
		
		Scanner sc = new Scanner(System.in);
		
				
        System.out.print("0 ~ 6 사이의 숫자 입력 :");
        
		if (chk_int(sc) == false)
			return;       
        
    	int num1 = sc.nextInt();
         
    	if ( num1 >= 0 && num1 <= 6) {
            System.out.print(week[num1]);		
    	}
    	else{
            System.out.print("잘못 입력하였습니다."); 	
    	}
    	
    		
	}
	
	public static void Practice5() {
		
		int[] num = new int[10];
		int randomNumber;

		
		for (int i=0;i<num.length; i++) {
			randomNumber = (int)(Math.random()*10 +1);
			num[i] = randomNumber;
			System.out.print(num[i]  + " ");	
					
		}
				
	}	
	
	public static void Practice6() {
		
		int[] num = new int[10];
		int randomNumber;
		int min = 10, max = 0;

		
		for (int i=0;i<num.length; i++) {
			randomNumber = (int)(Math.random()*10 +1);
			num[i] = randomNumber;
			
			if ( randomNumber > max)
			{
				max = randomNumber;
			}
			
			if (randomNumber <= min )
			{
				min = randomNumber;				
			}
			
			System.out.print(num[i]  + " ");	
					
		}
		System.out.println();	
		System.out.println("최대값 : " + max);	
		System.out.println("최소값 : " + min);		
				
	}	
	
	public static void Practice7() {
		
		int[] lotto = new int[6];
		int randomNumber;

		
		for (int i=0;i<lotto.length; i++) {
			
			randomNumber = (int)(Math.random()*45 +1); // 랜덤값 함수 
			
			lotto[i] = 	randomNumber;	
			
			for ( int j=0; j < i; j++ ) {
				   
				if (lotto[i] == lotto[j])
				{
					i--;
					break;			
				}
	
			}			
					
		}
		
		for (int i=0;i<lotto.length; i++) {		
		System.out.print(lotto[i]  + " ");		
		}
		
	}
	public static boolean chk_int(Scanner sc) {

		int cnt = 0;

		while (!sc.hasNextInt()) {

			System.out.print("입력된 값이 정수가 아닙니다. 정수로 재입력하세요: ");
			sc.next();

			cnt++;
			if (cnt > 4) {
				System.out.print("입력 오류가 " + cnt + "회 초과되었습니다. 프로그램을 종료합니다. ");
				break;

			}

		}
		if (cnt > 4)
			return false;
		else
			return true;
	}
	
}
