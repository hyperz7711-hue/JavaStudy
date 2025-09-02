package com.kh.b_loop;

import java.util.Scanner;

public class Practice5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		method1();

	}
	
	public static void method1() {
		
		Scanner sc = new Scanner(System.in);	
		
		System.out.print("정수 입력 :");
		
	    if (chk_int(sc) == false)  return; // 정수값 미입력 시 시스템 에러 방지용 코드
		
		int num1 = sc.nextInt();
				
		
		for (int i = 0; i < num1; i++) {
							
			for(int j = num1 ; j > i  ; j--){
				
				System.out.print("*");
			}			
			System.out.println();
		}
		
		sc.close();
		
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