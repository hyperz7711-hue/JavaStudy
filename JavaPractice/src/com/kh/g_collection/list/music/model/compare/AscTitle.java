package com.kh.g_collection.list.music.model.compare;


import java.util.Comparator;
import com.kh.g_collection.list.music.model.vo.Music;

// +compare(o1:Object, o2:Object):int
public class AscTitle implements Comparator<Music> {
    @Override
    public int compare(Music o1, Music o2) {
        int result = o1.getTitle().compareTo(o2.getTitle());
        if (result == 0) {
            result = o1.getSinger().compareTo(o2.getSinger());
        }
        return result;
    }
}
