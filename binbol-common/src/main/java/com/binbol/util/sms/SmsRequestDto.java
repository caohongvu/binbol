package com.binbol.util.sms;

public class SmsRequestDto {
	private String content;

	public SmsRequestDto(String content, String phone) {
		this.content = content;
		this.phone = phone;
	}

	private String phone;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
