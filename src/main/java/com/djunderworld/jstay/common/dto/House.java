package com.djunderworld.jstay.common.dto;

public class House {
	private String dataSid; // 고유 데이터 아이디
	private String dataTitle; // 숙박집 이름
	private String hanokTypeStr; // 숙박집 구조
	private String dataContent; // 내용
	private String homepage; // 홈페이지
	private String introContent; // 상세 설명
	private String memo; // 요약
	private String zipcode; // 우편 번호
	private String addr; // 기본 주소
	private String addrdetail; // 상세 주소
	private String tel; // 전화번호
	private String posx; // 경도
	private String posy; // 위도
	private String word; // 키워드
	private String regDt; // 등록일

	public House() {
		super();
	}

	public String getDataSid() {
		return dataSid;
	}

	public void setDataSid(String dataSid) {
		this.dataSid = dataSid;
	}

	public String getDataTitle() {
		return dataTitle;
	}

	public void setDataTitle(String dataTitle) {
		this.dataTitle = dataTitle;
	}

	public String getHanokTypeStr() {
		return hanokTypeStr;
	}

	public void setHanokTypeStr(String hanokTypeStr) {
		this.hanokTypeStr = hanokTypeStr;
	}

	public String getDataContent() {
		return dataContent;
	}

	public void setDataContent(String dataContent) {
		this.dataContent = dataContent;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getIntroContent() {
		return introContent;
	}

	public void setIntroContent(String introContent) {
		this.introContent = introContent;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getAddrdetail() {
		return addrdetail;
	}

	public void setAddrdetail(String addrdetail) {
		this.addrdetail = addrdetail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPosx() {
		return posx;
	}

	public void setPosx(String posx) {
		this.posx = posx;
	}

	public String getPosy() {
		return posy;
	}

	public void setPosy(String posy) {
		this.posy = posy;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

}
