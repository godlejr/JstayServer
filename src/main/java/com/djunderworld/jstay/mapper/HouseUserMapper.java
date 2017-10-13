package com.djunderworld.jstay.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.djunderworld.jstay.common.dao.HouseUser;

@Repository
public interface HouseUserMapper {

	List<HouseUser> getHouseUsersOrderByHouseCountDescLimitFive() throws Exception;
	
}
