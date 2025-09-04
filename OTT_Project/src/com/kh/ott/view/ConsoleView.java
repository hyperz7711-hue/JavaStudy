package com.kh.ott.view;

import java.util.*;
import java.io.File;
import com.kh.ott.controller.*;
import com.kh.ott.dto.*;
import com.kh.ott.model.*;
import com.kh.ott.model.enumtype.*;
import com.kh.ott.repository.*;
import com.kh.ott.service.*;
import com.kh.ott.util.*;
import com.kh.ott.AppHelper;

public class ConsoleView {
	private final SearchController search;
	private final CompareController compare;
	private final RecommendController recommend;
	private final Repositories repos;
	private final DataStore ds;
	private final TopCharts charts;
	private final UserState state = new UserState();
	private final Scanner sc = new Scanner(System.in);
	private final ContentRanker ranker = new ContentRanker();
	private UserProfile profile;

	public ConsoleView(SearchController s, CompareController c, RecommendController r, Repositories repos, DataStore ds,
			TopCharts charts) {
		this.search = s;
		this.compare = c;
		this.recommend = r;
		this.repos = repos;
		this.ds = ds;
		this.charts = charts;
	}

	public void start() {
		if (profile == null) {
			// 기본 프로필
			profile = new UserProfile("user", new UserPreference(12000, Quality.FULL_HD, Hdr.NONE, Audio._5_1, true,
					new PreferenceWeights(0.35, 0.35, 0.2, 0.1)));
			state.setProfile(profile);
		}
		while (true) {
			System.out.println("=== 어떤 OTT가 나에게 적합한가? ===");
			System.out.println("1. 사용자 정보 입력");
			System.out.println("2. 사용자 정보 조회 및 수정");
			System.out.println("3. 찾을 콘텐츠 제목 ");
			System.out.println("4. 찜한 컨텐츠 조회 및 수정 ");
			System.out.println("5. 찜한 리스트 파일로 내보내기");
			if (!charts.isEmpty()) {
				if (charts.has("Netflix"))
					System.out.println("30. 넷플릭스 TOP 10 리스트");
				if (charts.has("TVING"))
					System.out.println("31. 티빙 TOP 10 리스트 ");
				if (charts.has("Disney+") || charts.has("Disney"))
					System.out.println("32. 디즈니 TOP 10 리스트 ");
				if (charts.has("Watcha") || charts.has("WATCHA"))
					System.out.println("33. 왓챠 TOP 10 리스트 ");
			}
			System.out.println("97. OTT 데이터 가져오기 ( JSON으로 입력할 데이터 추가)");
			System.out.println("98. 추천 OTT 구독 확인하기");
			System.out.println("99. 종료하기(x)");
			System.out.print("선택: ");
			String k = sc.nextLine().trim();
			switch (k) {
			case "1" -> inputUserInfo();
			case "2" -> viewEditUserInfo();
			case "3" -> searchTitleAndWishlist();
			case "4" -> viewEditWishlist();
			case "5" -> exportWishlist();
			case "30" -> chartMenu("Netflix");
			case "31" -> chartMenu("TVING");
			case "32" -> chartMenu(charts.has("Disney+") ? "Disney+" : "Disney");
			case "33" -> chartMenu(charts.has("Watcha") ? "Watcha" : "WATCHA");
			case "97" -> loadChartsJson();
			case "98" -> recommendSubscriptions();
			case "99", "x", "X" -> {
				System.out.println("Bye");
				return;
			}
			default -> System.out.println("잘못 선택\n");
			}
		}
	}

	// 1. 사용자 정보 입력
	private void inputUserInfo() {
		System.out.print("사용자 이름: ");
		String name = sc.nextLine().trim();
		System.out.print("예산(KRW): ");
		int budget = safeInt(sc.nextLine());
		Quality q = askQuality();
		Hdr h = askHdr();
		Audio a = askAudio();
		System.out.print("광고 허용? (y/n): ");
		boolean allowAds = sc.nextLine().trim().equalsIgnoreCase("y");
		System.out.print("선호 장르(콤마, 예: DRAMA,SCIFI): ");
		Set<Genre> gs = java.util.EnumSet.noneOf(Genre.class);
		String gl = sc.nextLine().trim();
		if (!gl.isEmpty()) {
			for (String s : gl.split(","))
				gs.add(Genre.valueOf(s.trim().toUpperCase()));
		}
		System.out.print("선호 등급(ALL/AGE12/AGE15/ADULT18): ");
		AgeRating ar = AgeRating.valueOf(sc.nextLine().trim().toUpperCase());
		System.out.print("최소 평론 점수(0~100): ");
		int minCrit = safeInt(sc.nextLine());
		PreferenceWeights w = new PreferenceWeights(0.35, 0.35, 0.2, 0.1);
		profile = new UserProfile(name, new UserPreference(budget, q, h, a, allowAds, w));
		profile.setFavoriteGenres(gs);
		profile.setPreferAgeRating(ar);
		profile.setMinCriticsScore(minCrit);
		state.setProfile(profile);
		System.out.println("저장 완료\n");
	}

	// 2. 사용자 정보 조회/수정
	private void viewEditUserInfo() {
		if (profile == null) {
			System.out.println("프로필이 없습니다. 먼저 입력하세요.\n");
			return;
		}
		System.out.println("-- 사용자 정보 --");
		System.out.println("이름: " + profile.getName());
		UserPreference p = profile.getPref();
		System.out.printf("예산: %,d / 화질: %s / HDR: %s / 오디오: %s / 광고허용: %s%n", p.getBudgetKRW(), p.getPreferQuality(),
				p.getPreferHdr(), p.getPreferAudio(), p.isAllowAds());
		System.out.println("선호 장르: " + profile.getFavoriteGenres());
		System.out.println("선호 등급: " + profile.getPreferAgeRating());
		System.out.println("최소 평론 점수: " + profile.getMinCriticsScore());
		System.out.print("변경하시겠습니까? (y/n): ");
		if (sc.nextLine().trim().equalsIgnoreCase("y"))
			inputUserInfo();
	}

	// 3. 제목 검색 + 선호순 정렬 + 찜하기
	private void searchTitleAndWishlist() {
		System.out.print("찾을 콘텐츠 제목 (전체=빈 입력): ");
		String q = sc.nextLine().trim();
		List<Content> list;
		if (q.isEmpty())
			list = new ArrayList<>(ds.contents().values());
		else
			list = search.search(q);
		// 필터: 최소 평론점수, 등급
		list.removeIf(c -> c.getCriticsScore() < profile.getMinCriticsScore()
				|| c.getAgeRating().ordinal() > profile.getPreferAgeRating().ordinal());
		// 선호 순 정렬
		ranker.sortByPreference(list, profile);
		printContentList(list);
		System.out.print("찜할 번호들(콤마, 미선택=엔터): ");
		String s = sc.nextLine().trim();
		if (!s.isEmpty()) {
			Set<Long> add = new LinkedHashSet<>();
			for (String tok : s.split(",")) {
				int idx = safeInt(tok.trim()) - 1;
				if (idx >= 0 && idx < list.size())
					add.add(list.get(idx).getId());
			}
			state.addWishlist(add);
			System.out.println("찜 추가 완료\n");
		}
	}

	// 4. 찜 목록 조회/수정
	private void viewEditWishlist() {
		List<Content> list = new ArrayList<>();
		for (Long id : state.getWishlist()) {
			Content c = ds.contents().get(id);
			if (c != null)
				list.add(c);
		}
		if (list.isEmpty()) {
			System.out.println("찜 목록이 비어있습니다.\n");
			return;
		}
		System.out.println("[찜한 콘텐츠]");
		printContentList(list);
		System.out.print("찜 취소 번호들(콤마, 전체=all, 건너뛰기=엔터): ");
		String s = sc.nextLine().trim();
		if (s.equalsIgnoreCase("all")) {
			state.clearWishlist();
			System.out.println("모두 취소\n");
			return;
		}
		if (!s.isEmpty()) {
			String[] arr = s.split(",");
			for (String tok : arr) {
				int idx = safeInt(tok.trim()) - 1;
				if (idx >= 0 && idx < list.size())
					state.removeWishlist(list.get(idx).getId());
			}
			System.out.println("취소 완료\n");
		}
	}

	// 5. 찜 리스트 파일로 내보내기
	private void exportWishlist() {
		try {
			System.out.print("저장할 파일 경로(.csv): ");
			String path = sc.nextLine().trim();
			FileFavoritesCsv.exportFavorites(ds, state, new File(path));
			System.out.println("저장 완료: " + path + "\n");
		} catch (Exception e) {
			System.out.println("오류: " + e.getMessage());
		}
	}

	// 30~33. 플랫폼 TOP 10 (페이지당 10개, 멀티 선택하여 찜 추가)
	private void chartMenu(String provider) {
		if (!charts.has(provider)) {
			System.out.println("해당 제공자 차트가 없습니다.");
			return;
		}
		List<Long> ids = charts.get(provider);
		List<Content> list = new ArrayList<>();
		for (Long id : ids) {
			Content c = ds.contents().get(id);
			if (c != null)
				list.add(c);
		}
		if (list.isEmpty()) {
			System.out.println("차트에 표시할 콘텐츠가 없습니다.");
			return;
		}

		int page = 0;
		final int PAGE_SIZE = 10;
		Set<Long> candidates = new LinkedHashSet<>(); // 선택 누적
		while (true) {
			int from = page * PAGE_SIZE;
			int to = Math.min(from + PAGE_SIZE, list.size());
			if (from >= list.size()) {
				page = 0;
				from = 0;
				to = Math.min(PAGE_SIZE, list.size());
			}
			System.out.println("[" + provider + " TOP 리스트] 페이지 " + (page + 1) + " / "
					+ ((list.size() + PAGE_SIZE - 1) / PAGE_SIZE));
			for (int i = from; i < to; i++) {
				Content c = list.get(i);
				int no = (i - from) + 1; // 페이지 내 번호 1~10
				System.out.printf("%d) %s | %s | %s | %d분 | 평론 %d | 장르:%s%n", no, c.getTitle(), c.getType(),
						c.getAgeRating(), c.getDurationMinutes(), c.getCriticsScore(),
						AppHelper.genresToString(c.getGenres()));
			}
			System.out.println("명령: 번호들(콤마) 추가, n=다음, p=이전, s=선택완료, q=취소");
			System.out.print("> ");
			String cmd = sc.nextLine().trim();
			if (cmd.equalsIgnoreCase("n")) {
				page++;
				if (page * PAGE_SIZE >= list.size())
					page = 0;
				continue;
			}
			if (cmd.equalsIgnoreCase("p")) {
				page--;
				if (page < 0)
					page = (list.size() - 1) / PAGE_SIZE;
				continue;
			}
			if (cmd.equalsIgnoreCase("q")) {
				System.out.println("취소했습니다.");
				return;
			}
			if (cmd.equalsIgnoreCase("s")) {
				if (!candidates.isEmpty()) {
					state.addWishlist(candidates);
					System.out.println("찜 추가 완료 (" + candidates.size() + "개)");
				} else
					System.out.println("선택한 항목이 없습니다.");
				return;
			}

			if (!cmd.isEmpty()) {
				String[] toks = cmd.split(",");
				for (String t : toks) {
					int local = safeInt(t.trim());
					if (local >= 1 && local <= Math.min(PAGE_SIZE, to - from)) {
						Content c = list.get(from + (local - 1));
						candidates.add(c.getId());
					}
				}
				System.out.println("현재 선택 수: " + candidates.size());
			}

			if (list.isEmpty()) {
				System.out.println("차트에 표시할 콘텐츠가 없습니다.\n");
				return;
			}

			System.out.println("[" + provider + " TOP 10]");
			printContentList(list);
			System.out.print("찜할 순번들(콤마): ");
			String s = sc.nextLine().trim();
			if (!s.isEmpty()) {
				Set<Long> add = new LinkedHashSet<>();
				for (String tok : s.split(",")) {
					int idx = safeInt(tok.trim()) - 1;
					if (idx >= 0 && idx < list.size())
						add.add(list.get(idx).getId());
				}
				state.addWishlist(add);
				System.out.println("찜 추가 완료\n");
			}
		}
	}

	// 97. JSON 가져오기
	private void loadChartsJson() {
		try {
			System.out.print("JSON 파일 경로: ");
			String path = sc.nextLine().trim();
			TopCharts tc = FileChartsJson.importCharts(ds, new File(path));
			// replace charts
			for (String provider : tc.providers()) {
				java.util.List<Long> list = tc.get(provider);
				if (!list.isEmpty())
					charts.put(provider, list);
			}
			System.out.println("불러오기 완료. TOP10 메뉴가 활성화되었습니다.\n");
		} catch (Exception e) {
			System.out.println("오류: " + e.getMessage());
		}
	}

	// 98. 추천 OTT 구독 확인 (찜한 콘텐츠의 합산 점수 높은 순)
	private void recommendSubscriptions() {
		if (state.getWishlist().isEmpty()) {
			System.out.println("찜 목록이 비어있습니다.\n");
			return;
		}
		Map<Long, Integer> scoreSum = new LinkedHashMap<>();
		Map<Long, Integer> countAvail = new LinkedHashMap<>();
		for (Platform p : ds.platforms().values()) {
			scoreSum.put(p.getId(), 0);
			countAvail.put(p.getId(), 0);
		}
		ScoringService ss = new ScoringService();
		MatchingService ms = new MatchingService(ds);
		for (Long cid : state.getWishlist()) {
			List<PlatformPlanMatch> avail = ms.listAvailability(cid);
			// group by platform, pick best plan score
			Map<Long, Integer> best = new HashMap<>();
			for (PlatformPlanMatch m : avail) {
				int s = ss.score(m.getPlan(), profile.getPref());
				best.merge(m.getPlatform().getId(), s, Math::max);
			}
			for (Map.Entry<Long, Integer> e : best.entrySet()) {
				scoreSum.put(e.getKey(), scoreSum.get(e.getKey()) + e.getValue());
				countAvail.put(e.getKey(), countAvail.get(e.getKey()) + 1);
			}
		}
		// sort by score desc
		List<Platform> plats = new ArrayList<>(ds.platforms().values());
		plats.sort((a, b) -> Integer.compare(scoreSum.get(b.getId()), scoreSum.get(a.getId())));
		System.out.println("[찜 기반 추천 구독 순위]");
		for (int i = 0; i < plats.size(); i++) {
			Platform p = plats.get(i);
			int sum = scoreSum.get(p.getId());
			int cnt = countAvail.get(p.getId());
			if (cnt == 0)
				continue;
			System.out.printf("%d) %s : 합산점수 %d (찜 %d개 제공)%n", i + 1, p.getName(), sum, cnt);
		}
		System.out.println();
	}

	// helpers
	private void printContentList(List<Content> list) {
		for (int i = 0; i < list.size(); i++) {
			Content c = list.get(i);
			System.out.printf("%d) %s | %s | %s | %d분 | 평론 %d | 장르:%s%n", i + 1, c.getTitle(), c.getType(),
					c.getAgeRating(), c.getDurationMinutes(), c.getCriticsScore(),
					AppHelper.genresToString(c.getGenres()));
		}
	}

	private Quality askQuality() {
		System.out.print("선호 화질(1:SD,2:HD,3:FHD,4:UHD_4K): ");
		switch (safeInt(sc.nextLine())) {
		case 1:
			return Quality.SD;
		case 2:
			return Quality.HD;
		case 3:
			return Quality.FULL_HD;
		default:
			return Quality.UHD_4K;
		}
	}

	private Hdr askHdr() {
		System.out.print("HDR(1:NONE,2:HDR10,3:DV): ");
		int n = safeInt(sc.nextLine());
		return n == 2 ? Hdr.HDR10 : (n == 3 ? Hdr.DOLBY_VISION : Hdr.NONE);
	}

	private Audio askAudio() {
		System.out.print("오디오(1:STEREO,2:5.1,3:ATMOS): ");
		int n = safeInt(sc.nextLine());
		return n == 2 ? Audio._5_1 : (n == 3 ? Audio.DOLBY_ATMOS : Audio.STEREO);
	}

	private int safeInt(String s) {
		try {
			return Integer.parseInt(s.trim());
		} catch (Exception e) {
			return 0;
		}
	}
}
