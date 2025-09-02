package com.mypet.model;

public class Cat implements PetType {
	
	/**
	 * 먹이를 받았을 때 상태 변경
	 * - 포만감 + 10, 즐거움 +5, 청결함 -5 
	 */
	
    @Override
    public void eat(Pet pet) {

    	pet.UpdateFullnessScore(10);
        pet.UpdateHappyScore(5);
        pet.UpdateCleanScore(-5);    	
    }
    
	/**
	 * 놀아줄 때 상태 변경
	 * - 포만감 + 10, 즐거움 +5, 청결함 -5 
	 */   

    @Override
    public void play(Pet pet) {

    	pet.UpdateFullnessScore(-5);
        pet.UpdateHappyScore(20);
        pet.UpdateCleanScore(-10);    	
    	
    }

    @Override
    public void clean(Pet pet) {
    	
    	pet.UpdateFullnessScore(-5);
        pet.UpdateHappyScore(-10);
        pet.UpdateCleanScore(20);    	

    }

    @Override
    public String getType() {
        return "고양이";
    }	

}

