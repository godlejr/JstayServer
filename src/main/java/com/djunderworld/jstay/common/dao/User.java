package com.djunderworld.jstay.common.dao;

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
