package com.djunderworld.jstay.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.djunderworld.jstay.common.dto.HouseDto;

@Repository
public interface HouseMapper {

	/**
	 * 숙박 DTO(즐겨찾기 유무 및 평점) 검색 
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
	HouseDto getHouseDtoByHouseIdAndUserId(@Param("houseId") String houseId, @Param("userId") long userId) throws Exception;

}
