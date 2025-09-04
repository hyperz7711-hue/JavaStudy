package com.kh.ott.repository;

import java.util.*;
import com.kh.ott.model.*;
import com.kh.ott.model.enumtype.*;

public class DataStore {
	private final Map<Long, Content> contents = new LinkedHashMap<>();
	private final Map<Long, Platform> platforms = new LinkedHashMap<>();
	private final Map<Long, Plan> plans = new LinkedHashMap<>();
	private final List<Availability> availability = new ArrayList<>();

	public Map<Long, Content> contents() {
		return contents;
	}

	public Map<Long, Platform> platforms() {
		return platforms;
	}

	public Map<Long, Plan> plans() {
		return plans;
	}

	public List<Availability> availability() {
		return availability;
	}

	public static DataStore seedKR() {
		DataStore ds = new DataStore();
		// Platforms
		Platform netflix = new Platform(1, "Netflix", "KR");
		Platform disney = new Platform(2, "Disney+", "KR");
		Platform wavve = new Platform(3, "Wavve", "KR");
		Platform tving = new Platform(4, "TVING", "KR");
		Platform watcha = new Platform(5, "Watcha", "KR");
		ds.platforms.put(1L, netflix);
		ds.platforms.put(2L, disney);
		ds.platforms.put(3L, wavve);
		ds.platforms.put(4L, tving);
		ds.platforms.put(5L, watcha);
		// Plans
		Plan nfStd = new Plan(11, 1, "Standard", 13500, Quality.FULL_HD, Hdr.NONE, Audio._5_1, 2, false);
		Plan nfPre = new Plan(12, 1, "Premium", 17000, Quality.UHD_4K, Hdr.DOLBY_VISION, Audio.DOLBY_ATMOS, 4, false);
		Plan dpStd = new Plan(21, 2, "Standard", 9900, Quality.UHD_4K, Hdr.HDR10, Audio._5_1, 4, false);
		Plan wvStd = new Plan(31, 3, "Standard", 7900, Quality.HD, Hdr.NONE, Audio.STEREO, 2, true);
		Plan tvStd = new Plan(41, 4, "Standard", 7900, Quality.HD, Hdr.NONE, Audio._5_1, 2, true);
		Plan wcStd = new Plan(51, 5, "Standard", 7900, Quality.FULL_HD, Hdr.NONE, Audio.STEREO, 1, false);
		ds.plans.put(11L, nfStd);
		ds.plans.put(12L, nfPre);
		ds.plans.put(21L, dpStd);
		ds.plans.put(31L, wvStd);
		ds.plans.put(41L, tvStd);
		ds.plans.put(51L, wcStd);
		netflix.addPlan(nfStd);
		netflix.addPlan(nfPre);
		disney.addPlan(dpStd);
		wavve.addPlan(wvStd);
		tving.addPlan(tvStd);
		watcha.addPlan(wcStd);
		// Contents (with duration, age, critics)
		Content inter = new Content(101, "Interstellar", 2014, ContentType.MOVIE, EnumSet.of(Genre.SCIFI, Genre.DRAMA),
				169, AgeRating.AGE12, 86);
		Content bear = new Content(102, "The Bear", 2022, ContentType.SERIES, EnumSet.of(Genre.DRAMA), 30,
				AgeRating.AGE15, 95);
		Content detective = new Content(103, "Detective Seoul", 2023, ContentType.SERIES,
				EnumSet.of(Genre.THRILLER, Genre.DRAMA), 60, AgeRating.AGE15, 72);
		ds.contents.put(101L, inter);
		ds.contents.put(102L, bear);
		ds.contents.put(103L, detective);
		// Availability
		ds.availability.add(new Availability(101, 1, OfferType.SUBSCRIPTION,
				new HashSet<>(java.util.Arrays.asList(11L, 12L))));
		ds.availability.add(new Availability(101, 2, OfferType.SUBSCRIPTION,
				new HashSet<>(java.util.Arrays.asList(21L))));
		ds.availability.add(new Availability(102, 2, OfferType.SUBSCRIPTION,
				new HashSet<>(java.util.Arrays.asList(21L))));
		ds.availability.add(new Availability(103, 3, OfferType.SUBSCRIPTION,
				new HashSet<>(java.util.Arrays.asList(31L))));
		return ds;
	}
}
