package com.yiban.bean;

/**
 * 这里的review不对应review数据表
 * 只是为了方便封装数据
 */
public class ReviewBean {
	private Integer applyId;
	private Integer userId;
	private String description;
	private Integer isPass;
	
	public ReviewBean() {
	}

	public Integer getApplyId() {
		return applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getIsPass() {
		return isPass;
	}

	public void setIsPass(Integer isPass) {
		this.isPass = isPass;
	}

	@Override
	public String toString() {
		return "ReviewBean [applyId=" + applyId + ", userId=" + userId + ", description=" + description + ", isPass="
				+ isPass + "]";
	}
}
