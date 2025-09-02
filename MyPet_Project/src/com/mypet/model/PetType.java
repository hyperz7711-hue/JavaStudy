package com.mypet.model;

public interface PetType {
	
    void eat(Pet pet);
    void play(Pet pet);
    void clean(Pet pet);
    String getType();

}
