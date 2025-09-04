package com.kh.ott.model;

import com.kh.ott.model.enumtype.Quality;
import com.kh.ott.model.enumtype.Hdr;
import com.kh.ott.model.enumtype.Audio;

public class UserPreference {
	private int budgetKRW;
	private Quality preferQuality;
	private Hdr preferHdr;
	private Audio preferAudio;
	private boolean allowAds;
	private PreferenceWeights weights;

	public UserPreference(int budgetKRW, Quality preferQuality, Hdr preferHdr, Audio preferAudio, boolean allowAds,
			PreferenceWeights weights) {
		this.budgetKRW = budgetKRW;
		this.preferQuality = preferQuality;
		this.preferHdr = preferHdr;
		this.preferAudio = preferAudio;
		this.allowAds = allowAds;
		this.weights = weights;
	}

	public int getBudgetKRW() {
		return budgetKRW;
	}

	public Quality getPreferQuality() {
		return preferQuality;
	}

	public Hdr getPreferHdr() {
		return preferHdr;
	}

	public Audio getPreferAudio() {
		return preferAudio;
	}

	public boolean isAllowAds() {
		return allowAds;
	}

	public PreferenceWeights getWeights() {
		return weights;
	}

	public UserPreference withBudget(int won) {
		this.budgetKRW = won;
		return this;
	}
}
