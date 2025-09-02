package com.kh.collection.list.run;

import java.util.ArrayList;

import com.kh.collection.list.model.vo.Music;

public class Run2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		ArrayList<Music> list = new ArrayList<Music>();
		
		// 1/ add(E e) : 리스트 공간 끝에 전달된 데이터를 추가해주는 메소드
		list.add(new Music("애국가","윤도현"));
		list.add(new Music("APT","로제"));
//		list.add(new Music("아파트","윤수일"));		

		System.out.println(list);
		
		list.add(1, new Music("좋은날","아이유") );
		System.out.println(list);	
		list.set(2, new Music("아파트","윤수일"));			
		System.out.println(list);			
		
		Music m = list.get(0);
		System.out.println(m);		
		
		for(Music music :list) {
			System.out.println(music);			
		}
		/*
		 *  * 제네릭<> 사용하는 이유
		 *  - 명시된 타입의 객체만 저장하도록 제한할 수 있음
		 *  - 컬렉션에 저장된 데이터를 꺼내서 사용할 때 매번 형변환하지 않아도 됨
		 */
	}

}
