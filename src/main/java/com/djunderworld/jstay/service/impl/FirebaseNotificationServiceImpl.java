package com.djunderworld.jstay.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.djunderworld.jstay.common.dao.Behavior;
import com.djunderworld.jstay.common.dao.FirebaseNotification;
import com.djunderworld.jstay.common.dao.User;
import com.djunderworld.jstay.common.dto.Data;
import com.djunderworld.jstay.common.dto.DataMessage;
import com.djunderworld.jstay.common.flag.NotificationFlag;
import com.djunderworld.jstay.common.utils.FirebaseCloudMessageUtil;
import com.djunderworld.jstay.mapper.FirebaseNotificationMapper;
import com.djunderworld.jstay.mapper.UserMapper;
import com.djunderworld.jstay.service.FirebaseNotificationService;

@Service
public class FirebaseNotificationServiceImpl implements FirebaseNotificationService {

	@Autowired
	private FirebaseNotificationMapper firebaseNotificationMapper;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private FirebaseCloudMessageUtil firebaseCloudMessageUtil;

	/**
	 * FirebaseNotification DB insert 함수
	 * 
	 * @author dongjooKim
	 * @param firebaseNotification
	 * @return long
	 * @throws Exception
	 */
	@Override
	public long saveFirebaseNotification(FirebaseNotification firebaseNotification) throws Exception {
		firebaseNotificationMapper.saveFirebaseNotification(firebaseNotification);
		long firebaseNotificationId = firebaseNotification.getId();

		return firebaseNotificationId;
	}

	/**
	 * UserNotification DB insert 및 FirebaseNotification Data Message HttpEntity
	 * 전송 함수
	 * 
	 * 
	 * @author dongjooKim
	 * @param firebaseNotification
	 * @throws Exception
	 */
	@Override
	public void saveUserNotificationByFirebaseNotification(FirebaseNotification firebaseNotification) throws Exception {
		long firebaseNotificationId = firebaseNotification.getId();
		User user = firebaseNotification.getUser();
		long receiverCategoryId = firebaseNotification.getReceiverCategoryId();
		long receiverId = firebaseNotification.getReceiverId();
		String navigationId = firebaseNotification.getNavigationId();
		String userName = user.getName();
		String content = firebaseNotification.getContent();
		Behavior behavior = firebaseNotification.getBehavior();
		String behaviorName = behavior.getName();

		List<User> users = null;

		if (receiverCategoryId == NotificationFlag.TO_ME || receiverCategoryId == NotificationFlag.TO_WRITER) {
			User toUser = userMapper.getUserById(receiverId);
			users = new ArrayList<User>();
			users.add(toUser);
		}

		if (receiverCategoryId == NotificationFlag.TO_FOLLOWERS) {
			users = userMapper.getFollowersFcmTokenListByHouseId(navigationId);
		}

		int userSize = users.size();
		if (userSize > 0) {
			firebaseNotificationMapper.saveUserNotificationByfirebaseNotificationIdAndUsers(firebaseNotificationId,
					users);

			DataMessage dataMessage = new DataMessage();
			String dataMessageBody = userName + "님이 " + content + behaviorName;
			Data data = new Data(dataMessageBody);

			dataMessage.setPriority(NotificationFlag.HIGH_PRIORITY);
			dataMessage.setRegistration_ids(dataMessage.convertToRegistrationIdArrayFromUserList(users));
			dataMessage.setData(data);

			HttpHeaders httpHeaders = firebaseCloudMessageUtil.getHttpHeaders();
			HttpEntity<DataMessage> httpEntity = new HttpEntity<DataMessage>(dataMessage, httpHeaders);

			firebaseCloudMessageUtil.postDataMessage(httpEntity);
		}
	}
}
