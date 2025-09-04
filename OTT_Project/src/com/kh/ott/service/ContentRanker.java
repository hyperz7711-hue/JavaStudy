package com.kh.ott.service;

import java.util.*;
import com.kh.ott.model.*;
import com.kh.ott.model.enumtype.*;

public class ContentRanker {
	public int rankScore(Content c, UserProfile profile) {
		int score = 0;
		// 평론 점수 (0~100 비례)
		score += c.getCriticsScore();
		// 장르 가중 (선호 장르와 교집합 크기 * 10)
		if (profile.getFavoriteGenres() != null) {
			int inter = 0;
			for (Genre g : profile.getFavoriteGenres()) {
				if (c.getGenres().contains(g))
					inter++;
			}
			score += inter * 10;
		}
		// 등급 선호: 동일 등급 +10, 낮은 등급 +5, 높은 등급 -20
		int cmp = c.getAgeRating().ordinal() - profile.getPreferAgeRating().ordinal();
		if (cmp == 0)
			score += 10;
		else if (cmp < 0)
			score += 5;
		else
			score -= 20;
		return score;
	}

	public List<Content> sortByPreference(List<Content> list, UserProfile profile) {
		list.sort((a, b) -> Integer.compare(rankScore(b, profile), rankScore(a, profile)));
		return list;
	}
}
