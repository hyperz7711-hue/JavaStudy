package com.kh.g_collection.list.music.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import com.kh.g_collection.list.music.model.compare.*;
import com.kh.g_collection.list.music.model.vo.Music;

//- list:List = new ArrayList()
//+ addList(music:Music):int
//+ addAtZero(music:Music):int
//+ printAll():List
//+ searchMusic(title:String):Music
//+ removeMusic(title:String):Music
//+ setMusic(title:String, music:Music):Music
//+ ascTitle():int
//+ descSinger():int

public class MusicController {
	
	ArrayList<Music> list = new ArrayList<>();
	
	public int addList(Music music) {
		
        list.add(music);
        return 1;
	}
	
	public MusicController() {
		super();
	}

	public MusicController(ArrayList<Music> list) {
		super();
		this.list = list;
	}
    
	// 0번째 리스트에 음악 추가
	public int addAtZero(Music music) {
		
        list.add(0, music);
        return 1;
	}	

	public List<Music> printAll() {
		
        return list;
	}		
	
	// 제목이 일치하는 리스트가 있으면 해당 리스트를 리턴
	public List<Music> searchMusic(String title) {
        
		ArrayList<Music> sMusic = new ArrayList<>();
	    
        for (Music m : list) {
            if (m.getTitle().equals(title)) {
            	sMusic.add(m);
            }
        }
  
        return sMusic;		
		
	}	
	
	public List<Music> removeMusic(String title) {

			
	    List<Music> rMusic = new ArrayList<>(); // 인터페이스를 구현한 HashSet 	

        Iterator<Music> it = list.iterator();
       
        while (it.hasNext()) {
            Music m = it.next();
            if (m.getTitle().equals(title)) {
                it.remove();
            	rMusic.add(m);
            }
        } 
        
        return rMusic;
	}	
	
	
    public List<Music> setMusic(String title, Music music) {
        
 	     List<Music> rMusic = new ArrayList<>(); // 인터페이스를 구현한 HashSet 	
    	 
    	
    	for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().equals(title)) {

                rMusic.add(list.get(i));
            	list.set(i, music);

            }
        }
        return rMusic;
    }	
	
	public int ascTitle() {
        Collections.sort(list, new AscTitle());
        return 1;
	}	
	
	public int descSinger() {
        list.sort((o1, o2) -> o2.getSinger().compareTo(o1.getSinger()));
        return 1;
	}		
	
}
