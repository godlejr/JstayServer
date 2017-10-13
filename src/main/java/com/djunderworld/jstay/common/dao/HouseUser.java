package com.djunderworld.jstay.common.dao;

public class HouseUser extends Base {
	private User user;
	private String houseId;

	public HouseUser() {
		super();
	}

	public HouseUser(long id, String createdAt, String updatedAt) {
		super(id, createdAt, updatedAt);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

}
