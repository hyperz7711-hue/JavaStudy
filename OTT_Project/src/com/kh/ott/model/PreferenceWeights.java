package com.kh.ott.model;

public class PreferenceWeights {
	private double price;
	private double quality;
	private double audio;
	private double ads;

	public PreferenceWeights(double price, double quality, double audio, double ads) {
		this.price = price;
		this.quality = quality;
		this.audio = audio;
		this.ads = ads;
	}

	public double getPrice() {
		return price;
	}

	public double getQuality() {
		return quality;
	}

	public double getAudio() {
		return audio;
	}

	public double getAds() {
		return ads;
	}
}
