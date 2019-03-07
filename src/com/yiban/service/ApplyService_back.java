package com.yiban.service;

import com.yiban.bean.ApplyBean;
import com.yiban.dao.ApplyDao;

/**
 * 申请相关的业务功能
 */
public class ApplyService_back {
	/**
	 * 插入申请信息
	 */
	public boolean insert(ApplyBean apply) {
		ApplyDao applyDao = new ApplyDao();
		return applyDao.doCreate(apply);
	}
}
