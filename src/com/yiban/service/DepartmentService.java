package com.yiban.service;

import org.apache.ibatis.session.SqlSession;

import com.yiban.bean.DepartmentBean;
import com.yiban.dao.DepartmentMapper;
import com.yiban.db.DBAccess;

public class DepartmentService {
	public DepartmentBean select(Integer departmentId) {
		SqlSession sqlSession = null;
		DepartmentBean department = null;
		
		try {
			// 获取数据库连接会话
			sqlSession = new DBAccess().getSqlSession();
			// 获取映射对象
			DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
			// 执行SQL语句
			department = mapper.doSelect(departmentId);
		} catch (Exception e) {
			// 打印错误信息
			System.out.println(e);
			// 返回空对象
			return department;
		} finally {
			// 关闭数据库连接会话
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return department;
	}
}
