package com.kh.io;

import java.io.File;
import java.io.IOException;

public class IO001_File {
	/*
	 * 파일을 다루는 객체 : File (java.util)
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test1();
		test2();
	}

	public static void test1() {
		// File 객체 생성

		// => 파일명만 전달하여 객체 생성 (존재하지 않는 파일)
		File f1 = new File("test1.txt");

		// =>존재하는 파일명으로 객체 생성
		File f2 = new File("d:\\test2.txt");
		// 특정 경로의 존재하지 않는 파일명으로 객체 생성
		File f3 = new File("d:\\test3.txt");

//		// 존재하지 않는 경로의 존재하지 않는 파일명으로 객체 생성		
//		File f4 = new File("d:\\tmp\\test4.txt");	

		// 존재하지 않는 경로의 존재하지 않는 파일명으로 객체 생성

		File f4_folder = new File("d:\\tmp");

		File f4 = new File("d:\\tmp\\test4.txt");
		File f5 = new File("test5.txt");

		try {
			// 파일 생성
			f1.createNewFile(); // 프로젝트 디폴트 폴더에 파일 생성

			f2.createNewFile(); // 존재하는 파일에 대해서는 따로 처리 x

			f3.createNewFile(); // 지정된 경로에 파일이 없을 경우 해당 경로에 파일 생성

//		f4.createNewFile();	  
//		// 지정된 경로가 없을 경우 	IOException 예외 발생	
//		// 폴더를 먼저 생성하고, 그 다음에 파일을 생성		

			// 폴더 생성 :mkdir
			f4_folder.mkdir(); // 폴더가 존재하지 않으면 폴더를 생성 존재할 경우 에러메시지 없이 폴더 생성하지 않음
			f4.createNewFile();

			// * 파일이 존재하는 지 확인 : exist() : boolean
			System.out.println("txt1.txt파일이 존재하는가? " + f1.exists());
			System.out.println("txt5.txt파일이 존재하는가? " + f5.exists());

			// * 파일인지 확인 : isFile() : boolean
			System.out.println("f4는 파일인가? " + f4.isFile());
			System.out.println("f4_folder는 파일인가? " + f4_folder.isFile());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void test2() {
		// * sample 폴더를 생성한 후 myDiary.txt 파일을 만들어 보기!

		// 폴더를 생성
		File file_folder = new File("\\sample");
		
		// 폴더가 존재하지 않을 경우 생성
		if (file_folder.exists() == false)
			file_folder.mkdir(); // 폴더가 존재하지 않으면 폴더를 생성 존재할 경우 에러메시지 없이 폴더 생성하지 않음		

		// =>myDiary.txt 선언
		// File file = new File("d:\\sample\\myDiary.txt"); 
		File file = new File("sample\\myDiary.txt"); 


		try {
            if (file.exists() == false) // 파일이 존재하지 않을 경우 myDiary.txt 파일 생성
            	file.createNewFile();
             
            // * 파일 객체를 통해 파일 정보 조회
            System.out.println("파일명 : " + file.getName());
            System.out.println("파일경로 : " + file.getAbsolutePath());    
            System.out.println("파일용량 : " + file.length());     
            System.out.println("파일상위폴더 : " + file.getParent());             
         
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
