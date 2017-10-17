package com.djunderworld.jstay.common.dao;

/**
 * 
 * 리뷰 해쉬태그 연결 정보 엔티티 클래스
 * 
 * 유저 정보, 해쉬태그 정보
 * 
 * @author dongjooKim
 */
public class ReviewTag extends Base {
	private Review review;
	private String tagName;

	public ReviewTag() {
		super();
	}

	public ReviewTag(long id, String createdAt, String updatedAt) {
		super(id, createdAt, updatedAt);
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

}
