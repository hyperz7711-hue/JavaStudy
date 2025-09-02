package com.kh.collection.set.run;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import com.kh.collection.set.model.vo.Student;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        HashSet hs1 = new HashSet();
        
        hs1.add("반갑습니다.");
        hs1.add(new String("반갑습니다."));      
        hs1.add(new String("안녕하세요."));     
        hs1.add(new String("힘내요!"));         
        hs1.add(new String("힘내요!"));  
        
        System.out.println(hs1);
        // ==> 저장 순서 유지 x, 인덱스 x, 중복된 데이터 저장 불가
        
        // * String 클래스에는 hashCode()가 오버라이딩 되어 있음
        // => 실제 담긴 문자열을 가지고 10진수의 형태로 반환
        
        //* String 클래스에 equals()도 오버라이딩 되어 있음
        // 실제 담긴 문자열의 값을 비교하여 일치하면 true, 그렇지 않으면 false
        
        HashSet<Student> hs2 = new HashSet<Student>();
        hs2.add(new Student("홍길동", 40, 77));      
        hs2.add(new Student("장원영",20, 100 ));     
        hs2.add(new Student("안유진",25, 98));         
        hs2.add(new Student("장원영",20, 100 )); 
        
        System.out.println(hs2);    
        // => 중복제거가 자동으로 되지 않음...!
        
        // *Object 클래스의 hashCode()
        // => 해당 객체의 "주소값"을 가지고 10진수 형태로 반환
        
        // *Object 클래스의 equals()
        // => 해당 객체의 "주소값"을  비교해서 같으면 true, 다르면 false
        
        // Student hashCode() 오버라이딩
        // => 실제 각 필드에 담긴 데이터들이 일치하면(문자열로 합해서) 10진수 형태로 반환
        // Student equals() 오버라이딩
        // => 실제 각 필드에 담긴 데이터를 가지고 비교. 모두 일치하여 true, 그렇지 않으면 false
        
        System.out.println(new Student("장원영",20, 100).hashCode()); 
        System.out.println(new Student("장원영",20, 100).hashCode());   
        
        System.out.println(new Student("장원영",20, 100).equals(new Student("장원영",20, 100)));       
        
        // hs2.get(0) --> 인덱스 구조를 사용하지 않으므로 get 메소도 자체가 없음
        // HashSet에 담긴 데이터는 순차적으로 접근 가능
        
        for(Student s: hs2) System.out.println(s);
        
        System.out.println("=".repeat(30));
        
        // 2.ArrayList에 저장한 다음 반복문 사용
        // * ArrayList에 저장하는 방법 
        //   1) ArrayList 생성 후 addAll 메소드 사용
        
        ArrayList<Student> list = new ArrayList<>();
        list.addAll(hs2);
        //   2) ArrayList 생성과 동시에 전달   
        ArrayList<Student> list2 = new ArrayList<>(hs2);
        
        for (int i=0; i < list2.size(); i++) System.out.println(list.get(i));
        
        // 3. Iterator 반복자를 이용하여 순차적으로 접근
        Iterator<Student> it = hs2.iterator();
        System.out.println("=".repeat(30));   
        while(it.hasNext()) {
        	Student s = it.next();
        	System.out.println(s);
        }
        
	}

}
