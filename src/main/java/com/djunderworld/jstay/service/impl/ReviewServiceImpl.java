package com.djunderworld.jstay.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.djunderworld.jstay.common.dao.File;
import com.djunderworld.jstay.common.dao.Review;
import com.djunderworld.jstay.common.dao.ReviewTag;
import com.djunderworld.jstay.common.dao.User;
import com.djunderworld.jstay.common.flag.FileFlag;
import com.djunderworld.jstay.common.utils.AwsS3Util;
import com.djunderworld.jstay.mapper.FileMapper;
import com.djunderworld.jstay.mapper.FirebaseNotificationMapper;
import com.djunderworld.jstay.mapper.ReviewCommentMapper;
import com.djunderworld.jstay.mapper.ReviewMapper;
import com.djunderworld.jstay.mapper.ReviewTagMapper;
import com.djunderworld.jstay.service.ReviewService;
@Service 
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	private ReviewMapper reviewMapper;

	@Autowired
	private FileMapper fileMapper;

	@Autowired
	private ReviewCommentMapper reviewCommentMapper;

	@Autowired
	private FirebaseNotificationMapper firebaseNotificationMapper;

	@Autowired
	private ReviewTagMapper reviewTagMapper;

	@Autowired
	private AwsS3Util awsS3Util;

	@Value("#{aws['aws.s3.review.image.url']}")
	private String REVIEW_IMAGE_URL;

	@Value("#{aws['aws.s3.review.video.url']}")
	private String REVIEW_VIDEO_URL;

	@Value("#{aws['aws.s3.review.vr360.url']}")
	private String REVIEW_VR360_URL;

	@Value("#{aws['aws.s3.comment.image.url']}")
	private String COMMENT_IMAGE_URL;

	@Value("#{aws['aws.s3.comment.video.url']}")
	private String COMMENT_VIDEO_URL;

	@Value("#{aws['aws.s3.comment.vr360.url']}")
	private String COMMENT_VR360_URL;
	
	/**
	 * 리뷰 생성 함수
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
	@Override
	public long saveReview(Review review, List<MultipartFile> multipartFiles) throws Exception {
		reviewMapper.saveReview(review);
		long reviewId = review.getId();

		int multipartFileSize = multipartFiles.size();

		if (multipartFileSize > 0) {
			List<File> files = new ArrayList<File>();

			for (int i = 0; i < multipartFileSize; i++) {
				File file = new File();
				file.setReview(review);

				User reviewUser = review.getUser();
				file.setUser(reviewUser);
				file.setPostCategoryId(FileFlag.REVIEW_POST);

				MultipartFile multipartFile = multipartFiles.get(i);
				String fileType = multipartFile.getContentType().trim();

				String orgname = multipartFile.getOriginalFilename();

				long fileSize = multipartFile.getSize();
				file.setSize(fileSize);
				String fileName = null;

				if (fileType.equals(FileFlag.PHOTO_CONTENT_TYPE)) {
					file.setType(FileFlag.PHOTO_TYPE);

					String ext = orgname.substring(orgname.lastIndexOf(".") + 1, orgname.length());
					file.setExt(ext);

					fileName = awsS3Util.selectFileNameByUploadingFileAndExtToTheLocation(REVIEW_IMAGE_URL,
							multipartFile.getInputStream(), ext);

				}

				if (fileType.equals(FileFlag.VIDEO_CONTENT_TYPE)) {
					String ext = FileFlag.VIDEO_EXT;
					file.setExt(ext);
					file.setType(FileFlag.VIDEO_TYPE);
					fileName = awsS3Util.selectFileNameByUploadingFileAndFileNameAndExtToTheLocation(REVIEW_VIDEO_URL,
							multipartFile.getInputStream(), orgname, ext);

				}

				if (fileType.equals(FileFlag.VR360_CONTENT_TYPE)) {
					String ext = orgname.substring(orgname.lastIndexOf(".") + 1, orgname.length());
					file.setExt(ext);
					file.setType(FileFlag.VR360_TYPE);

					fileName = awsS3Util.selectFileNameByUploadingFileAndExtToTheLocation(REVIEW_VR360_URL,
							multipartFile.getInputStream(), ext);

				}

				if (fileType.equals(FileFlag.VIDEO_THUMBNAIL_CONTENT_TYPE)) {
					String ext = FileFlag.VIDEO_THUMBNAIL_EXT;
					file.setExt(ext);
					file.setType(FileFlag.VIDEO_THUMBNAIL_TYPE);
					fileName = awsS3Util.selectFileNameByUploadingFileAndFileNameAndExtToTheLocation(REVIEW_VIDEO_URL,
							multipartFile.getInputStream(), orgname, ext);

				}

				file.setName(fileName);
				files.add(file);
			}

			fileMapper.saveFiles(files);
		}

		List<ReviewTag> reviewTags = review.getReviewTags();
		int reviewTagSize = reviewTags.size();

		if (reviewTagSize > 0) {

			for (int i = 0; i < reviewTagSize; i++) {
				reviewTags.get(i).setReview(review);
			}
			reviewTagMapper.saveReviewTags(reviewTags);
		}

		return reviewId;
	}
	
	
	
}
