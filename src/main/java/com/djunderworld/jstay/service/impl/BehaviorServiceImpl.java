package com.djunderworld.jstay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.djunderworld.jstay.common.dao.Behavior;
import com.djunderworld.jstay.mapper.BehaviorMapper;
import com.djunderworld.jstay.service.BehaviorService;

@Service 
public class BehaviorServiceImpl implements BehaviorService{
	@Autowired
	private BehaviorMapper behaviorMapper;

	/**
	 * 유저 행위 검색함수
	 * 
	 * @author dongjooKim
	 * 
	 * @param id
	 * @return Behavior
	 * 
	 * @throws Exception
	 */
	@Override
	public Behavior getBehaviorById(long id) throws Exception {
		return behaviorMapper.getBehaviorById(id);
	}
}
