package test;

// 1. 포함시키기
import java.util.Scanner;

public class ScannerTest {
	// 자바 프로그램 실행 시 반드시 필요한 것
	// => main 메소드
	public static void main(String[] args) {
		// 2. 준비하기! (생성)
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아무 단어나 입력하세요: ");
		
		// 3. 사용하기!
		String str = sc.nextLine(); // 문자열로 입력받는 메소드
		
		System.out.println(str);	// 입력받은 값을 출력!
		
		// 4. 사용 완료 (자원 해제)
		sc.close();		// 생략 가능함!
	}

}
