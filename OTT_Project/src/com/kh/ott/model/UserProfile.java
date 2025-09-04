package com.kh.ott.model;

import java.util.Set;
import java.util.EnumSet;
import com.kh.ott.model.enumtype.*;

public class UserProfile {
	private String name;
	private UserPreference pref; // 품질/예산 등
	private Set<Genre> favoriteGenres = EnumSet.noneOf(Genre.class);
	private AgeRating preferAgeRating = AgeRating.ALL;
	private int minCriticsScore = 0;

	public UserProfile(String name, UserPreference pref) {
		this.name = name;
		this.pref = pref;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserPreference getPref() {
		return pref;
	}

	public void setPref(UserPreference pref) {
		this.pref = pref;
	}

	public Set<Genre> getFavoriteGenres() {
		return favoriteGenres;
	}

	public void setFavoriteGenres(Set<Genre> genres) {
		this.favoriteGenres = genres;
	}

	public AgeRating getPreferAgeRating() {
		return preferAgeRating;
	}

	public void setPreferAgeRating(AgeRating ar) {
		this.preferAgeRating = ar;
	}

	public int getMinCriticsScore() {
		return minCriticsScore;
	}

	public void setMinCriticsScore(int s) {
		this.minCriticsScore = s;
	}
}
