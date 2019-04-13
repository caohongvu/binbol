package com.binbol.util;

import java.util.Date;
import java.util.List;

public class JwtTokenDataObject {

	private Long id;

	private String username;
	
	private Long tenantId;

	private boolean isActivated;

	private boolean isBlocked;

	private Date createdDate;

	private List menus;

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
	
	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public boolean isActivated() {
		return isActivated;
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List getMenus() {
		return menus;
	}

	public void setMenus(List menus) {
		this.menus = menus;
	}

}
