package com.yiban.dao;

import java.util.List;

import com.yiban.bean.UserBean;

public interface UserMapper {
	
	public int doCreate(UserBean user);
	
	public UserBean doSelect(Integer userId);
	
	public int doDelete(Integer userId);
}
