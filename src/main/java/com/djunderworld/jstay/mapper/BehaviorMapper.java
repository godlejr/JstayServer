package com.djunderworld.jstay.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.djunderworld.jstay.common.dao.Behavior;

@Repository
public interface BehaviorMapper {

	/**
	 * 유저 행위 검색 매핑 함수
	 * 
	 * @author dongjooKim
	 * 
	 * @param id
	 * @return Behavior
	 * 
	 * @throws Exception
	 */
	Behavior getBehaviorById(@Param("id") long id) throws Exception;

}
