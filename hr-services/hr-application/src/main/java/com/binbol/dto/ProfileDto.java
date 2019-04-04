package com.binbol.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ProfileDto {

	private Long id;
	private String fullname;
	private String gender;
	private String email;
	private String hotline;
	private String ecoeUserId;
	private String address;
	private String avatar;
	private Date birthday;
	private boolean isCurrently;
	private boolean isActiveHotline;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm", timezone = "Asia/Ho_Chi_Minh")
	private Date createdDate;
	private String createdBy;
	private Boolean isReveChat;
	private String subDomain;

	public Boolean getIsReveChat() {
		return isReveChat;
	}

	public void setIsReveChat(Boolean reveChat) {
		isReveChat = reveChat;
	}

	public String getSubDomain() {
		return subDomain;
	}

	public void setSubDomain(String subDomain) {
		this.subDomain = subDomain;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActiveHotline() {
		return isActiveHotline;
	}
	public void setActiveHotline(boolean activeHotline) {
		isActiveHotline = activeHotline;
	}
	public String getHotline() {
		return hotline;
	}
	public void setHotline(String hotline) {
		this.hotline = hotline;
	}
	public String getEcoeUserId() {
		return ecoeUserId;
	}
	public void setEcoeUserId(String ecoeUserId) {
		this.ecoeUserId = ecoeUserId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public boolean getIsCurrently() {
		return isCurrently;
	}
	public void setIsCurrently(boolean isCurrently) {
		this.isCurrently = isCurrently;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
}
