package com.kh.b_condition;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method2();

	}
	
	public static void method1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. 입력 ");	
		System.out.println("2. 수정 ");	
		System.out.println("3. 조회 ");	
		System.out.println("4. 삭제 ");	
		System.out.println("7. 종료 ");	
		
		System.out.print("메뉴 번호를 입력하세요 : ");
		int num = sc.nextInt();
		
		
		switch(num) {
		
		case 1 :
			System.out.printf("입력 메뉴입니다.");	
			break;
			
		case 2 :
			System.out.printf("수정 메뉴입니다.");	
			break;
			
		case 3 :
			System.out.printf("조회 메뉴입니다.");	
			break;
			
		case 4:
			System.out.printf("삭제 메뉴입니다.");	
			break;
			
		case 7 :
			System.out.printf("프로그램이 종료됩니다.");	
			break;	
		default :
			System.out.printf("잘못 입력하였습니다.");	
			break;				
		}
     
		sc.close();
	}	
	
	public static void method2() {
		
		Scanner sc = new Scanner(System.in);
		
		String[] str = {"1. 입력 ", "2. 수정 ", "3. 조회 ", "4. 삭제 ", "7. 종료 "};
		String[] str2 = {"", "입력 ", "수정 ", "조회 ", "삭제 ","", "", "종료 "};	
		String str3 =" 메뉴입니다.";
		
		for ( int i = 0; i < str.length; i ++ )
		{
			System.out.println(str[i]);		
			
		}
				
		System.out.print("메뉴 번호를 입력하세요 : ");
		int num = sc.nextInt();
		
		
		if (num < 7)
		{
			if (num > 0 && num < 5 )
			{
			System.out.printf(str2[num] + str3 );	
			}
			else
			{
				System.out.printf("잘못 입력하였습니다.");					
			}

		}
		else if ( num == 7 )
		{
			System.out.printf("프로그램이 종료됩니다.");			
		}
		else
		{
			System.out.printf("잘못 입력하였습니다.");			
		}			 
			

     
		sc.close();
	}		

}
