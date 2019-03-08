package com.yiban.service;

import org.springframework.stereotype.Service;

import com.yiban.bean.RoleBean;
import com.yiban.dao.RoleDao;

@Service
public class RoleService {
	
	public boolean insert(RoleBean role) {
		RoleDao roleDao = new RoleDao();
		return roleDao.doInsert(role)>0 ? true : false;
	}
	
	public RoleBean select(String roleId) {
		RoleDao roleDao = new RoleDao();
		return roleDao.doSelect(roleId);
	}
	
	public RoleBean delete(String roleId) {
		// 被删除的role
		RoleDao roleDao = new RoleDao();
		RoleBean role = roleDao.doSelect(roleId);
		
		// 删除role
		roleDao.doDelete(roleId);
		
		// 返回被删除的role
		return role;
	}
}
