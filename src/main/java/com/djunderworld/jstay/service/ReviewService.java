package com.djunderworld.jstay.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.djunderworld.jstay.common.dao.Review;

public interface ReviewService {

	/**
	 * 리뷰 생성 함수
	 * 
	 * 리뷰 내용, 해쉬태그, 파일정보(데이터베이스), 사진파일, 동영상파일, VR360파일(AWS S3) 등록
	 * 
	 * @author dongjooKim
	 * 
	 * @param review
	 * @param files
	 * @return long
	 * @throws Exception
	 */
	long saveReview(Review review, List<MultipartFile> files) throws Exception;

}
