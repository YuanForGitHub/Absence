package com.yiban.dao;

import org.apache.ibatis.session.SqlSession;

import com.yiban.bean.ApplyBean;
import com.yiban.db.DBAccess;

public class ApplyDao {
	/**
	 * 添加申请信息
	 */
	public int doCreate(ApplyBean apply) {

		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result = 0;

		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlsession执行SQL语句
			result = sqlSession.insert("Apply.doCreate", apply);
		} catch (Exception e) {
			System.out.println("ApplyDao has an error:" + e);
			System.out.println(apply.toString());
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return result;
	}

	public ApplyBean doSelect(Integer applyId) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		ApplyBean apply = null;

		try {
			// 获取数据库连接会话
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlsession执行SQL语句
			apply = sqlSession.selectOne("Apply.doSelect", applyId);
		} catch (Exception e) {
			// 打印错误信息
			System.out.println("ApplyDao has an error:" + e);
			System.out.println(apply.toString());
		} finally {
			// 关闭数据库连接会话
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return apply;
	}

	public int doDelete(Integer applyId) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result = 0;

		try {
			// 获取数据库连接会话
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlsession执行SQL语句
			result = sqlSession.delete("Apply.doDelete", applyId);
		} catch (Exception e) {
			// 打印错误信息
			System.out.println("ApplyDao has an error:" + e);
		} finally {
			// 关闭数据库连接会话
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return result;
	}

	public int doUpdate(ApplyBean apply) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result = 0;

		try {
			// 获取数据库连接会话
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlsession执行SQL语句
			result = sqlSession.update("Apply.doUpdate", apply);
		} catch (Exception e) {
			// 打印错误信息
			System.out.println("ApplyDao has an error:" + e);
		} finally {
			// 关闭数据库连接会话
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return result;
	}
}
