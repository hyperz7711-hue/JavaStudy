package test;

import java.util.Scanner;

public class Practice1 {
	// 프로그램 시작은 main 메소드!
	public static void main(String[] args){
		
		// 1) 포함시키기
		Scanner sc = new Scanner(System.in);
		
		// "이름: " 출력
		System.out.print("이름: ");
		
		// 2) 준비하기 3) 사용하기
		String str = sc.nextLine();
		
		System.out.printf("Hello, %s!\n", str);
		
		System.out.println("Hello, " + str + "!");
		
		sc.close();
	}

}
