package com.kh.collection.list.model.vo;

public class Music {
	
	private String title;      // 제목
	private String artist;     // 가수
	
	public Music() {}

	public Music(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "Music [title=" + title + ", artist=" + artist + "]";
	}
	
	
	
	// 기본 생성자, 모든 필드를 매개변수로 가지는 생성자
	
	// getter/setter, toString
	

}
