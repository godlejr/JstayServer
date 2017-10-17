package com.djunderworld.jstay.common.dao;

/**
 * 
 * 한옥 숙박업소 즐겨찾기 정보 엔티티 클래스
 * 
 * 유저 정보, 숙박업소 아디이 정보
 * 
 * @author dongjooKim
 */
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
