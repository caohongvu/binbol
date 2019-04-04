package com.binbol.util.sms;

import java.util.UUID;

public class SmsResponseDto {
	private UUID id;
	private String phone;
	private String content;
	private String apiKey;
	private String secretKey;
	private String smsType;
	private String brandName;
	private String codeResult;
	private String smsid;
	private String detailResponse;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getSmsType() {
		return smsType;
	}

	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getCodeResult() {
		return codeResult;
	}

	public void setCodeResult(String codeResult) {
		this.codeResult = codeResult;
	}

	public String getSmsid() {
		return smsid;
	}

	public void setSmsid(String smsid) {
		this.smsid = smsid;
	}

	public String getDetailResponse() {
		return detailResponse;
	}

	public void setDetailResponse(String detailResponse) {
		this.detailResponse = detailResponse;
	}

	public Boolean getCurrently() {
		return isCurrently;
	}

	public void setCurrently(Boolean currently) {
		isCurrently = currently;
	}

	private Boolean isCurrently;

}
