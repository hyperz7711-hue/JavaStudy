package com.mypet.model;

public class Dog implements PetType {
	
    @Override
    public void eat(Pet pet) {
    	
    	pet.UpdateFullnessScore(15);
        pet.UpdateHappyScore(10);
        pet.UpdateCleanScore(-5);

    }

    @Override
    public void play(Pet pet) {
    	
    	pet.UpdateFullnessScore(-5);
        pet.UpdateHappyScore(15);
        pet.UpdateCleanScore(-10);    	

    }

    @Override
    public void clean(Pet pet) {

    	pet.UpdateFullnessScore(-5);
        pet.UpdateHappyScore(-5);
        pet.UpdateCleanScore(25);   	
    }

    @Override
    public String getType() {
        return "강아지";
    }	

}
