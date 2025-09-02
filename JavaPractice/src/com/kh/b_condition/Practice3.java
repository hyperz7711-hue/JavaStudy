package com.kh.b_condition;

import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		method1();

	}
	
	public static void method1() {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		/*
		 * 90점 이상 : A 80 ~ 89 : B 70 ~ 79 : C 69 : F
		 * 
		 * 점수를 입력하세요(0-100) :
		 * 
		 * 점수를 올바르게 입력해주세요.
		 */
		
		System.out.print("점수를 입력하세요(0-100) : ");
		if (chk_int(sc) == false)  return;                      // 체크로직으로 생략 가능
		
		int num = sc.nextInt();
		
		if (num >= 0 && num <= 100) {
			if (num >= 90) {
				System.out.println("A");
			} else if (num >= 80 && num < 90) {
				System.out.println("B");
			} else if (num >= 70 && num < 80) {
				System.out.println("C");
			} else {
				System.out.println("F");
			}
		} else {

			System.out.println("점수를 올바르게 입력해주세요.");
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
