package com.kh.inherit.after;

// product 클래스로부터 상속 받기! -> extends
public class Desktop extends Product {
	    
	// * 필요한 추가적인 정보는 따로 정의해줌
		private boolean allInOne;
		
		
		// 매개변수 5개의 생성자 => 부모 클래스(product)로부터 4개의 필드 + 자식클래스(desktop) 1개 필드를 정의
		
		public Desktop(String brand, String code, String name, int price, boolean allInOne) {
			super(brand, code, name, price);
		    // ==> 부모클래스의 매개변수가 4개인 생성자를 호출.
			this.allInOne = allInOne;
			
		}
        
		// *Information():String --> 부모클래스에 정의되어 있음
		@Override
		public String Information() {
			
			String info =  String.format("%s, allInOne : %b", super.Information(), allInOne);
			
			return info;
		}

		public boolean isAllInOne() {
			return allInOne;
		}

		public void setAllInOne(boolean allInOne) {
			this.allInOne = allInOne;
		}
			

}
