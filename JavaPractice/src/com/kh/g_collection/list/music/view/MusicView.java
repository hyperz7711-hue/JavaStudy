package com.kh.g_collection.list.music.view;

import java.util.List;
import java.util.Scanner;

import com.kh.g_collection.common.InputValidator;
import com.kh.g_collection.list.music.controller.MusicController;
import com.kh.g_collection.list.music.model.vo.Music;

//- sc:Scanner = new Scanner(System.in)
//- mc:MusicController = new MusicController();
//+ mainMenu() : void
//+ addList() : void
//+ addAtZero() : void
//+ printAll() : void
//+ searchMusic() : void
//+ removeMusic() : void
//+ setMusic() : void
//+ ascTitle() : void
//+ descSinger() : void


public class MusicView {
	
	Scanner sc = new Scanner(System.in);
	
	MusicController mc = new MusicController();

	public MusicView() {
		super();
	}	
	
	public MusicView(Scanner sc, MusicController mc) {
		super();
		this.sc = sc;
		this.mc = mc;
	}


    public void mainMenu() {

//		******* 메인 메뉴 *******
//		1. 마지막 위치에 곡 추가 // addList() 실행
//		2. 첫 위치에 곡 추가 // addAtZero()
//		3. 전체 곡 목록 출력 // printAll()
//		4. 특정 곡 검색 // searchMusic()
//		5. 특정 곡 삭제 // removeMusic()
//		6. 특정 곡 정보 수정 // setMusic()
//		7. 곡명 오름차순 정렬 // ascTitle()
//		8. 가수명 내림차순 정렬 // descSinger()
//		9. 종료 // “종료” 출력 후 main()으로 돌아 감 (메소드 종료!)
//		메뉴 번호 선택 : >> 입력 받음
		// 메뉴 화면 반복 실행 처리      
        
        
        int choice = 0;
        do {
            System.out.println("\n=====***** 메인 메뉴 *****=====");
            System.out.println("1. 마지막 위치에 곡 추가");
            System.out.println("2. 첫 위치에 곡 추가");
            System.out.println("3. 전체 곡 목록 출력");
            System.out.println("4. 특정 곡 검색");
            System.out.println("5. 특정 곡 삭제");
            System.out.println("6. 특정 곡 수정");
            System.out.println("7. 곡 명 오름차순 정렬");
            System.out.println("8. 가수 명 내림차순 정렬");
            System.out.println("9. 종료");
            choice = InputValidator.getPositiveInt(sc, "메뉴 번호 입력 : "); // 입력시 양수값만 체크


            switch (choice) {
                case 1: addList(); break;
                case 2: addAtZero(); break;
                case 3: printAll(); break;
                case 4: searchMusic(); break;
                case 5: removeMusic(); break;
                case 6: setMusic(); break;
                case 7: ascTitle(); break;
                case 8: descSinger(); break;
                case 9: System.out.println("프로그램 종료"); break;
                default: System.out.println("잘못 입력하였습니다.");
            }
        } while (choice != 9);
    }

    public void addList() {
        System.out.println("****** 마지막 위치에 곡 추가 ******");
        System.out.print("곡 명 : ");
        String title = sc.nextLine();
        System.out.print("가수 명 : ");
        String singer = sc.nextLine();

        int result = mc.addList(new Music(title, singer));
        System.out.println(result == 1 ? "추가 성공" : "추가 실패");
    }

    public void addAtZero() {
        System.out.println("****** 첫 위치에 곡 추가 ******");
        System.out.print("곡 명 : ");
        String title = sc.nextLine();
        System.out.print("가수 명 : ");
        String singer = sc.nextLine();

        int result = mc.addAtZero(new Music(title, singer));
        System.out.println(result == 1 ? "추가 성공" : "추가 실패");
    }

    public void printAll() {
        System.out.println("****** 전체 곡 목록 출력 ******");
        List<Music> all = mc.printAll();

        if (all == null || all.size() == 0) {
            System.out.println("등륵된 곡이 없습니다.");
        } else {
            System.out.println(all);
        }       
    }

    public void searchMusic() {
        System.out.println("****** 특정 곡 검색 ******");
        System.out.print("검색할 곡 명 : ");
        String title = sc.nextLine();

        List<Music> result = mc.searchMusic(title);
        if (result == null || result.size() == 0) {
            System.out.println("검색한 곡이 없습니다.");
        } else {
            System.out.println(result);
        }
    }

    public void removeMusic() {
        System.out.println("****** 특정 곡 삭제 ******");
        System.out.print("삭제할 곡 명 : ");
        String title = sc.nextLine();

        List<Music> result = mc.removeMusic(title);
        if (result == null || result.size() == 0) {
            System.out.println("삭제할 곡이 없습니다.");
        } else {
            System.out.println(result + "을(를) 삭제했습니다.");
        }
    }

    public void setMusic() {
        System.out.println("****** 특정 곡 수정 ******");
        System.out.print("검색할 곡 명 : ");
        String title = sc.nextLine();

        System.out.print("수정할 곡 명 : ");
        String newTitle = sc.nextLine();
        System.out.print("수정할 가수 명 : ");
        String newSinger = sc.nextLine();

        List<Music>  result = mc.setMusic(title, new Music(newTitle, newSinger));
        if (result == null) {
            System.out.println("수정할 곡이 없습니다.");
        } else {
            System.out.println(result + "가 값이 변경되었습니다.");
        }
    }

    public void ascTitle() {
        int result = mc.ascTitle();
        System.out.println(result == 1 ? "정렬 성공" : "정렬 실패");
    }

    public void descSinger() {
        int result = mc.descSinger();
        System.out.println(result == 1 ? "정렬 성공" : "정렬 실패");
    }
}