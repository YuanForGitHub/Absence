package com.yiban.service;

import com.yiban.bean.UserBean;
import com.yiban.dao.UserDao;

public class UserService {
	
	public boolean insert(UserBean user) {
		UserDao userDao = new UserDao();
		return userDao.doCreate(user);
	}
}
