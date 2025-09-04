package com.kh.ott.controller;

import java.util.List;
import com.kh.ott.dto.Recommendation;
import com.kh.ott.model.UserPreference;
import com.kh.ott.service.RecommendationService;

public class RecommendController {
	private final RecommendationService service;

	public RecommendController(RecommendationService service) {
		this.service = service;
	}

	public List<Recommendation> recommend(long contentId, UserPreference pref, int n) {
		return service.recommend(contentId, pref, n);
	}
}