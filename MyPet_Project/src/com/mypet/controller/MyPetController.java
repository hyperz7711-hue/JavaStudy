package com.mypet.controller;

import com.mypet.model.Pet;


public class MyPetController {
	
	private String userName;
	
	private Pet pet;
	
    // * 생성자 생략 => 기본 생성자 자동 생성
	
    public String getUserName() {
    	
    	return userName; 
    }

    public void createUser(String userName) {

    	this.userName = userName;

    }

    public Pet getPet()  {
    	return pet; 
    }

    public Pet createPet(Pet pet) {

    	this.pet= pet;
    	
        return this.pet;
    }

    /*
     * 펫의 상태 정보 조회
     * @return 펫상태 조회
     */
    public String petStatus() {

    	return pet.getStatus(); 
    }
    
    /*
     * 펫 살아 있는지 유무
     * @return 펫의 생존 유무
     */   
    public boolean isPetAlive() {
           
    	return pet.isAlive();
    }

    /*
     * 펫에 대한 행동을 처리하는 메소드
     * @param action (1:밥주기, 2:놀아주기, 3:씻기기)
     */
    public void doAction(int aciton) {
    	
        switch (aciton) {
        case 1: 
        	pet.eat(); 
        	break;
        case 2: 
        	pet.play(); 
        	break;
        case 3: 
        	pet.clean(); 
        	break;
        default: 
        }

    }

    /*
     * 하루가 지났을 때 펫의 상태 업데이트
     */
    public void nextDay() {
    	
    	pet.passDay();

    }

}