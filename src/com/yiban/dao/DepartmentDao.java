package com.yiban.dao;

import org.apache.ibatis.session.SqlSession;

import com.yiban.bean.ApplyBean;
import com.yiban.bean.DepartmentBean;
import com.yiban.db.DBAccess;

public class DepartmentDao {
	
	public DepartmentBean doSelect(Integer departmentId) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		DepartmentBean department = null;
		
		try {
			// 获取数据库连接会话
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlsession执行SQL语句
			department = sqlSession.selectOne("Department.doSelect", departmentId);
		} catch (Exception e) {
			// 打印错误信息
			System.out.println("DepartmentDao has an error:" + e);
			System.out.println(department.toString());
		} finally {
			// 关闭数据库连接会话
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return department;
	}
}
