package com.yiban.dao;

import org.apache.ibatis.session.SqlSession;

import com.yiban.bean.UserBean;
import com.yiban.db.DBAccess;

public class UserDao {
	public boolean doCreate(UserBean user) {
		
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlsession执行SQL语句
			sqlSession.insert("User.doCreate", user);
		} catch (Exception e) {
			System.out.println("UserDao has an error:" + e);
			System.out.println(user.toString());
			
			return false;
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return true;
	}
}
