package com.djunderworld.jstay.service;

import java.util.List;

import com.djunderworld.jstay.common.dao.HouseUser;

public interface HouseUserService {

	List<HouseUser> getHouseUsersBest5() throws Exception;

}
