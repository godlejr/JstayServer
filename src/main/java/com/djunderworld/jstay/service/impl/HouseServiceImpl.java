package com.djunderworld.jstay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.djunderworld.jstay.common.dto.HouseDto;
import com.djunderworld.jstay.mapper.HouseMapper;
import com.djunderworld.jstay.service.HouseService;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseMapper houseMapper;

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
	@Override
	public HouseDto getHouseDtoByHouseIdAndUserId(String houseId, long userId) throws Exception {
		return houseMapper.getHouseDtoByHouseIdAndUserId(houseId, userId);
	}

}
