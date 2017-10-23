package com.djunderworld.jstay.common.dto;

public class HouseDto {
	private int ratingsAverage;
	private int reviewCount;
	private int houseUserCount;
	private Boolean isFollowed;

	public HouseDto() {
		super();
	}

	public int getRatingsAverage() {
		return ratingsAverage;
	}

	public void setRatingsAverage(int ratingsAverage) {
		this.ratingsAverage = ratingsAverage;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public int getHouseUserCount() {
		return houseUserCount;
	}

	public void setHouseUserCount(int houseUserCount) {
		this.houseUserCount = houseUserCount;
	}

	public Boolean getIsFollowed() {
		return isFollowed;
	}

	public void setIsFollowed(Boolean isFollowed) {
		this.isFollowed = isFollowed;
	}

}
