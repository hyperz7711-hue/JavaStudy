package com.kh.ott.model;

import java.util.Set;
import com.kh.ott.model.enumtype.OfferType;

public class Availability {
	private long contentId;
	private long platformId;
	private OfferType offerType;
	private Set<Long> planIds;

	public Availability(long contentId, long platformId, OfferType offerType, Set<Long> planIds) {
		this.contentId = contentId;
		this.platformId = platformId;
		this.offerType = offerType;
		this.planIds = planIds;
	}

	public long getContentId() {
		return contentId;
	}

	public long getPlatformId() {
		return platformId;
	}

	public OfferType getOfferType() {
		return offerType;
	}

	public Set<Long> getPlanIds() {
		return planIds;
	}

	public boolean isAvailableOn(long planId) {
		return planIds == null || planIds.isEmpty() || planIds.contains(planId);
	}
}
