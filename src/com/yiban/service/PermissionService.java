package com.yiban.service;

import org.apache.ibatis.session.SqlSession;

import com.yiban.bean.PermissionBean;
import com.yiban.dao.PermissionMapper;
import com.yiban.db.DBAccess;

public class PermissionService {
	
	public boolean insert(PermissionBean permission) {
		SqlSession sqlSession = null;
		int result = 0;
		
		try {
			// 获取数据库连接会话
			sqlSession = new DBAccess().getSqlSession();
			// 获取映射对象
			PermissionMapper mapper = sqlSession.getMapper(PermissionMapper.class);
			// 执行SQL语句
			result = mapper.doInsert(permission);
		} catch (Exception e) {
			// 打印错误信息
			System.out.println(e);
			// 返回空对象
			return false;
		} finally {
			// 关闭数据库连接会话
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return result>0 ? true : false;
	}
	
	public PermissionBean delete(Integer permissionId) {
		SqlSession sqlsession = null;
		PermissionBean permission = null;
		int result = 0;
		
		try {
			// 获取数据库连接会话
			SqlSession sqlSession = new DBAccess().getSqlSession();
			// 获取映射对象
			PermissionMapper mapper = sqlSession.getMapper(PermissionMapper.class);
			// 查询要删除对象
			permission = mapper.doSelect(permissionId);
			// 执行删除
			result = mapper.doDelete(permissionId);
		} catch (Exception e) {
			System.out.println(e);
			return permission;
		} finally {
			if(sqlsession != null) {
				sqlsession.close();
			}
		}
		
		return result > 0 ? permission : null;
	}
	
	public PermissionBean select(Integer permissionId) {
		SqlSession sqlSession = null;
		PermissionBean permission = null;
		
		try {
			// 获取数据库连接会话
			sqlSession = new DBAccess().getSqlSession();
			// 获取映射对象
			PermissionMapper mapper = sqlSession.getMapper(PermissionMapper.class);
			// 执行SQL语句
			permission = mapper.doSelect(permissionId);
		} catch (Exception e) {
			// 打印错误信息
			System.out.println(e);
			// 返回空对象
			return permission;
		} finally {
			// 关闭数据库连接会话
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return permission;
	}
}
