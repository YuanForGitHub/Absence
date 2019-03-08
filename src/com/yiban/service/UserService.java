package com.yiban.service;

import com.yiban.bean.UserBean;
import com.yiban.dao.UserDao;

public class UserService {
	
	public boolean insert(UserBean user) {
		UserDao userDao = new UserDao();
		return userDao.doCreate(user)>0 ? true : false;
	}
	
	public UserBean select(String userId) {
		UserDao userDao = new UserDao();
		return userDao.doSelect(userId);
	}
	
	public UserBean delete(String userId) {
		// 被删除的user
		UserDao userDao = new UserDao();
		UserBean user = userDao.doSelect(userId);
		
		// 删除选定的user
		userDao.doDelete(userId);
		
		// 返回被删除的user
		return user;
	}
}
