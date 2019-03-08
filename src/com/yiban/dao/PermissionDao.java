package com.yiban.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.yiban.bean.PermissionBean;
import com.yiban.db.DBAccess;

@Repository
public class PermissionDao {
	
	public int doInsert(PermissionBean permission) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result = 0;
		
		try {
			// 获取数据库连接会话
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlsession执行SQL语句
			result = sqlSession.insert("Permission.doCreate", permission);
		} catch (Exception e) {
			System.out.println("PermissionDao has an error: " + e);
			System.out.println(permission.toString());
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return result;
	}
	
	public PermissionBean doSelect(String permissionId) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		PermissionBean permission = null;
		
		try {
			// 获取数据库连接会话
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlsession执行SQL语句
			permission = sqlSession.selectOne("Permission.doSelect", Integer.valueOf(permissionId));
		} catch (Exception e) {
			// 打印错误信息
			System.out.println("PermissionDao has an error:" + e);
			System.out.println(permission.toString());
		} finally {
			// 关闭数据库连接会话
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return permission;
	}
	
	public int doDelete(String permissionId) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result = 0;
		
		try {
			// 获取数据库连接会话
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlsession执行SQL语句
			result = sqlSession.delete("Permission.doDelete", Integer.valueOf(permissionId));
		} catch (Exception e) {
			// 打印错误信息
			System.out.println("PermissionDao has an error:" + e);
		} finally {
			// 关闭数据库连接会话
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return result;
	}
}
