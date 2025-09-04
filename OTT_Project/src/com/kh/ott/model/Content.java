package com.kh.ott.model;

import java.util.Set;
import com.kh.ott.model.enumtype.ContentType;
import com.kh.ott.model.enumtype.Genre;
import com.kh.ott.model.enumtype.AgeRating;

public class Content {
	private long id;             // 순번 :임의 채번
	private String title;        // 제목  
	private int year;            // 제작년도
	private ContentType type;    // 컨텐츠타입
	private Set<Genre> genres;   // 장르
	private int durationMinutes; // 상영/재생 시간
	private AgeRating ageRating; // 등급
	private int criticsScore; // 평론 점수(0~100)

	public Content(long id, String title, int year, ContentType type, Set<Genre> genres) {
		this(id, title, year, type, genres, 0, AgeRating.ALL, 0);
	}

	public Content(long id, String title, int year, ContentType type, Set<Genre> genres, int durationMinutes,
			AgeRating ageRating, int criticsScore) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.type = type;
		this.genres = genres;
		this.durationMinutes = durationMinutes;
		this.ageRating = ageRating;
		this.criticsScore = criticsScore;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public ContentType getType() {
		return type;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public int getDurationMinutes() {
		return durationMinutes;
	}

	public AgeRating getAgeRating() {
		return ageRating;
	}

	public int getCriticsScore() {
		return criticsScore;
	}

	public boolean matches(String query) {
		return title.toLowerCase().contains(query.toLowerCase());
	}

	@Override
	public String toString() {
		return String.format("%s (%d, %s) • %s • %d분 • 평론 %d", title, year, type, ageRating, durationMinutes,
				criticsScore);
	}
}
