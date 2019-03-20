package com.yiban.bean;

import java.util.List;

public class RoleBean {
	private int roleId;
	private String roleName;
	private List<PermissionBean> permissions;
	
	public RoleBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<PermissionBean> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<PermissionBean> permissions) {
		this.permissions = permissions;
	}
	
}
