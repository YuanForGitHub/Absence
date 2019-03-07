package com.yiban.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiban.bean.ApplyBean;
import com.yiban.dao.ApplyDao;

@Service
public class ApplyService {

//	@Autowired
//	private ApplyDao applyDao;
	
	public boolean insert(ApplyBean apply) {
		ApplyDao applyDao = new ApplyDao();
		return applyDao.doCreate(apply) > 0 ? true : false;
	}
	
	public ApplyBean select(String applyId) {
		ApplyDao applyDao = new ApplyDao();
		return applyDao.doSelect(applyId);
	}
	
	public ApplyBean delete(String applyId) {
		// 被删除的apply
		ApplyDao applyDao = new ApplyDao();
		ApplyBean apply = applyDao.doSelect(applyId);
		
		// 删除选定的apply
		applyDao.doDelete(applyId);
		
		// 返回被删除的apply
		return apply;
	}
	
	
}
