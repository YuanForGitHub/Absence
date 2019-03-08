package com.yiban.service;

import com.yiban.bean.PermissionBean;
import com.yiban.dao.PermissionDao;

public class PermissionService {
	
	public boolean insert(PermissionBean permission) {
		PermissionDao permissionDao = new PermissionDao();
		return permissionDao.doInsert(permission)>0 ? true : false;
	}
	
	public PermissionBean delete(String permissionId) {
		// 被删除的role
		PermissionDao permissionDao = new PermissionDao();
		PermissionBean permission = permissionDao.doSelect(permissionId);
		
		// 删除role
		permissionDao.doDelete(permissionId);
		
		// 返回被删除的role
		return permission;
	}
}
