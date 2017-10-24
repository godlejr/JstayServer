package com.djunderworld.jstay.mapper;

import org.springframework.stereotype.Repository;

import com.djunderworld.jstay.common.dao.Review;

@Repository
public interface ReviewMapper {

	/**
	 * 리뷰 생성 함수
	 * 
	 * 
	 * @author dongjooKim
	 * 
	 * @param story
	 * @return long
	 * @throws Exception
	 */
	void saveReview(Review review) throws Exception;

}
