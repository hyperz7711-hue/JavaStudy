package com.kh.ott.repository;

import java.util.*;
import com.kh.ott.model.*;

public class Repositories {
	private final DataStore ds;

	public Repositories(DataStore ds) {
		this.ds = ds;
	}

	public Content createContent(Content c) {
		ds.contents().put(c.getId(), c);
		return c;
	}

	public Optional<Content> readContent(long id) {
		return Optional.ofNullable(ds.contents().get(id));
	}

	public List<Content> listContents() {
		return new ArrayList<>(ds.contents().values());
	}

	public boolean updateContent(long id, java.util.function.Function<Content, Content> fn) {
		Content c = ds.contents().get(id);
		if (c == null)
			return false;
		fn.apply(c);
		return true;
	}

	public boolean deleteContent(long id) {
		ds.availability().removeIf(a -> a.getContentId() == id);
		return ds.contents().remove(id) != null;
	}

	public Platform createPlatform(Platform p) {
		ds.platforms().put(p.getId(), p);
		return p;
	}

	public Optional<Platform> readPlatform(long id) {
		return Optional.ofNullable(ds.platforms().get(id));
	}

	public List<Platform> listPlatforms() {
		return new ArrayList<>(ds.platforms().values());
	}

	public boolean deletePlatform(long id) {
		Platform p = ds.platforms().remove(id);
		if (p == null)
			return false;
		ds.plans().entrySet().removeIf(e -> e.getValue().getPlatformId() == id);
		ds.availability().removeIf(a -> a.getPlatformId() == id);
		return true;
	}

	public Plan createPlan(Plan plan) {
		ds.plans().put(plan.getId(), plan);
		Platform p = ds.platforms().get(plan.getPlatformId());
		if (p != null)
			p.getPlans().add(plan);
		return plan;
	}

	public Optional<Plan> readPlan(long id) {
		return Optional.ofNullable(ds.plans().get(id));
	}

	public boolean deletePlan(long id) {
		Plan plan = ds.plans().remove(id);
		if (plan == null)
			return false;
		Platform p = ds.platforms().get(plan.getPlatformId());
		if (p != null) {
			p.getPlans().removeIf(pp -> pp.getId() == id);
		}
		for (Availability a : ds.availability()) {
			if (a.getPlanIds() != null)
				a.getPlanIds().remove(id);
		}
		return true;
	}

	public DataStore ds() {
		return ds;
	}
}
