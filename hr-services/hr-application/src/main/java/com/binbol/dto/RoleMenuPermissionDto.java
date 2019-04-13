package com.binbol.dto;

public class RoleMenuPermissionDto {

    private String menuLabel;
    
    private String description;
    
    private String url;
    
    private int position;
    
    private String iconclass;

    private String permission;

	public String getMenuLabel() {
		return menuLabel;
	}

	public void setMenuLabel(String menuLabel) {
		this.menuLabel = menuLabel;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getIconclass() {
		return iconclass;
	}

	public void setIconclass(String iconclass) {
		this.iconclass = iconclass;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
	
}
