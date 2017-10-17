package com.djunderworld.jstay.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.djunderworld.jstay.common.dao.User;

@Repository
public interface UserMapper {

	/**
	 * 이메일 중복체크 검색 매핑 함수
	 * 
	 * @author dongjooKim
	 * 
	 * 
	 * @param email
	 * @return Boolean
	 * 
	 * @throws Exception
	 */
	Boolean getCheckByEmail(@Param("email") String email) throws Exception;

	/**
	 * 로그인 기능, 이메일과 비밀번호로 유저 검색 매핑 함수
	 * 
	 * @author dongjooKim
	 * 
	 * 
	 * @param email
	 * @param password
	 * 
	 * @return User
	 * 
	 * @throws Exception
	 */
	User getUserByEmailAndPassword(@Param("email") String email, @Param("password") String password) throws Exception;

	/**
	 * 유저 생성 함수
	 * 
	 * @author dongjooKim
	 * 
	 * @param user
	 * 
	 * @throws Exception
	 */
	void saveUser(User user) throws Exception;

	/**
	 * 유저 수정 함수
	 * 
	 * @author dongjooKim
	 * 
	 * @param user
	 * 
	 * @throws Exception
	 */
	void updateUserById(User user) throws Exception;

	/**
	 * 유저 아이디로 유저 검색 함수
	 * 
	 * @author dongjooKim
	 * 
	 * 
	 * @param id
	 * 
	 * @return User
	 * 
	 * @throws Exception
	 */
	User getUserById(@Param("id") long id) throws Exception;
}
