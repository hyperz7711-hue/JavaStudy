package com.kh.ott.dto;

import com.kh.ott.model.Platform;
import com.kh.ott.model.Plan;
import com.kh.ott.model.enumtype.OfferType;

public class PlatformPlanMatch {
	private Platform platform;
	private Plan plan;
	private OfferType offerType;

	public PlatformPlanMatch(Platform p, Plan plan, OfferType type) {
		this.platform = p;
		this.plan = plan;
		this.offerType = type;
	}

	public Platform getPlatform() {
		return platform;
	}

	public Plan getPlan() {
		return plan;
	}

	public OfferType getOfferType() {
		return offerType;
	}

	@Override
	public String toString() {
		return platform.getName() + " - " + plan.describe();
	}
}
