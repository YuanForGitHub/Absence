package com.yiban.dao;

import com.yiban.bean.PermissionBean;

public interface PermissionMapper {
	
	public int doInsert(PermissionBean permission);
	
	public PermissionBean doSelect(Integer permissionId);
	
	public int doDelete(Integer permissionId);
	
}
