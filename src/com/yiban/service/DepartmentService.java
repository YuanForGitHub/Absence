package com.yiban.service;

import com.yiban.bean.DepartmentBean;
import com.yiban.dao.DepartmentDao;

public class DepartmentService {
	public DepartmentBean select(Integer departmentId) {
		DepartmentDao departmentDao = new DepartmentDao();
		return departmentDao.doSelect(departmentId);
	}
}
