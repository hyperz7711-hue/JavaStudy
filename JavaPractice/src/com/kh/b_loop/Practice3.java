package com.kh.b_loop;

import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method2();

	}

	public static void method1() {

		Scanner sc = new Scanner(System.in);

		int num1, num2;

		System.out.print("첫 번째 숫자 :");

		if (chk_int(sc) == false)
			return;

		num1 = sc.nextInt();

		System.out.print("두 번째 숫자 :");

		if (chk_int(sc) == false)
			return;

		num2 = sc.nextInt();

		if (num1 < 1 || num2 < 1) {
			System.out.println("1 이상의 숫자를 입력해 주세요.");
		} else if (num2 >= num1) {
			for (int i = num1; i <= num2; i++) {
				System.out.print(i + " ");
			}
		} else if (num1 > num2) {
			for (int i = num2; i <= num1; i++) {
				System.out.print(i + " ");
			}
		}

	}
	
	public static void method2() {

		Scanner sc = new Scanner(System.in);

		int num1, num2;

		System.out.print("첫 번째 숫자 :");

		if (chk_int(sc) == false)
			return;

		num1 = sc.nextInt();

		System.out.print("두 번째 숫자 :");

		if (chk_int(sc) == false)
			return;

		num2 = sc.nextInt();

		int max = num1 > num2 ? num1 : num2;
		int min = num1 > num2 ? num2 : num1;		
		
		for (int i = min; i <= max; i++) {
			System.out.print(i + " ");
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
