package com.yiban.dao;

import com.yiban.bean.RoleBean;

public interface RoleMapper {

	public int doInsert(RoleBean role);
	
	public RoleBean doSelect(Integer roleId);
	
	public int doDelete(Integer roleId);
	
}
