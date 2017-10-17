package com.djunderworld.jstay.service.impl;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.djunderworld.jstay.common.dao.User;
import com.djunderworld.jstay.common.dto.FirebaseResponse;
import com.djunderworld.jstay.common.dto.Notification;
import com.djunderworld.jstay.common.dto.NotificationMessage;
import com.djunderworld.jstay.common.flag.FileFlag;
import com.djunderworld.jstay.common.flag.NotificationFlag;
import com.djunderworld.jstay.common.utils.AwsS3Util;
import com.djunderworld.jstay.common.utils.FirebaseCloudMessageUtil;
import com.djunderworld.jstay.common.utils.JwtUtil;
import com.djunderworld.jstay.mapper.UserMapper;
import com.djunderworld.jstay.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AwsS3Util awsS3Util;

	@Autowired
	private FirebaseCloudMessageUtil firebaseCloudMessageUtil;

	@Value("#{aws['aws.s3.avatar.image.url']}")
	private String USER_AVATAR_URL;

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
	 * 회원가입 함수
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

	/**
	 * 유저 정보 수정 함수
	 * 
	 * @author dongjooKim
	 * 
	 * @param user
	 * @param file
	 * 
	 * @throws Exception
	 */
	@Override
	public User updateUserByIdAndMultipartFiles(User user, List<MultipartFile> multipartFiles) throws Exception {
		int multipartFileSize = multipartFiles.size();

		if (multipartFileSize > 0) {
			for (int i = 0; i < multipartFileSize; i++) {
				MultipartFile multipartFile = multipartFiles.get(i);

				String fileType = multipartFile.getContentType().trim();
				String orgname = multipartFile.getOriginalFilename();
				String ext = orgname.substring(orgname.lastIndexOf(".") + 1, orgname.length());

				if (fileType.equals(FileFlag.USER_AVATAR_CONTENT_TYPE)) {
					String prevAvatar = user.getAvatar();
					if (!prevAvatar.equals(FileFlag.USER_AVATAR_DEFAULT)) {
						awsS3Util.deleteFileByLocationAndFileName(USER_AVATAR_URL, prevAvatar);
					}

					String fileName = awsS3Util.selectFileNameByUploadingFileAndExtToTheLocation(USER_AVATAR_URL,
							multipartFile.getInputStream(), ext);
					String avatar = fileName + "." + ext;
					user.setAvatar(avatar);
				}
			}
		}
		long userId = user.getId();
		String deviceId = user.getDeviceId();

		if (deviceId != null && deviceId.length() > 0) {
			User prevUser = userMapper.getUserById(userId);
			String prevDeviceId = prevUser.getDeviceId();

			if (prevDeviceId != null && prevDeviceId.length() > 0 && !deviceId.equals(prevDeviceId)) {
				String fcmToken = prevUser.getFcmToken();

				NotificationMessage notificationMessage = new NotificationMessage();
				String content = NotificationFlag.CONTENT_OF_FORCED_CLOSE_FOR_DUPLICATIVE_LOGIN;
				Notification notification = new Notification(content);

				notificationMessage.setPriority(NotificationFlag.HIGH_PRIORITY);
				notificationMessage.setTo(fcmToken);
				notificationMessage.setNotification(notification);

				HttpHeaders httpHeaders = firebaseCloudMessageUtil.getHttpHeaders();
				HttpEntity<NotificationMessage> httpEntity = new HttpEntity<NotificationMessage>(notificationMessage,
						httpHeaders);

				CompletableFuture<FirebaseResponse> completableFuture = firebaseCloudMessageUtil
						.postNotificationMessage(httpEntity);
			}
		}
		userMapper.updateUserById(user);

		return userMapper.getUserById(userId);
	}

}
