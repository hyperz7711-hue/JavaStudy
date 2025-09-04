package com.kh.ott.service;

import java.util.*;
import com.kh.ott.model.Content;
import com.kh.ott.repository.DataStore;

public class SearchService {
	private final DataStore ds;

	public SearchService(DataStore ds) {
		this.ds = ds;
	}

	public List<Content> findByTitle(String query) {
		List<Content> list = new ArrayList<>();
		for (Content c : ds.contents().values()) {
			if (c.matches(query))
				list.add(c);
		}
		list.sort(Comparator.comparing(Content::getTitle));
		return list;
	}
}
