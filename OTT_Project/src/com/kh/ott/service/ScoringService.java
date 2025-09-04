package com.kh.ott.service;

import com.kh.ott.model.*;
import com.kh.ott.model.enumtype.*;

public class ScoringService {
	public int score(Plan plan, UserPreference pref) {
		int priceScore = (int) Math.max(0,
				(1.0 - (plan.getMonthlyFee() / (double) Math.max(1, pref.getBudgetKRW()))) * 100);
		int qualityScore = stepMatchQuality(plan.getMaxQuality(), pref.getPreferQuality());
		int audioScore = stepMatchAudio(plan.getAudio(), pref.getPreferAudio());
		int adsScore = pref.isAllowAds() ? 100 : (plan.isAds() ? 0 : 100);
		PreferenceWeights w = pref.getWeights();
		double finalScore = priceScore * w.getPrice() + qualityScore * w.getQuality() + audioScore * w.getAudio()
				+ adsScore * w.getAds();
		return (int) Math.round(finalScore);
	}

	private int stepMatchQuality(Quality a, Quality b) {
		if (a == b)
			return 100;
		switch (a) {
		case UHD_4K:
			return b == Quality.FULL_HD ? 70 : 40;
		case FULL_HD:
			return b == Quality.UHD_4K ? 70 : (b == Quality.HD ? 70 : 40);
		case HD:
			return b == Quality.FULL_HD ? 70 : 40;
		case SD:
		default:
			return 10;
		}
	}

	private int stepMatchAudio(Audio a, Audio b) {
		if (a == b)
			return 100;
		if (a == Audio.DOLBY_ATMOS)
			return b == Audio._5_1 ? 70 : 40;
		if (a == Audio._5_1)
			return b == Audio.DOLBY_ATMOS ? 70 : 40;
		return 40;
	}
}
