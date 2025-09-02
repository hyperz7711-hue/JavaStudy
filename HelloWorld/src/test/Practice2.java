package test;

import java.util.Scanner;



public class Practice2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		

		System.out.print("첫 번째 숫자: ");
		
		chk_int(sc);
        
		 int num1 = sc.nextInt();		
		
		System.out.print("두 번째 숫자: ");
		
		chk_int(sc);
        
		int  num2 = sc.nextInt();
		
		System.out.printf("%d + %d = %d", num1, num2, num1 + num2);
		
		sc.close();
	}
	
	public static void chk_int(Scanner sc)
	{
        while (!sc.hasNextInt())
        {
        	System.out.print("입력된 값이 숫자가 아닙니다. 숫자로 재입력하세요: "  );
        	sc.next();

        }		
	}

}
