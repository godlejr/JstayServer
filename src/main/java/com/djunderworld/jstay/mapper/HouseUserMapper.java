package com.djunderworld.jstay.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.djunderworld.jstay.common.dao.HouseUser;

@Repository
public interface HouseUserMapper {

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
	List<HouseUser> getHouseUsersOrderByHouseCountDescLimitFive() throws Exception;

	/**
	 * 숙박 즐겨찾기 등록 함수
	 * 
	 * @author dongjooKim
	 *
	 * @param houseUser
	 * 
	 * @throws Exception
	 * 
	 */
	void saveHouseUser(HouseUser houseUser) throws Exception;

	/**
	 * 숙박 즐겨찾기 취소 함수
	 * 
	 * @author dongjooKim
	 *
	 * @param houseUser
	 * 
	 * @throws Exception
	 * 
	 */
	void deleteHouseUser(HouseUser houseUser) throws Exception;

}
