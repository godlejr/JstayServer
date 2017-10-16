package com.djunderworld.jstay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.djunderworld.jstay.mapper.UserMapper;
import com.djunderworld.jstay.service.UserService;
import com.djunderworld.jstay.common.utils.JwtUtil;
import com.djunderworld.jstay.common.dao.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 이메일 중복체크 함수
	 * 
	 * @author dongjooKim
	 * 
	 * 
	 * @param email
	 * @return Boolean
	 * 
	 * @throws Exception
	 */
	@Override
	public Boolean getCheckByEmail(String email) throws Exception {
		return userMapper.getCheckByEmail(email);
	}
	
	/**
	 * 로그인 함수 (성공시, 엑세스토큰이 담긴 User 반환, 실패시, null)
	 * 
	 * @author dongjooKim
	 * 
	 * @param email
	 * @param password
	 * @return User
	 * 
	 * @throws Exception
	 */
	@Override
	public User getUserByEmailAndPassword(String email, String password) throws Exception {

		User user = userMapper.getUserByEmailAndPassword(email, password);

		if (user != null) {
			int level = user.getLevel();
			String accessToken = jwtUtil.generateToken(level);
			user.setAccessToken(accessToken);
		}

		return user;
	}

	/**
	 * 회원가입 함수 (일반인, 상인 구분)
	 * 
	 * @author dongjooKim
	 * 
	 * @param user
	 * 
	 * @throws Exception
	 */
	@Override
	public void saveUser(User user) throws Exception {
		userMapper.saveUser(user);
	}

}
