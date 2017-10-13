package com.djunderworld.jstay.common.dto;

public class HouseFile {
	private String fileSid;
	private String dataSid;
	private String fileUrl;// 이미지 경로url
	private String thumbUrl;// 썸네일 이미지 경로url
	private String fileMask; // 물리적 파일명
	private String fileName; // 논리적 파일 명

	public HouseFile() {
		super();
	}

	public String getFileSid() {
		return fileSid;
	}

	public void setFileSid(String fileSid) {
		this.fileSid = fileSid;
	}

	public String getDataSid() {
		return dataSid;
	}

	public void setDataSid(String dataSid) {
		this.dataSid = dataSid;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getThumbUrl() {
		return thumbUrl;
	}

	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}

	public String getFileMask() {
		return fileMask;
	}

	public void setFileMask(String fileMask) {
		this.fileMask = fileMask;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
