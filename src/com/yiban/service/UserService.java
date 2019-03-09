package com.yiban.service;

import org.springframework.stereotype.Service;

import com.yiban.bean.UserBean;
import com.yiban.dao.UserDao;
import com.yiban.util.Encrypt;

@Service
public class UserService {
	
	public static final String KEY_MD5 = "MD5";
	
	public boolean insert(UserBean user) {
		UserDao userDao = new UserDao();
		
		// 加密用户密码
		String password = Encrypt.EncoderByMd5(user.getPassword());
		
		if(password == null) {
			return false;
		}
		
		// 设置用户密码
		user.setPassword(password);
		// 执行插入
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
