package com.kh.ott.service;

import java.util.*;
import com.kh.ott.model.*;
import com.kh.ott.dto.PlatformPlanMatch;
import com.kh.ott.repository.DataStore;

public class MatchingService {
	private final DataStore ds;

	public MatchingService(DataStore ds) {
		this.ds = ds;
	}

	public List<PlatformPlanMatch> listAvailability(long contentId) {
		List<PlatformPlanMatch> out = new ArrayList<>();
		for (Availability av : ds.availability()) {
			if (av.getContentId() == contentId) {
				Platform p = ds.platforms().get(av.getPlatformId());
				for (Plan plan : p.getPlans()) {
					if (av.isAvailableOn(plan.getId())) {
						out.add(new PlatformPlanMatch(p, plan, av.getOfferType()));
					}
				}
			}
		}
		out.sort(Comparator.comparingInt(a -> a.getPlan().getMonthlyFee()));
		return out;
	}
}
