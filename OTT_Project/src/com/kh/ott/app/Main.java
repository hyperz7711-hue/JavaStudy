package com.kh.ott.app;

import com.kh.ott.repository.*;
import com.kh.ott.service.*;
import com.kh.ott.controller.*;
import com.kh.ott.view.ConsoleView;

public class Main {
	public static void main(String[] args) {
		DataStore ds = DataStore.seedKR();
		SearchService search = new SearchService(ds);
		MatchingService matching = new MatchingService(ds);
		ScoringService scoring = new ScoringService();
		RecommendationService reco = new RecommendationService(matching, scoring);
		SearchController sc = new SearchController(search);
		CompareController cc = new CompareController(matching);
		RecommendController rc = new RecommendController(reco);
		Repositories repos = new Repositories(ds);
		TopCharts charts = new TopCharts();
		ConsoleView view = new ConsoleView(sc, cc, rc, repos, ds, charts);
		view.start();
	}
}
