package com.yiban.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.yiban.bean.UserBean;
import com.yiban.dao.UserMapper;
import com.yiban.db.DBAccess;

@Service
public class UserService {
	
	public static final String KEY_MD5 = "MD5";
	
	public boolean insert(UserBean user) {
		SqlSession sqlSession = null;
		int result = 0;
		
		try {
			// 获取数据库连接会话
			sqlSession = new DBAccess().getSqlSession();
			// 获取映射对象
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			// 执行SQL语句
			result = mapper.doCreate(user);
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return ((result > 0) ? true : false); 
	}
	
	public UserBean select(Integer userId) {
		SqlSession sqlsession = null;
		UserBean user = null;
		try {
			// 获取数据库连接会话
			SqlSession sqlSession = new DBAccess().getSqlSession();
			// 获取映射对象
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			// 执行SQL语句
			user = mapper.doSelect(userId);
		} catch (Exception e) {
			System.out.println(e);
			return user;
		} finally {
			if(sqlsession != null) {
				sqlsession.close();
			}
		}
		
		return user; 
	}
	
	public UserBean delete(Integer userId) {
		SqlSession sqlsession = null;
		UserBean user = null;
		int result = 0;
		try {
			// 获取数据库连接会话
			SqlSession sqlSession = new DBAccess().getSqlSession();
			// 获取映射对象
			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
			// 查询要删除对象
			user = mapper.doSelect(userId);
			// 执行删除
			result = mapper.doDelete(userId);
		} catch (Exception e) {
			System.out.println(e);
			return user;
		} finally {
			if(sqlsession != null) {
				sqlsession.close();
			}
		}
		
		return result > 0 ? user : null;
	}
}
