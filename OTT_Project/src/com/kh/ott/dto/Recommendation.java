package com.kh.ott.dto;

public class Recommendation implements Comparable<Recommendation> {
	private String platformName;
	private String planName;
	private int score;
	private String reason;

	public Recommendation(String platformName, String planName, int score, String reason) {
		this.platformName = platformName;
		this.planName = planName;
		this.score = score;
		this.reason = reason;
	}

	public String getPlatformName() {
		return platformName;
	}

	public String getPlanName() {
		return planName;
	}

	public int getScore() {
		return score;
	}

	public String getReason() {
		return reason;
	}

	@Override
	public int compareTo(Recommendation o) {
		return Integer.compare(o.score, this.score);
	}

	@Override
	public String toString() {
		return String.format("%s / %s -> %d점 (%s)", platformName, planName, score, reason);
	}
}
