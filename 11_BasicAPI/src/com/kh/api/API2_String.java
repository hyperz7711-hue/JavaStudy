package com.kh.api;

public class API2_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // test1();
		test2();

	}
    
	public static void test1() {
		String str1 ="Happy";
		String str2 ="Happy";
		
		System.out.println(str1 == str2);	// 결과? true
		// 결과가 true인 이유
		// 문자열 값 자체를 대입하게 되면 "상수풀"이라는 공간에 저장되어
		// 같은 곳을 가리키게 됨!
		
		System.out.println(str1 == "Happy");	// 결과? true		
		
		System.out.println("========================================");	// 결과? true		
		
		String str3 =new String("Happy");
		String str4 =new String("Happy");		
		
		System.out.println(str3 == str4);	// 결과? false	
		//=>문자열 객체를 생성해서 값을 대입하게 되면
		// 메모리에 새로운 영역에 핼당하므로 각각 다른 위치에 저장됨
		
		System.out.println(str3 == "Happy");	// 결과? true				
		// str3이 가리키는 주소와 "Happy" 값 자체는 상수풀에 저장되어 있어 다름
		
		// *문자열 값을 비교하고자 할 때 equals
		System.out.println(str3.equals("Happy"));	// 결과? true		
		
		System.out.println("========================================");	// 결과? true	
		
		String str5 ="Good";
		String str6 ="Luck";		
		
		System.out.println(str5);	
		System.out.println(str5.toString());
		// => String 클래스에 toString()이 정의되어 있음!
	    //    저장된 값을 리턴하도록 재정의!
		// 주소값 확인하는 메소드 : System.identityHashCode();
		
		int hash = System.identityHashCode(str5);
		System.out.println(hash);	
		
		str5 = str5.concat(str6);
		System.out.println(str5);	
		
		int hash2 = System.identityHashCode(str5);		
		System.out.println(hash2);	
		
		// 문자열배열로 변환
		char[] arr = str1.toCharArray();
		System.out.println(arr[0]);	
		
		// * 문자열 배열 --> 문자열로 변환 : static valueof(배열): String
		System.out.println(String.valueOf(arr));	
		
		
	}
	
	public static void test2() {	
		
		/* equals => 문자열A.equals(문자열B) : boolean
		 * 
		 */
		
		String str1 ="Hello";	
		
		System.out.println(str1.equals("Hello"));	// 결과? true		
		System.out.println(str1.equals("Bye"));	// 결과? false	
		
		// * charAt => 문자열.charAt(인덱스) : char
		//             문자열에서 인덱스 위치의 문자를 리턴
		System.out.println(str1.charAt(1));	// 결과? true		
		// * length => 문자열.length() : int
		//             문자열의 길이	
		System.out.println(str1.length());	// 결과? true				
		
		// str1변수의 마지막 문자 출력 'o'
		System.out.println(str1.charAt(str1.length() -1 ));	// 결과? true	
		
		// toUpperCase : 모두 대문자로 변경
		System.out.println(str1.toUpperCase());	// 결과? true		
		// toLowerCase : 모두 소문자로 변경
		System.out.println(str1.toLowerCase());	// 결과? true	
		
		// Contains ==> 문자열A.contains(문자열B) : boolean
		//              문자열a에 문자열b가 포함되어 있는지 확인하여 리턴
		System.out.println(str1.contains("el"));	// 결과? true	
		System.out.println(str1.contains("tt"));	// 결과? false	
		
		// indexOf ==> 문자열A.indexOf(문자열B) 
		//              문자열a에 문자열b의 시작 인덱스를 리턴
		
		System.out.println(str1.indexOf("el"));	// 결과? 1	
		System.out.println(str1.indexOf("tt"));	// 결과? -1		
		
		// substring ==> 문자열.substring(시작인덱스) : String
		//               문자열에서 시작인덱스에서 마지막 위치까지 문자열을 추출하여 리턴
		//               문자열.substring(시작인덱스, 끝인덱스) : String
		//               문자열에서 시작인덱스에서 끝인덱스 직전까지 문자열을 추출하여 리턴
		System.out.println(str1.substring(2));	// 결과? llo			
		System.out.println(str1.substring(2,4));	// 결과? ll	
		
		// repeat    =>문자열.repeat(개수): String
		//             문자열 개수만큼 반복하여 문자열 반환
		System.out.println(str1.repeat(5));	// 결과? HelloHelloHelloHelloHello		
		
		// split    =>문자열.split(구분자): String[]
		//             해당 문자열을 구분자를 기준으로 문자열 배열 형태로 반환
		
		String str2 ="java#python#sql";			
		String[] arr = str2.split("#");
		for(String s : arr){
		System.out.println(s);	// 결과? HelloHelloHelloHelloHello		
		}
		
	}
}
