package com.kh.exception;

import java.util.Scanner;

public class A_UnCheckedException {
	/*
	 * RuntimeException : 프로그램 실행 시 발생하는 예외들
	 * 
	 * - IndexOutofBoundsException : 배일이나 리스트 등에 부적절한 인덱스로 접근시 발생 
	 * - NullPointException : 참조변수가 null인 상태에서 객체 멤버로 접근할 때 발생 
	 * - ArithmeticException:나누기 연산에서 0으로 나눌 때 발생 
	 * - ClassCastException : 허용되지 않는 객체로 형변환을 시도할 때 발생 
	 * - NegativeArraySizeException : 배열을 생성할 때 크기를 음수로 지정하면 발생
	 * 
	 * => RumtimeException 계열 예외는 대부분 예측 가능한 상황에서 발생 그렇기 때문에 if 문 조건 처리를 통해 애초에 예외가
	 * 발생하지 않도록 방지 가능!
	 */

	// ---------- 필두부-----------------
	private Scanner sc = new Scanner(System.in);

	public void test1() {
		// ArithmeticException

		System.out.print("정수 1 :");
		int n1 = sc.nextInt();

		System.out.print("정수 2 :");
		int n2 = sc.nextInt();
		try {
			int result = n1 / n2;
			System.out.println("결과는.... " + result);
		} catch (ArithmeticException e) {
			System.out.println("정수 2의 입력값은 0으로 나눌 수 없습니다. ");
			System.out.println(e.getMessage());
			e.printStackTrace(); // 예외정보, 발생지점을 확인할 수 있음

		}
		System.out.println("작업 끝!!");
		// 두번째 입력값(n2)이 0 인 경우 예외 발생. => 프로그램이 비정상적으로 종료됨

	}

	public void test2() {
		// NegativeArraySizeException

		System.out.print("배열 크기: ");
		int size = sc.nextInt();
	
		// * 조건 처리
		/*
		if (size >=77) {
		int[] arr = new int[size];
		System.out.println("77번 위치의 값" + arr[77]);
		}
		*/

		try {
			int[] arr = new int[size];
			System.out.println("77번 위치의 값" + arr[77]);			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 범위를 벗어난 접근 발생!!");
		}catch(NegativeArraySizeException e) {
			System.out.println("배열크기를 음수로 지정할 수 없음!!");
		}
		System.out.println("작업 끝!!");
		// 여러개의 catch 사용 가능

	}	
	
	public void test3() {
		
		System.out.print("배열 크기: ");
		int size = sc.nextInt();	
		
		try {
			int[] arr = new int[size];
			System.out.println("77번 위치의 값" + arr[77]);			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 범위를 벗어난 접근 발생!!");
		}catch(NegativeArraySizeException e) {
			System.out.println("배열크기를 음수로 지정할 수 없음!!");
		}catch(RuntimeException e) {
			// ==> 다형성을 활용하여 부모타입으로 catch 블록 작성 가능
			//  모든 자식 예외 밠생시 처리 가능
			
			System.out.println("인덱스가 잘못되었거나, 배열크기가 음수인 경우.....");			
		}
		// 이때 순서에 유의해야 함! (부모 타입보다 자식타입이 위쪽에 작성되어야 함)
		
		System.out.println("작업 끝!!");
		// 여러개의 catch 사용 가능		
		
	}
	
}
