package com.kh;

public class Variable {

	public static void main(String[] args) {

		printVariable();
		
		declareVariable();
		
		printVariable3();
		
		
	}
	
	
   public static void printVariable() {
	   
	   /*
	    * 변수의 목적 ? 데이터를 저정하기 위한 공간 
	    * - 가독성 증가
	    * - 개발자의 실수를 줄일 수 있음
	    * - 재사용성 증가
	    * - 유지보수가 좋아짐
	    */
	   
	   // 월급 = 시급 * 근무시간 * 근무일수
	   // 츨력형식 -> xxx : 0000원
	   // * 2025년 최저시급 : 10030원
	   
	   System.out.println("홍길동 : " + (10030*8*5) + "원");
	   System.out.println("아이유 : " + (10030*6*5) + "원");
	   System.out.println("진 : " + (10030*15*28) + "원");	 
	   System.out.println("유재석 : " + (10030*20*31) + "원");		   
	   
   }
   
   public static void declareVariable() {
	   
	   /*
	    * - 자료형 : 변수의 크기나 모양을 지정하는 부분
	    * - 변수형 :
	    * 명명 규칙
	    * [1] 카멜케이스 : 소문자로 시작하고, 다른단어가 붙을경우 첫글자를 대문자로 작성
	    *  - 상수는 스네이크 케이스(SNAKE_CASE)는 모두 대문자로 적성하고 다른단어가 붙을 경우 _로 구분
	    * [2] 예약어는 사용할 수 없음
	    * [4] 특수문자는 _와 $만 사용 가능
	    * [5] 슷자로 시작할 수 없음
	    * [6] 
	    */ 
	    // 1 논리형(boolean) : 논리값을 저장 true, false, 바이트크기는 1byte
	    // ture 값을 저장하는 istrue라는 변수 선언 및 초기화
	    boolean isTrue = true;
	    boolean isFalse = false;	    
	    
	    System.out.println("isTrue의 값 : " + isTrue);
	    System.out.println("isFalse의 값 : " + isFalse);	    
	   
	    isTrue = 1 + 3 > 1;
	    
	    System.out.println("isTrue의 값 : " + isTrue);
	    
	    // 2 숫자 ( 정수형, 실수형)
	    // 2-1) 정수형: 딱 떨어지는 수, 소수점 x
	    // byte(1B) / short(2B), /int(4B) / long(8B)
	    
	    
	    // byte 자료형 변수 bNum을 선언하고 저장할 수 있는 범위내의 최소값 저장 --> -128 ~ 127
	    byte bNum =  -128;
	    
	    // bNum = 1000;  //  byte 값 벗어난 값일 시 컴파일 에러, 강제 형변환시 이상한 값 출력(-24) bNum = (byte)1000;
	    
	    System.out.println("byte 값 : " + bNum);	    
	    
	    // 2-2) 실수형 : 소수점
	    // float(4B), double(8B)
	    // float 자료형 변수 fNum에 0.0 저장 
	    float fNum =  0.0f; // 소수점 7자리까지 표현가능 자료형
	                        // 값 자체(리터럴)를 저장할 때는 접미사 f/F를 붙여줌
	    
	    double dNum = 0.0; // 소수점15자리까지 표현가능 자료형
                           // 기본자료형이라 값 자체(리터럴)를 저장할 때는 접미사 d/D 생략가능
	    
	    // 3. 문자형 (char, String)
	    // 3-1) 문자 : char (2B)
	    // 'a'라는 데이터를 저장하는 변수 ch 선언 및 초기화
	    
	    char ch = 'A';
	    
	    // '김'이라는 데이터를 변수에 저장
	    char kim;
	    
	    kim ='김';
	    
	    // 3-2) 문자열 : String(참조자료형)
	    
	    // 문자열 변수 str 선언
	    // str 변수에 "안녕하세요" 데이터를 저장
	    String str; 
	    str ="안녕하세요"; 
	    
	    System.out.println("str데이터 길이 : " + str.length());
	    
	    // * 문자열의 길이 : 변수명.length()
	    
	    // 상수 : 변하지 않는 값을 저장하는 공간
	    //[표현식]
	    //	final 자료형 변수명;
	    // 최대허용자 수를 저장하기 위한 상수 선언
	    
	    final int MAX_USERS;
	    MAX_USERS = 21;  // 값을 저장(초기화)
	         
	    System.out.println("MAX_USERS 값 : " + MAX_USERS);	// => 재할당 불가  
	    
	    // * 대표적인 상수 : 파이(3.141592...)
	    
	    System.out.println(Math.PI);
	    
   }
   
   
   public void printVariable2() {
	   
	   
	   // 월급 = 시급 * 근무시간 * 근무일수
	   // 츨력형식 -> xxx : 0000원
	   // * 2025년 최저시급 : 10030원
	   
	   String[] name = {"홍길동", "아이유","진", "유재석" };
	   int HOUR_PAY = 10030;
	   int[] workHour = new int[4];
	   int[] WorkDay = new int[4];	   
	   
//	   name[0] = "홍길동";   
//	   name[1] = "아이유";  
//	   name[2] = "진";  
//	   name[3] = "유재석";  
	   
	   
	   workHour[0] = 8;	   
	   WorkDay[0] = 5;	  	 
	   
	   workHour[1] = 6;	   
	   WorkDay[1] = 5;	 	
	   
	   workHour[2] = 15;	   
	   WorkDay[2] = 28;	
	   
	   workHour[3] = 20;	   
	   WorkDay[3] = 31;		   
	   
	   
	   for (int i= 0; i < name.length; i++)
	   {
		   System.out.println(name[i] + " : " + (HOUR_PAY*workHour[i]*WorkDay[i]) + "원");		   
	   }
	   
   } 
   
   public static void printVariable3() {
	   
	   /*
	    * 변수의 목적 ? 데이터를 저정하기 위한 공간 
	    * - 가독성 증가
	    * - 개발자의 실수를 줄일 수 있음
	    * - 재사용성 증가
	    * - 유지보수가 좋아짐
	    */
	   
	   // 월급 = 시급 * 근무시간 * 근무일수
	   // 츨력형식 -> xxx : 0000원
	   // * 2025년 최저시급 : 10030원
	   
	   Variable obj = new  Variable();
	   obj.printVariable2();
	   
   }   
}
