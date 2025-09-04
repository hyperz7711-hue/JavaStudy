package com.kh.ott.controller;

import java.util.List;
import com.kh.ott.model.Content;
import com.kh.ott.service.SearchService;

public class SearchController {
	private final SearchService service;

	public SearchController(SearchService service) {
		this.service = service;
	}

	public List<Content> search(String title) {
		return service.findByTitle(title);
	}
}