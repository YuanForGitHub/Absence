package com.yiban.bean;

import com.yiban.bean.DepartmentBean;

public class UserBean {
	private String userId;
	private String userName;
	private String phone;
	private String password;
	private DepartmentBean department;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public DepartmentBean getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentBean department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", userName=" + userName + ", phone=" + phone + ", password=" + password
				+ ", department=" + department + "]";
	}
	
}
