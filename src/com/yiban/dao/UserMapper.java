package com.yiban.dao;

import java.util.List;

import com.yiban.bean.UserBean;

public interface UserMapper {
	
	public int doCreate(UserBean user);
	
	public UserBean doSelect(Integer userId);
	
	/**
	 * 根据传入的userId，
	 * 查询用户所属角色
	 * @param userId
	 * @return
	 */
	public List<UserBean> doSelectUserRole(Integer userId);
	
	public int doDelete(Integer userId);
}
