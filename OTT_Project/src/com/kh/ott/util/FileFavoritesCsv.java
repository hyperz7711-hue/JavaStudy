package com.kh.ott.util;

import java.io.*;
import com.kh.ott.repository.*;
import com.kh.ott.model.*;

public class FileFavoritesCsv {
	public static void exportFavorites(DataStore ds, UserState state, File file) throws IOException {
		try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
			pw.println("id,title,year,type,duration,ageRating,critics");
			for (Long id : state.getWishlist()) {
				Content c = ds.contents().get(id);
				if (c == null)
					continue;
				pw.printf("%d,%s,%d,%s,%d,%s,%d%n", c.getId(), esc(c.getTitle()), c.getYear(), c.getType(),
						c.getDurationMinutes(), c.getAgeRating(), c.getCriticsScore());
			}
		}
	}

	private static String esc(String s) {
		return s.replace("\\", "\\\\").replace(",", "\\,");
	}
}
