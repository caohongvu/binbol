package com.binbol.dto;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
public class UserAccountDto {

	private Long id;
	
	private String username;
	
	private String password;
	
	private Long tenantId;
	
	private String token;
	
	private Long creatdBy;
	
	private Long blockedBy;
	
	private Long updatedBy;
	
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "Asia/Ho_Chi_Minh")
	private Date createdDate;
	
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "Asia/Ho_Chi_Minh")
	private Date blockedDate;
	
	@JsonFormat(pattern="yyyy-MM-dd", timezone = "Asia/Ho_Chi_Minh")
	private Date updatedDate;
	
	private String description;
	
	private Boolean isActivated;
	
	private Boolean isBlocked;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getCreatdBy() {
		return creatdBy;
	}

	public void setCreatdBy(Long creatdBy) {
		this.creatdBy = creatdBy;
	}

	public Long getBlockedBy() {
		return blockedBy;
	}

	public void setBlockedBy(Long blockedBy) {
		this.blockedBy = blockedBy;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getBlockedDate() {
		return blockedDate;
	}

	public void setBlockedDate(Date blockedDate) {
		this.blockedDate = blockedDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(Boolean isActivated) {
		this.isActivated = isActivated;
	}

	public Boolean getIsBlocked() {
		return isBlocked;
	}

	public void setIsBlocked(Boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
}
