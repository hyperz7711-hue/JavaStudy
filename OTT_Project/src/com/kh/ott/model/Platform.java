package com.kh.ott.model;

import java.util.ArrayList;
import java.util.List;

public class Platform {
	private long id;
	private String name;
	private String region;
	private List<Plan> plans = new ArrayList<>();

	public Platform(long id, String name, String region) {
		this.id = id;
		this.name = name;
		this.region = region;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRegion() {
		return region;
	}

	public List<Plan> getPlans() {
		return plans;
	}

	public void addPlan(Plan p) {
		plans.add(p);
	}

	@Override
	public String toString() {
		return name + " (" + region + ")";
	}
}
