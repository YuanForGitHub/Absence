package com.yiban.bean;

import org.springframework.stereotype.Component;

import com.yiban.bean.DepartmentBean;

@Component
public class ApplyBean {
	private Integer applyId;
	private String activity;
	private String job;
	private String name;
	private String phone;
	private String startTime;
	private String endTime;
	private String other;
	private String reason;
	private String created_at;
	private Integer isPass;
	private String description;
	private DepartmentBean department;
	
	public Integer getApplyId() {
		return applyId;
	}
	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String replace) {
		this.other = replace;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public Integer getIsPass() {
		return isPass;
	}
	public void setIsPass(Integer isPass) {
		this.isPass = isPass;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public DepartmentBean getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentBean department) {
		this.department = department;
	}
	
	
	@Override
	public String toString() {
		return "ApplyBean [applyId=" + applyId + ", activity=" + activity + ", job=" + job + ", name=" + name
				+ ", phone=" + phone + ", startTime=" + startTime + ", endTime=" + endTime + ", other=" + other
				+ ", reason=" + reason + ", created_at=" + created_at + ", isPass=" + isPass + ", description="
				+ description + ", department=" + department + "]";
	}
}
