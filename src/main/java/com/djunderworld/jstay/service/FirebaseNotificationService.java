package com.djunderworld.jstay.service;

import com.djunderworld.jstay.common.dao.FirebaseNotification;

public interface FirebaseNotificationService {

	/**
	 * FirebaseNotification DB insert 함수
	 * 
	 * @author dongjooKim
	 * @param firebaseNotification
	 * @return long
	 * @throws Exception
	 */
	long saveFirebaseNotification(FirebaseNotification firebaseNotification) throws Exception;

	/**
	 * UserNotification DB insert 및 FirebaseNotification Data Message HttpEntity
	 * 전송 함수
	 * 
	 * 
	 * @author dongjooKim
	 * @param firebaseNotification
	 * @throws Exception
	 */
	void saveUserNotificationByFirebaseNotification(FirebaseNotification firebaseNotification) throws Exception;

}
