package com.kh.ott.controller;

import java.util.List;
import com.kh.ott.dto.PlatformPlanMatch;
import com.kh.ott.service.MatchingService;

public class CompareController {
	private final MatchingService service;

	public CompareController(MatchingService service) {
		this.service = service;
	}

	public List<PlatformPlanMatch> compare(long contentId) {
		return service.listAvailability(contentId);
	}
}