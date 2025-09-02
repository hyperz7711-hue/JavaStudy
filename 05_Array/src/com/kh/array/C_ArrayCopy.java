package com.kh.array;



public class C_ArrayCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ShallowCopy();
		DeepCopy();

	}
	/*
	 * 얕은 복사 => 주소값(참조값)을 복사
	 */
	public static void ShallowCopy() {
		
		int[] origin = {1,2,3,4,5};
		

		System.out.println("====원본 배열 출력 =====");

		for(int i =0; i <origin.length; i++)
		{
			System.out.printf("origin[%d] = %d \n", i, origin[i]);		
		}
		 
		System.out.println("");		
		
		int[] copy = origin;
		

		System.out.println("====복사본 배열 출력 =====");

		for(int i =0; i <copy.length; i++)
		{
			System.out.printf("copy[%d] = %d \n", i, copy[i]);		
		}	
		System.out.println("");		
        
		//TODO: 복사본 배열(COPY)의 세번째 위치의 값을 200으로 변경
		
		copy[2] = 200;
		
		System.out.println("====복사본 배열 출력 =====");

		for(int i =0; i <copy.length; i++)
		{
			System.out.printf("copy[%d] = %d \n", i, copy[i]);		
		}	
		System.out.println("");		

		System.out.println("====원본 배열 출력 =====");

		for(int i =0; i <origin.length; i++)
		{
			System.out.printf("origin[%d] = %d \n", i, origin[i]);		
		}
		 
		System.out.println("");				
		
		int[] copy2 = origin.clone();
		

		copy2[2] = 100;		
		
		System.out.println("====깊은 복사 배열 출력 =====");

		for(int i =0; i <copy2.length; i++)
		{
			System.out.printf("copy2[%d] = %d \n", i, copy2[i]);		
		}	
		System.out.println("");	
		
		System.out.println("====원본 배열 출력 =====");

		for(int i =0; i <origin.length; i++)
		{
			System.out.printf("origin[%d] = %d \n", i, origin[i]);		
		}
		 
		System.out.println("");			
		
	}
	/*
	 * 깊은 복사 : 새로운 배열을 생성하여 원본 배열의 값을 복사
	 */
	public static void DeepCopy() {
		
		int[] origin = {1,2,3,4,5};
		
//        복사본 배열(copy)을 선언하고 원본배열(origin)의 크기만큼 할당(생성)
		
		int[] copy = new int[10];
		
//      for문을 이용하여 복사하기	
		System.out.println("====for문을 이용하여 복사하기	 =====");

		for(int n : copy)
		{
			System.out.printf(n + " ");	
		}
		
		System.arraycopy(origin, 2, copy, 4, 3);		
		
//		for(int i =0; i <copy.length; i++)
//		{	
//			copy[i] = origin[i]; 
//			System.out.printf("복사 후 copy[%d] = %d \n", i, copy[i]);
//		}
		 
		System.out.println("");		
		
		
//		copy[2] = 200;
		System.out.println("====복사본 배열 출력 foreach =====");
		for(int n : copy)
		{
			System.out.printf(n + " ");	
		}
		System.out.println("");	
		
		System.out.println("====원본 배열 출력 foreach =====");
		for(int n : origin)
		{
			System.out.printf(n + " ");	
		}			
		System.out.println("");	
		System.out.println("====복사본 배열 출력 =====");

		for(int i =0; i <copy.length; i++)
		{
			System.out.printf("copy[%d] = %d \n", i, copy[i]);		
		}	
		System.out.println("");		

		System.out.println("====원본 배열 출력 =====");

		for(int i =0; i <origin.length; i++)
		{
			System.out.printf("origin[%d] = %d \n", i, origin[i]);		
		}
		 
		System.out.println("");				
		
		int[] copy2 = origin.clone();
		


		copy2[2] = 100;		
		
		System.out.println("====깊은 복사 배열 출력 =====");

		for(int i =0; i <copy2.length; i++)
		{
			System.out.printf("copy2[%d] = %d \n", i, copy2[i]);		
		}	
		System.out.println("");	
		
		System.out.println("====원본 배열 출력 =====");

		for(int i =0; i <origin.length; i++)
		{
			System.out.printf("origin[%d] = %d \n", i, origin[i]);		
		}
		 
		System.out.println("");			
		
	}	

}
