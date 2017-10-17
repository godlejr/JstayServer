package com.djunderworld.jstay.common.dto;

public class HouseDto {
	private int ratingsAverage;
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

	public Boolean getIsFollowed() {
		return isFollowed;
	}

	public void setIsFollowed(Boolean isFollowed) {
		this.isFollowed = isFollowed;
	}

}
