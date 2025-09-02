package com.kh.api;

import java.util.Date;
import java.text.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class API5_Date {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Java.util.Date 클래스
		//* 날짜 시간 관련 클래스
		
		Date date = new Date();
		
		System.out.println(date);
		// => 현재날짜,시간
		
		// 개강일로 지정하여 생성 ( 2025년 8월 19일)
		// new Date (연도, 월, 일)
		// - 연도 : 지정연도 -1900
		// - 월 : 지정월 -1
		
		//Date date2 = new Date(2025,8,19); // 
		Date date2 = new Date(2025-1900,8-1,19); // 		
		System.out.println(date2);
		
		// * 양식을 지정하는 클래스 : java.text.SimpleDateFormat
		
		String format ="yyyy년 MM월 dd일 hh시 mm분 ss초";
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		System.out.println(sdf.format(date));
		
		//java.time.LocalDateTime
		LocalDateTime date3 = LocalDateTime.now();
		// LocalDateTime.now() : 현재 날짜 시간 기준으로 생성
		System.out.println(date3);	
		
		System.out.println(date3.getMonth());	    // 월정보를 문자로 반환
		System.out.println(date3.getMonthValue());	// 월정보를 숫자로 반환
		
		System.out.println(date3.getDayOfMonth());	    // 월기준 일이 반환
		System.out.println(date3.getDayOfYear());	// 년기준 일 반환	

		System.out.println("올해는 ...." + (365 - date3.getDayOfYear()) + "일 남았습니다." );	    // 올해 몇일 남았는지	
		
		// * 시 정보 반환 : getHour
		System.out.println(date3.getHour());
		
		System.out.println("퇴근까지 ...." + (18 - date3.getHour()) + "시간 남았습니다." );	    // 올해 몇일 남았는지	
				
		
		// * 형식 지정하기 
		// java.time.format.DateTimeFormatter
		
		String format2 = date3.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
		System.out.println(format2);	
		
	}
		

}
