package com.kh.collection.list.run;

import java.util.ArrayList;
import java.util.List;

import com.kh.collection.list.model.vo.Music;


public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ==> 별도로 제네릭을 설정하지 않으면 <Object> => <E> --> Object
		ArrayList /*<Object>*/ list = new ArrayList(3);
		// 생성자에게 크기를 전달해도 되고, 전달하지 않아도 된다. 가변적이기 때문
		
		System.out.println(list);
		
		// 1/ add(E e) : 리스트 공간 끝에 전달된 데이터를 추가해주는 메소드
		list.add(new Music("애국가","윤도현"));
		list.add(new Music("APT","로제"));
		list.add(new Music("아파트","윤수일"));		
		list.add("끝");
		
		System.out.println(list);

		// * 지정된 크기보다 더 많이 넣어도 오류가 발생하지 않는다.
		// * 다양한 타입의 데이터를 담을 수 있음
		// * 순서가 유지되면서 저장!
		
		// 2. add ( int index, E e) : 직접 인덱스를 지정하여 해당 위치에 데이터를 추가
		list.add(1, new Music("좋은날", "아이유"));
		System.out.println(list);		
		System.out.println(list.get(1));
		
		// * 중간 위치에 데이터 추가시 복잡한 알고리즘을 직접 구현하지 않아도 됨
		
		// 3. remove(int index) : 해당 인덱스 위치의 데이터를 삭제
		list.remove(1);
		System.out.println(list);		
		System.out.println(list.get(1));	
		
		
		
		// 4. set(int index, E e) : 해당 인덱스 위치에 데이터를 새로 전달한 데이터로 수정
		list.set(0, new Music("좋은날", "아이유"));
		
		System.out.println(list);		
		System.out.println(list.get(0));	
		System.out.println(list.get(1));			
		
		// 5. size() : 리스트의 크기를 반환해주는 메소드. ( 현재 저장된 데이터 크기)
		System.out.println("저장된 데이터 크기: " + list.size());
		
        // 6. get (int index) : 해당 인덱스 위치에 있는 데이터를 반환
		
		Music m = (Music)list.get(0);
		String s = (String)list.get(3);
		
		System.out.println(m);
		System.out.println(s);		
		System.out.println( ((Music)list.get(1)).getTitle());		
		
		// 7. subList(int index1, int index2):List
		//index1부터 index2 직전 위치까지 추출하여 반환
		List sub = list.subList(0, 2);
		System.out.println(sub);
		
		
		// 8. isEmpty() : boolean
		// 리스트가 비어있는지 확인하는 메소드
		System.out.println(list.isEmpty());
		
		// 9.clear() : void
//		list.clear();
//		System.out.println(list);	
//		System.out.println(list.isEmpty());
		
		// * 반복문을 통해 순차적으로 출력
		System.out.println("=".repeat(30));
		
		// 1) for 문
		for (int i=0; i <list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// 2)향상된 for 문 (foreach)
		for(Object o:list) System.out.println(o);
			
	}

}
