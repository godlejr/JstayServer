package com.djunderworld.jstay.common.dao;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 
 * 리뷰 정보 엔티티 클래스
 * 
 * 유저 정보, 게시글 글 내용, 파일 정보 리스트, 좋아요 수, 댓글 수, 좋아요 체크여부, 리뷰 해쉬태그 정보
 * 
 * @author dongjooKim
 */

@JsonIgnoreProperties(value = { "handler" })
public class Review extends Base {
	private User user;
	private String houseId;
	private String content;
	private int rate;

	private int likeCount;
	private int commentCount;
	private Boolean isLikeChecked;

	@JsonInclude(JsonInclude.Include.ALWAYS)
	private List<File> files = new ArrayList<File>();

	private List<ReviewTag> reviewTags = new ArrayList<ReviewTag>();

	public Review() {
		super();
	}

	public Review(long id, String createdAt, String updatedAt) {
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public Boolean getIsLikeChecked() {
		return isLikeChecked;
	}

	public void setIsLikeChecked(Boolean isLikeChecked) {
		this.isLikeChecked = isLikeChecked;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public List<ReviewTag> getReviewTags() {
		return reviewTags;
	}

	public void setReviewTags(List<ReviewTag> reviewTags) {
		this.reviewTags = reviewTags;
	}

}
