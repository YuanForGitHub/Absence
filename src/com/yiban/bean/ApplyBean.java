package com.yiban.bean;

import org.springframework.stereotype.Component;

@Component
public class ApplyBean {
	private String activity;
	private String department; 
	private String job;
	private String name;
	private String startTime;
	private String endTime;
	private String other;
	private String reason;
	
	
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
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
	@Override
	public String toString() {
		return "ApplyBean [activity=" + activity + ", department=" + department + ", job=" + job + ", name=" + name
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", other=" + other + ", reason=" + reason + "]";
	}
}
