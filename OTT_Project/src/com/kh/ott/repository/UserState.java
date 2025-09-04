package com.kh.ott.repository;

import java.util.*;
import com.kh.ott.model.UserProfile;

public class UserState {
	private UserProfile profile;
	private final LinkedHashSet<Long> wishlist = new LinkedHashSet<>();

	public UserProfile getProfile() {
		return profile;
	}

	public void setProfile(UserProfile p) {
		this.profile = p;
	}

	public Set<Long> getWishlist() {
		return wishlist;
	}

	public void addWishlist(long id) {
		wishlist.add(id);
	}

	public void addWishlist(Collection<Long> ids) {
		wishlist.addAll(ids);
	}

	public boolean removeWishlist(long id) {
		return wishlist.remove(id);
	}

	public void clearWishlist() {
		wishlist.clear();
	}
}
