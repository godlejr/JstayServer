package com.djunderworld.jstay.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.djunderworld.jstay.common.dao.FirebaseNotification;
import com.djunderworld.jstay.common.dao.User;

@Repository
public interface FirebaseNotificationMapper {

	/**
	 * 파이어베이스 알림 생성 함수
	 * 
	 * @author dongjooKim
	 * @param firebaseNotification
	 * @return long
	 * @throws Exception
	 */
	void saveFirebaseNotification(FirebaseNotification firebaseNotification) throws Exception;

	/**
	 * 유저리스트 별 유저관련 파이어 베이스 알림 생성 함수
	 * 
	 * @author dongjooKim
	 * @param firebaseNotificationId
	 * @param users
	 * 
	 * @throws Exception
	 */
	void saveUserNotificationByfirebaseNotificationIdAndUsers(
			@Param("firebaseNotificationId") long firebaseNotificationId, @Param("users") List<User> users);

}
