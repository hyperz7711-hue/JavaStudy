package com.kh.ott;

import java.util.*;
import com.kh.ott.dto.PlatformPlanMatch;
import com.kh.ott.model.*;
import com.kh.ott.repository.*;

public class AppHelper {
	public static Plan findPlan(Repositories repos, long planId) {
		return repos.readPlan(planId).orElse(null);
	}

	public static void printMatches(java.util.List<PlatformPlanMatch> list) {
		System.out.println("플랫폼\t플랜\t요약");
		for (PlatformPlanMatch m : list) {
			System.out.printf("%s\t%s\t%s%n", m.getPlatform().getName(), m.getPlan().getName(), m.getPlan().describe());
		}
	}

	public static String genresToString(java.util.Set<com.kh.ott.model.enumtype.Genre> gs) {
		if (gs == null || gs.isEmpty())
			return "-";
		StringBuilder sb = new StringBuilder();
		for (var g : gs) {
			if (sb.length() > 0)
				sb.append("/");
			sb.append(g.name());
		}
		return sb.toString();
	}
}
