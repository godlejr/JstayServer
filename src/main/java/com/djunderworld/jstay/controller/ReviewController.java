package com.djunderworld.jstay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.djunderworld.jstay.common.dao.Behavior;
import com.djunderworld.jstay.common.dao.FirebaseNotification;
import com.djunderworld.jstay.common.dao.Review;
import com.djunderworld.jstay.common.dao.User;
import com.djunderworld.jstay.common.flag.NotificationFlag;
import com.djunderworld.jstay.service.BehaviorService;
import com.djunderworld.jstay.service.FirebaseNotificationService;
import com.djunderworld.jstay.service.ReviewService;

@RestController 
@RequestMapping("/reviews")
public class ReviewController {
	
	@Autowired 
	private ReviewService reviewService;
	
	@Autowired
	private BehaviorService behaviorService;
	
	@Autowired
	private FirebaseNotificationService firebaseNotificationService;
	
	
	/**
	 * 리뷰 생성 API
	 * 
	 * 리뷰 내용, 해쉬태그, 파일정보(데이터베이스), 사진파일, 동영상파일, VR360파일(AWS S3) 등록
	 * 
	 * @author dongjooKim
	 * 
	 * @param review
	 * @param files
	 * @return long
	 * @throws Exception
	 */
	@Secured("ROLE_USER")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public long insertStory(@RequestPart Review review, @RequestPart(required = false) List<MultipartFile> files)
			throws Exception {
		long reviewId = reviewService.saveReview(review, files);
			
		User user = review.getUser();
		long userId = user.getId();
		String houseId = review.getHouseId();
 
		FirebaseNotification firebaseNotification = new FirebaseNotification();
		firebaseNotification.setUser(user);
		firebaseNotification.setReceiverCategoryId(NotificationFlag.TO_FOLLOWERS);
		firebaseNotification.setReceiverId(userId);
		firebaseNotification.setContent(NotificationFlag.CONTENT_OBJECT_OF_WRITING_REVIEW);
		firebaseNotification.setNavigationCategoryId(NotificationFlag.NAVIGATE_TO_THE_PAGE_OF_HOUSE);
		firebaseNotification.setNavigationId(houseId);

		Behavior behavior = behaviorService.getBehaviorById(NotificationFlag.WRITING_THE_REVIEW);
		firebaseNotification.setBehavior(behavior);

		long firebaseNotificationId = firebaseNotificationService.saveFirebaseNotification(firebaseNotification);
		firebaseNotification.setId(firebaseNotificationId);
		firebaseNotificationService.saveUserNotificationByFirebaseNotification(firebaseNotification);

		return reviewId;
	}


}
