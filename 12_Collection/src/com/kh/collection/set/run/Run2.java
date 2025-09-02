package com.kh.collection.set.run;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Run2 {
		
	public static void main(String[] args) {
	    lotto();

	}
	

	
public static void lotto() {
    Set<Integer> lotto = new HashSet<>(); // 인터페이스를 구현한 HashSet 
  
    
    while (lotto.size() < 6) { // 로또 셋의 크기가 6보다 작을 동안

        int number = (int)(Math.random()*45 + 1); 
        lotto.add(number);
    }
    
    System.out.println("생성된 로또 번호:");
    for (int number : lotto) {
        System.out.print(number + " " ); 
    }
    System.out.println();
    System.out.println("=".repeat(30));
    
    // Iterator 반복자 활용
    
    int[] lottoArray = new int[lotto.size()]; 
    Iterator<Integer> it = lotto.iterator(); 
    
    for(int i = 0; it.hasNext(); i++) {
    	
    	lottoArray[i] = it.next();
    }
    System.out.println("생성된 로또 번호:");
    for (int i = 0; i < lottoArray.length; i++) {
        System.out.print(lottoArray[i] + " "); 
    } 

}

}
