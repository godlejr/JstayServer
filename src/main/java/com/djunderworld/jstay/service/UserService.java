package com.djunderworld.jstay.service;

import com.djunderworld.jstay.common.dao.User;

public interface UserService {

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
	Boolean getCheckByEmail(String email) throws Exception;

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
	User getUserByEmailAndPassword(String email, String password) throws Exception;

	/**
	 * 회원가입 함수 (일반인, 상인 구분)
	 * 
	 * @author dongjooKim
	 * 
	 * @param user
	 * 
	 * @throws Exception
	 */
	void saveUser(User user) throws Exception;

}
