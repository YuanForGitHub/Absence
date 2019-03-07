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
		return applyDao.doCreate(apply);
	}
}
