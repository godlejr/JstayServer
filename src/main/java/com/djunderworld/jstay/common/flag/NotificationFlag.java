package com.djunderworld.jstay.common.flag;

/**
 * firebase cloud messaging service 플래그 클래스
 * 
 * 수신자 유형, 발신자 행위, 메시지 페이지 이동 경로 정보
 * 
 * @author dongjooKim
 */
public class NotificationFlag {

	/**
	 * 데이터 메시지 수신자 유형 정보
	 * 
	 * 1:자신, 2:작성자, 4:즐겨찾는 사람 전체
	 * 
	 * @author dongjooKim
	 */
	public static final long TO_ME = 1;
	public static final long TO_WRITER = 2;
	public static final long TO_FOLLOWERS = 3;

	/**
	 * 데이터 메시지 발신자 행위 정보
	 * 
	 * 1:리뷰 작성, 2:댓글 작성, 3:리뷰 좋아요
	 * 
	 * @author dongjooKim
	 */
	public static final long WRITING_THE_REVIEW = 1;
	public static final long WRITING_THE_COMMENT = 2;
	public static final long LIKE_THE_REVIEW = 3;

	/**
	 * 데이터 메시지 페이지 이동 경로 정보
	 * 
	 * 1:리뷰 페이지, 2:숙박정보 페이지
	 * 
	 * @author dongjooKim
	 */
	public static final long NAVIGATE_TO_THE_PAGE_OF_REVIEW = 1;
	public static final long NAVIGATE_TO_THE_PAGE_OF_HOUSE = 2;


	/**
	 * 데이터 메시지 내용 목적어 정보
	 * 
	 * ex.) 리뷰, 회원님의 리뷰, 회원님의 댓글, 회원님
	 * 
	 * @author dongjooKim
	 */
	public static final String CONTENT_OBJECT_OF_WRITING_REVIEW = "리뷰";
	public static final String CONTENT_OBJECT_OF_WRITING_COMMENT_OR_LIKE = "회원님의 리뷰";
	public static final String CONTENT_OBJECT_OF_WRITING_REPLY_COMMENT = "회원님의 댓글";
	
	/**
	 * 알림 메시지 내용 
	 * 
	 * ex.) 다른 기기에서 접속되어 강제 로그아웃합니다.
	 * 
	 * @author dongjooKim
	 */
	
	public static final String CONTENT_OF_FORCED_CLOSE_FOR_DUPLICATIVE_LOGIN = "다른 기기에서 접속되어 강제 로그아웃합니다.";
	
	/**
	 * firebase cloud messaging service priority 정보
	 * 
	 * high
	 * 
	 * @author dongjooKim
	 */
	public static final String HIGH_PRIORITY = "high";

}
