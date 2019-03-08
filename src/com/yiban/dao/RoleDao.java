package com.yiban.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.yiban.bean.PermissionBean;
import com.yiban.bean.RoleBean;
import com.yiban.db.DBAccess;

@Repository
public class RoleDao {
	
	public int doInsert(RoleBean role) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result = 0;
		
		try {
			// 获取数据库连接会话
			sqlSession = dbAccess.getSqlSession();
			// 执行SQL语句
			result = sqlSession.insert("Role.doCreate", role);
		} catch (Exception e) {
			// 打印错误信息
			System.out.println("PermissionDao has an error:" + e);
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return result;
	}
	
	public RoleBean doSelect(String roleId) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		RoleBean role = null;
		
		try {
			// 获取数据库连接会话
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlsession执行SQL语句
			role = sqlSession.selectOne("Role.doSelect", Integer.valueOf(roleId));
		} catch (Exception e) {
			// 打印错误信息
			System.out.println("RoleDao has an error:" + e);
			System.out.println(role.toString());
		} finally {
			// 关闭数据库连接会话
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return role;
	}
	
	public int doDelete(String roleId) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result = 0;
		
		try {
			// 获取数据库连接会话
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlsession执行SQL语句
			result = sqlSession.delete("Role.doDelete", Integer.valueOf(roleId));
		} catch (Exception e) {
			// 打印错误信息
			System.out.println("RoleDao has an error:" + e);
		} finally {
			// 关闭数据库连接会话
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return result;
	}
}
