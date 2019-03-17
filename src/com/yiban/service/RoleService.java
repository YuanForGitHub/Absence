package com.yiban.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.yiban.bean.ApplyBean;
import com.yiban.bean.RoleBean;
import com.yiban.dao.ApplyMapper;
import com.yiban.dao.RoleMapper;
import com.yiban.db.DBAccess;

@Service
public class RoleService {

	public boolean insert(RoleBean role) {
		SqlSession sqlSession = null;
		int result = 0;

		try {
			// 获取数据库连接会话
			sqlSession = new DBAccess().getSqlSession();
			// 获取映射对象
			RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
			// 执行SQL语句
			result = mapper.doInsert(role);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return result > 0 ? true : false;
	}

	public RoleBean select(Integer roleId) {
		SqlSession sqlSession = null;
		RoleBean role = null;
		
		try {
			sqlSession = new DBAccess().getSqlSession();
			RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
			// 执行SQL语句
			role = mapper.doSelect(roleId);
		} catch (Exception e) {
			System.out.println(e);
			return role;
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return role;
	}

	public RoleBean delete(Integer roleId) {
		SqlSession sqlsession = null;
		RoleBean role = null;
		int result = 0;
		try {
			// 获取数据库连接会话
			SqlSession sqlSession = new DBAccess().getSqlSession();
			// 获取映射对象
			RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
			// 查询要删除对象
			role = mapper.doSelect(roleId);
			// 执行删除
			result = mapper.doDelete(roleId);
		} catch (Exception e) {
			System.out.println(e);
			return role;
		} finally {
			if(sqlsession != null) {
				sqlsession.close();
			}
		}
		
		return result > 0 ? role : null;
	}
}
