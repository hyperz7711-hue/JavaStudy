package com.kh.collection.map.run;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.collection.map.model.vo.Snack;

public class Run {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String, Snack> hm = new HashMap<>();
		
		// List, Set 계열의 클래스들은 Collection을 구현한 클래스
		// => 데이터를 추가할 때 공통적으로 add 메소드 사용

	    // Map 계열은 Collection을 구현한 클래스가 아님
		// => 데이터를 추가할 때 put 메소드 사용. 키-밸류 셋트로 저장해야 함!
		
		// 1. put (K Key, V Value) : Map에 키-밸류 셋트로 추가해주는 메소드
		hm.put("새우깡", new Snack("고소",500));
		hm.put("프링글스", new Snack("짠맛",2000));	
		hm.put("먹태깡", new Snack("먹태맛",600));			
				
		hm.put("고소미", new Snack("고소",500));	
		hm.put("새우깡", new Snack("짠맛",777));			
		hm.put("새우깡", new Snack("매운맛",999));			
		System.out.println(hm);
		// => 저장 순서 유지 x, value 값이 중복되어도 key 값이 중복되지 않으면 잘 저장됨
		// => 저장된 키값이 있을 경우 동일한 키값 입력시 마지막 입력된 value값으로 업데이트
		
		// 2. get(object key) : v ==> Map에서 해당 key 값을 가지는 value 값을 반환
		
		Snack s = hm.get("먹태깡");
		System.out.println(s/*.toString() */); 
		
		// 3. size() => Map에 저장된 데이터 갯수 반환
		System.out.println(hm.size());
		
		// 4.replace(K key, V value)
		// => Map에서 해당 key 값을 찾아서 전달한 value 값으로 수정
		
		hm.replace("새우깡", new Snack("새우맛",555));
		
		System.out.println(hm.get("새우깡")); 
		
		// 5. remove(object key)
		//   ==> Map 에서 해당 key 값을 찾아서 key-value 셋트를 삭제
		
		hm.remove("새우깡");
		System.out.println(hm);
		
		// for each문 (향상된 for문) -> x
		// for( : hm) { } // 선언된 변수를 특정할 수 없음
		
		// ArrayList 변환 => ㅌ
		// ArrayList List = new ArrayList(hm);
		//=> Map은 Collection 기반이 아니기 때문에 불가능
		
		// Iterator 사용
		// Iterator it = hm.iterator(); // Map은 iterator() 메소드 x
		
		// Map -> Set 바꾸어주는 메소드 이용
		// Map -> Set -> Iterator
		
		// 1. KeySet()   -> 키값들로만 Set 형태로 반환
		
		Set<String> kSet = hm.keySet();
	    
		// 2)kSet을 Iterator 담기
		Iterator<String> itKey = kSet.iterator();
		
		// 3) 반복문 사용하여 데이터 접근
		System.out.println("=======================================================");
		while(itKey.hasNext()){
			
			String key = itKey.next();
			
			Snack value = hm.get(key);
			
			System.out.println(key + ":" + value);
			
		}
		
		// 2. entrySet() -> 키-밸류 데이터를 Entry로 감싼 Set 반환 
		
		// 1) hm.entrySet() : Set
		
		Set< Entry<String, Snack> > entrySet = hm.entrySet();
		
		// 2)entrySet.iterator():iterator
		Iterator< Entry<String, Snack> > itEntry = entrySet.iterator();
		
		// 3) 반복문
		
		
		System.out.println("+".repeat(40));
		while(itEntry.hasNext()){
			
			Entry<String, Snack> entry = itEntry.next();
			
			String key = entry.getKey();
			Snack value = entry.getValue();			
			
			System.out.println(key + "::" + value);		
			
		}		
		
		
		
	}

}
