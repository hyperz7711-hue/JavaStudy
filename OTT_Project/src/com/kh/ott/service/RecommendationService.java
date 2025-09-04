package com.kh.ott.service;

import java.util.*;
import com.kh.ott.dto.*;
import com.kh.ott.model.*;

public class RecommendationService {
	private final MatchingService matching;
	private final ScoringService scoring;

	public RecommendationService(MatchingService matching, ScoringService scoring) {
		this.matching = matching;
		this.scoring = scoring;
	}

	public List<Recommendation> recommend(long contentId, UserPreference pref, int limit) {
		List<PlatformPlanMatch> matches = matching.listAvailability(contentId);
		List<Recommendation> recs = new ArrayList<>();
		for (PlatformPlanMatch m : matches) {
			int s = scoring.score(m.getPlan(), pref);
			recs.add(new Recommendation(m.getPlatform().getName(), m.getPlan().getName(), s,
					String.format("%,d원 / %s / %s", m.getPlan().getMonthlyFee(), m.getPlan().getMaxQuality(),
							m.getPlan().getAudio())));
		}
		Collections.sort(recs);
		if (recs.size() > limit)
			return recs.subList(0, limit);
		return recs;
	}
}
