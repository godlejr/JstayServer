package com.djunderworld.jstay.service;

import java.util.List;

import com.djunderworld.jstay.common.dao.HouseUser;

public interface HouseUserService {

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
	List<HouseUser> getHouseUsersBest5() throws Exception;

}
