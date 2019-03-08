package com.yiban.dao;

import org.apache.ibatis.session.SqlSession;

import com.yiban.bean.ApplyBean;
import com.yiban.bean.UserBean;
import com.yiban.db.DBAccess;

public class UserDao {
	public int doCreate(UserBean user) {

		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result = 0;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlsession执行SQL语句
			result = sqlSession.insert("User.doCreate", user);
		} catch (Exception e) {
			System.out.println("UserDao has an error:" + e);
			System.out.println(user.toString());
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return result;
	}

	public UserBean doSelect(String userId) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		UserBean user = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlsession执行SQL语句
			user = sqlSession.selectOne("User.doSelect", Integer.valueOf(userId));
		} catch (Exception e) {
			System.out.println("UserDao has an error:" + e);
			System.out.println(user.toString());
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return user;
	}
	
	public int doDelete(String userId) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result = 0;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlsession执行SQL语句
			result = sqlSession.delete("User.doDelete", Integer.valueOf(userId));
		} catch (Exception e) {
			System.out.println("UserDao has an error:" + e);
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return result;
	}
}
