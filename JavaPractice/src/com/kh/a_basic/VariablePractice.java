package com.kh.a_basic;
import java.util.Scanner;

public class VariablePractice {
	
	public static void main ( String[] args) {
		
		//practice1();
		//practice4();
		//practice5();
		practice6();
		
	}
	
	public static void practice1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요: ");
		

		
		String name = sc.nextLine();
		
		System.out.print("성별을 입력하세요 (남/여): ");

		
		String gender = sc.nextLine();	
		
        char genderFinal = gender.charAt(0);
	
		
		System.out.print("나이를 입력하세요 : ");	
		
		chk_int(sc);		
		
		int age = sc.nextInt();
		
		System.out.print("키를 입력하세요 : ");	
		
		chk_double(sc);		
		
		double tall = sc.nextDouble();
		
			
		
		
		System.out.printf("키 %.1f cm인 %d살 %c자 %s님 반갑습니디^^", tall, age, genderFinal, name );

		
		sc.close();		
		
		
	}
	
	public static void practice4() {
		
		String txtExt;		
		int desiredLength = 3 ;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력하세요: ");
		String[] strMark = {"첫", "두", "세"};
		String strGubun = " 번째 문자 : ";		
		          
        while (true) { // 올바른 값이 입력될 때까지 반복
        	txtExt = sc.nextLine(); // 사용자 입력 받기

            if (txtExt.length() >= desiredLength) { // 문자열 길이 체크
            	
            	for (int i = 0; i < desiredLength; i++)
            	{
	    			System.out.println( strMark[i] + strGubun +  txtExt.charAt(0));
            	}
    			
                break; // 올바른 입력 시 루프 종료
            } else {
                System.out.println("잘못된 입력입니다. 문자열 길이는 " + desiredLength + "자 이상이어야 합니다.");
            }
        }		
				
		  
	  		 

		
		sc.close();		
		
		
	}
	
	public static boolean practice5() {
		
		String strUnicode;	
		String strCommon = " unicode : ";		

		
		Scanner sc = new Scanner(System.in);
		System.out.print("문자를 입력하세요: ");
       
		int MAX_CNT = 0;
		          
        while (true) { // 올바른 값이 입력될 때까지 반복
        	strUnicode = sc.nextLine(); // 사용자 입력 받기

            if (strUnicode != null && strUnicode.length() == 1) { // 문자열 길이 체크

	    			System.out.println( strUnicode + strCommon +  strUnicode.hashCode());

                break; // 올바른 입력 시 루프 종료
            } else {
                System.out.println("잘못된 입력입니다. 문자는 한글자만 입력해야 합니다.");
                
                MAX_CNT += MAX_CNT;
                
                if (MAX_CNT >=5 ) return false;
                
            }
        }
        		
		sc.close();		
		return true;
		
	}	
	
	
	
	
	  public static void practice6() {
	  
	  
	  Scanner sc = new Scanner(System.in); 
	  String[] strMark = {"국어 :", "영어 :", "수학 :"}; 
	  double[] n1 = new double[3];
	  
	  int sum1 = 0, avg1 = 0;
	  
	  for (int i = 0; i < strMark.length; i++)
	  {
		  System.out.print(strMark[i]);	
		  chk_double(sc);		  
		  n1[i] = sc.nextDouble();
		  		  
		  sum1  += (int)n1[i];
	  }
	  
	  for (int i = 0; i < strMark.length; i++)
	  {
		  System.out.printf("%s %.1f \n", strMark[i], n1[i]);	  
	  }	  
	  	  
	  avg1 = sum1 / strMark.length;
       
	  System.out.printf( "총점 : %d \n", sum1);	  	
	  System.out.printf( "평균 : %d \n", avg1);	  		  
	  
	  sc.close();
	  
	  
	  }
	 	
	
		
	public static boolean chk_length(Scanner sc)
	{
		
		String txtChk = sc.nextLine();

        if (txtChk.length() < 3)
        {
        	System.out.print("입력된 값의 길이가 3보다 작습니다. 문자는 3개이상 등록해 주세요: "  );
        	return false;

        }	   
        
    	return true;
	}	
	
	
	public static void chk_int(Scanner sc)
	{
        while (!sc.hasNextInt())
        {
        	System.out.print("입력된 값이 정수가 아닙니다. 숫자로 재입력하세요: "  );
        	sc.next();

        }		
	}
	
	public static void chk_double(Scanner sc)
	{
        while (!sc.hasNextDouble())
        {
        	System.out.print("입력된 값이 실수가 아닙니다. 실수로 재입력하세요: "  );
        	sc.next();

        }		
	}	
	
	

}
