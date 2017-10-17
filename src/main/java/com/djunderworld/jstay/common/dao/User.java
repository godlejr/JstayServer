package com.djunderworld.jstay.common.dao;

/**
 * 
 * 유저정보 엔티티 클래스
 * 
 * 이메일, 비밀번호, 이름, 전화번호, 아바타사진, 레벨(1.일반유저, 9.관리자), Firebase 토큰, 디바이스 기기 ID 정보,
 * 로그인 접근방법 정보, 엑세스 토큰
 * 
 * @author dongjooKim
 * 
 */
public class User extends Base {
	private String email;
	private String password;
	private String name;
	private String phone;
	private String avatar;
	private int level;
	private String fcmToken;
	private String deviceId;
	private int loginCategoryId;

	private String accessToken;

	public User() {
		super();
	}

	public User(long id, String createdAt, String updatedAt) {
		super(id, createdAt, updatedAt);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getFcmToken() {
		return fcmToken;
	}

	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public int getLoginCategoryId() {
		return loginCategoryId;
	}

	public void setLoginCategoryId(int loginCategoryId) {
		this.loginCategoryId = loginCategoryId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
