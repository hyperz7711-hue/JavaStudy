package com.kh.ott.util;

import java.io.*;
import java.util.*;
import com.kh.ott.model.*;
import com.kh.ott.model.enumtype.*;
import com.kh.ott.repository.*;

@SuppressWarnings("unchecked")
public class FileChartsJson {
	public static TopCharts importCharts(DataStore ds, File file) throws IOException {
		String text = new String(java.nio.file.Files.readAllBytes(file.toPath()));
		Object obj = SimpleJson.parse(text);
		if (!(obj instanceof Map))
			throw new IOException("JSON root must be object");
		Map<String, Object> root = (Map<String, Object>) obj;
		Object provs = root.get("providers");
		if (!(provs instanceof List))
			throw new IOException("'providers' must be array");
		TopCharts charts = new TopCharts();
		for (Object pObj : (List<Object>) provs) {
			Map<String, Object> p = (Map<String, Object>) pObj;
			String name = (String) p.get("name");
			Long platformId = ensurePlatform(ds, name);
			List<Object> top = (List<Object>) p.get("top10");
			List<Long> ids = new ArrayList<>();
			for (Object cObj : top) {
				Map<String, Object> c = (Map<String, Object>) cObj;
				long id = ((Number) c.getOrDefault("id", System.nanoTime())).longValue();
				String title = (String) c.get("title");
				int year = ((Number) c.getOrDefault("year", 0)).intValue();
				ContentType type = ContentType.valueOf(((String) c.getOrDefault("type", "MOVIE")).toUpperCase());
				java.util.Set<Genre> gs = java.util.EnumSet.noneOf(Genre.class);
				Object genres = c.get("genres");
				if (genres instanceof List) {
					for (Object g : (List<Object>) genres)
						gs.add(Genre.valueOf(((String) g).toUpperCase()));
				}
				int duration = ((Number) c.getOrDefault("duration", 0)).intValue();
				AgeRating ar = AgeRating.valueOf(((String) c.getOrDefault("ageRating", "ALL")).toUpperCase());
				int critics = ((Number) c.getOrDefault("critics", 0)).intValue();
				// put content if missing
				if (!ds.contents().containsKey(id)) {
					ds.contents().put(id, new Content(id, title, year, type, gs, duration, ar, critics));
				}
				// availability link to the platform
				ds.availability()
						.add(new Availability(id, platformId, OfferType.SUBSCRIPTION, new java.util.HashSet<>()));
				ids.add(id);
			}
			charts.put(name, ids);
		}
		return charts;
	}

	private static Long ensurePlatform(DataStore ds, String name) {
		for (Platform p : ds.platforms().values()) {
			if (p.getName().equalsIgnoreCase(name))
				return p.getId();
		}
		long id = 100 + ds.platforms().size();
		Platform p = new Platform(id, name, "KR");
		ds.platforms().put(id, p);
		// add a default plan
		Plan plan = new Plan(id * 10 + 1, id, "Standard", 9900, Quality.FULL_HD, Hdr.NONE, Audio._5_1, 2, false);
		ds.plans().put(plan.getId(), plan);
		p.addPlan(plan);
		return p.getId();
	}
}
