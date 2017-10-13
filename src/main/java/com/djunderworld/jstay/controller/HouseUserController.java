package com.djunderworld.jstay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.djunderworld.jstay.common.dao.HouseUser;
import com.djunderworld.jstay.service.HouseUserService;

@RestController
@RequestMapping("/houseusers")
public class HouseUserController {
	
	@Autowired
	private HouseUserService houseUserService;
	
	/**
	 * 숙박 즐겨찾기 best5 검색 API
	 * 
	 * @author dongjooKim
	 * 
	 * 
	 * @throws Exception
	 * 
	 * @return List<HouseUser>
	 */
	@RequestMapping(value="/best5.json",method= RequestMethod.GET)
	public List<HouseUser> best5() throws Exception {
		return houseUserService.getHouseUsersBest5();
	}
	
}
