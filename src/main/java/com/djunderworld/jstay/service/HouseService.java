package com.djunderworld.jstay.service;

import com.djunderworld.jstay.common.dto.HouseDto;

public interface HouseService {

	
	/**
	 * 숙박 DTO(즐겨찾기 유무 및 평점) 검색 함수
	 * 
	 * @author dongjooKim
	 * 
	 * 
	 * @param houseId
	 * @param userId
	 * @throws Exception
	 * 
	 * @return HouseDto
	 */
	HouseDto getHouseDtoByHouseIdAndUserId(String houseId, long userId) throws Exception;

}
