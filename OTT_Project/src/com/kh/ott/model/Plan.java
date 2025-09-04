package com.kh.ott.model;

import com.kh.ott.model.enumtype.Quality;
import com.kh.ott.model.enumtype.Hdr;
import com.kh.ott.model.enumtype.Audio;

public class Plan {
	private long id;             // 임의채번 키값
	private long platformId;     
	private String name;         
	private int monthlyFee;
	private Quality maxQuality;
	private Hdr hdr;
	private Audio audio;
	private int concurrentStreams;
	private boolean ads;

	public Plan(long id, long platformId, String name, int monthlyFee, Quality maxQuality, Hdr hdr, Audio audio,
			int concurrentStreams, boolean ads) {
		this.id = id;
		this.platformId = platformId;
		this.name = name;
		this.monthlyFee = monthlyFee;
		this.maxQuality = maxQuality;
		this.hdr = hdr;
		this.audio = audio;
		this.concurrentStreams = concurrentStreams;
		this.ads = ads;
	}

	public long getId() {
		return id;
	}

	public long getPlatformId() {
		return platformId;
	}

	public String getName() {
		return name;
	}

	public int getMonthlyFee() {
		return monthlyFee;
	}

	public Quality getMaxQuality() {
		return maxQuality;
	}

	public Hdr getHdr() {
		return hdr;
	}

	public Audio getAudio() {
		return audio;
	}

	public int getConcurrentStreams() {
		return concurrentStreams;
	}

	public boolean isAds() {
		return ads;
	}

	public void setMonthlyFee(int fee) {
		this.monthlyFee = fee;
	}

	public void setName(String n) {
		this.name = n;
	}

	public String describe() {
		return String.format("%s | %,d원 | %s / %s / %s | 동시%d | 광고%s", name, monthlyFee, maxQuality, hdr, audio,
				concurrentStreams, ads ? "Y" : "N");
	}
}
