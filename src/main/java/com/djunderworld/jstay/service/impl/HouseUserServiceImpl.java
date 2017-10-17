package com.djunderworld.jstay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.djunderworld.jstay.common.dao.HouseUser;
import com.djunderworld.jstay.mapper.HouseUserMapper;
import com.djunderworld.jstay.service.HouseUserService;


@Service 
public class HouseUserServiceImpl implements HouseUserService {

	@Autowired
	private HouseUserMapper houseUserMapper;
	
	/**
	 * 숙박 즐겨찾기 best5 검색 함수
	 * 
	 * @author dongjooKim
	 * 
	 * 
	 * @throws Exception
	 * 
	 * @return List<HouseUser>
	 */
	@Override
	public List<HouseUser> getHouseUsersBest5() throws Exception {
		return houseUserMapper.getHouseUsersOrderByHouseCountDescLimitFive();
	}

}
