package com.kh.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.io.model.Product;

public class IO003_FileStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// fileSave();
		// fileRead();
		// ObjectSave();
		ObjectRead();
	}

	// 프로그램 ----> 파일 : 출력

	public static void fileSave() {
		// * 기반스트림 : FileWriter. 파일을 직접적으로 연결하여 2바이트씩 출력하는 스트림
		// * 보조스트림 : BufferedWriter. 속도 향상을 도와주는 보조스트림

		System.out.println(" ***** file sava ***** ");

		/*
		 * // 2.보조 스트림 생성 BufferedWriter bw = null;
		 * 
		 * try {
		 * 
		 * // 1.기반 스트림 생성 FileWriter fw = new FileWriter("file1.txt"); // 2.보조 스트림 생성 bw
		 * = new BufferedWriter(fw); // => 보조 스트림 객체 생성 시 기반 스트림 객체를 전달!
		 * 
		 */
		// try with resource => 자원을 알아서 해제해주는 구문
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("file1.txt"))) {
			bw.write("기반 스트림으로 출력!~");
			bw.newLine();
			bw.write("입출력 재밌다!");
			bw.newLine();
			bw.write("오늘은 비가 왔다!!");
			bw.newLine();
			bw.flush();

			// bw.close(); // 입력중간에 에러가 발생될 경우 처리 못함

		} catch (IOException e) {
			e.printStackTrace();
		} /*
			 * finally { // => 예외 발생유무 상관 없이 무조건 실행하는 내용
			 * 
			 * // * 사용한 스트림객체(자원)를 해체 (사용 완료처리) try { if (bw != null) bw.close();
			 * 
			 * } catch (IOException e) { e.printStackTrace(); } }
			 */

	}

	public static void fileRead() {
		// * 기반스트림 : FileReader. 파일을 직접적으로 연결하여 2바이트씩 스트림
		// * 보조스트림 : BufferedReader. 속도 향상을 도와주는 보조스트림, 한줄씩 데이터를 읽음

		System.out.println(" ***** file read ***** ");

		// try with resource => 자원을 알아서 해제해주는 구문
		try (BufferedReader br = new BufferedReader(new FileReader("file1.txt"))) {
			/*
			 * // 파일 내용을 읽어오기 // System.out.println(br.readLine()); //
			 * System.out.println(br.readLine()); // System.out.println(br.readLine()); //
			 * System.out.println(br.readLine()); // 읽어올 내용이 없을 때 null로 반환횜 ///
			 * 
			 */
			String data;

			while ((data = br.readLine()) != null) {
				System.out.println(data);
			}

			// bw.close(); // 입력중간에 에러가 발생될 경우 처리 못함

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void ObjectSave() {
		// * 프로그램 ---> 파일 : 출력. 객체에 저장된 데이터

		Product p1 = new Product("스피커", 50000);
		Product p2 = new Product("키보드", 77000);
		Product p3 = new Product("노트", 5000);

		// * 기반스트림 : FileOutputStream . 1바이트 단위로 파일에 출력하는 스트림
		// * 보조스트림 : ObjectOutputStream. 객체 단위로 출력을 도와주는 스트림

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file2.txt"))) {

			oos.writeObject(p1);
			oos.writeObject(p2);
			oos.writeObject(p3);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void ObjectRead() {
		// * 프로그램 ---> 파일 : 출력. 객체에 저장된 데이터

		// * 기반스트림 : FileInputStream . 1바이트 단위로 파일에 출력하는 스트림
		// * 보조스트림 : ObjectInputStream. 객체 단위로 출력을 도와주는 스트림

		try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("file2.txt"))) {

			while (true) {
				System.out.println(oos.readObject());
			}

		} catch (EOFException e) {
			System.out.println("파일 모두 읽어옴!!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
