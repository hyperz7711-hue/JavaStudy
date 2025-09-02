package com.kh.b_condition;

import java.util.Scanner;

public class Practice4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		method1();

	}

	/*
	 * 키보드로 두 개의 정수와 연산 기호를 입력 받아 연산 기호에 맞춰 연산 결과를 출력하세요. (단, 두 개의 정수 모두 양수일 때만 작동하며
	 * 없는 연산 기호를 입력했을 시 “잘못 입력하였습니다. 프로그램을 종료합니다.” 출력)
	 */

	public static void method1() {

		int num1 = 0, num2 = 0, calnum = 0;
		String symbol;
		char calsymbol;

		Scanner sc = new Scanner(System.in);

		System.out.print("피연산자 1 입력 : ");
		if (chk_int(sc) == false)
			return;

		num1 = sc.nextInt();

		System.out.print("피연산자 2 입력 : ");
		chk_int(sc);

		num2 = sc.nextInt();

		sc.nextLine();

		System.out.print("연산자 입력 ( +, -, *, /, % ) : ");

		symbol = sc.nextLine();

		if (symbol.length() > 1) {
			System.out.println("잘못 입력하였습니다. 프로그램을 종료합니다.");
			return;
		}

		if (symbol.charAt(0) == '+' || symbol.charAt(0) == '-' || symbol.charAt(0) == '*' || symbol.charAt(0) == '/'
				|| symbol.charAt(0) == '%') {

			calsymbol = symbol.charAt(0);

			switch (calsymbol) {

			case '+':
				calnum = num1 + num2;
				break;
			case '-':
				calnum = num1 - num2;
				break;
			case '*':
				calnum = num1 * num2;
				break;
			case '/':
				if (num2 == 0) {
					System.out.println("0으로 나눌 수 없습니다. 프로그램을 종료합니다.");
					return;
				}
				calnum = num1 / num2;
				break;
			case '%':
				if (num2 == 0) {
					System.out.println("0으로 나눌 수 없습니다. 프로그램을 종료합니다.");
					return;
				}
				calnum = num1 % num2;
				break;
			default:
				break;
			}

			System.out.printf("%d %s %d = %d", num1, calsymbol, num2, calnum);
		} else {

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