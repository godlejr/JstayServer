package com.djunderworld.jstay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.djunderworld.jstay.common.dto.HouseDto;
import com.djunderworld.jstay.service.HouseService;

@RestController
@RequestMapping("/houses")
public class HouseController {

	@Autowired
	private HouseService houseService;

	/**
	 * 숙박 DTO(즐겨찾기 유무 및 평점) 검색 API
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
	@RequestMapping(value = "/description.json", method = RequestMethod.GET)
	public HouseDto description(@RequestParam("houseId") String houseId,
			@RequestParam(name = "userId", required = false, defaultValue = "0") long userId) throws Exception {
		return houseService.getHouseDtoByHouseIdAndUserId(houseId, userId);
	}
	

	

}
