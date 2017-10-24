package com.djunderworld.jstay.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.djunderworld.jstay.common.dao.ReviewTag;

@Repository
public interface ReviewTagMapper {

	/**
	 * 리뷰 태그 리스트 생성 함수
	 * 
	 * 
	 * @author dongjooKim
	 * 
	 * @param storyTags
	 * 
	 * @throws Exception
	 */
	void saveReviewTags(@Param("reviewTags") List<ReviewTag> reviewTags) throws Exception;

}
