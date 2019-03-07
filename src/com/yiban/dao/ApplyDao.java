package com.yiban.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sun.jmx.snmp.SnmpUnknownSubSystemException;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.yiban.bean.ApplyBean;
import com.yiban.db.DBAccess;


@Repository
/**
 * apply相关的数据库操作
 */
public class ApplyDao {
	/**
	 * 添加申请信息
	 */
	public int doCreate(ApplyBean apply) {
//		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//		String DB_URL = "jdbc:mysql://localhost:3306/absence?useUnicode=true&characterEncoding=UTF-8";
//		String USER = "root";
//		String PASS = "root";

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

//		Connection conn = null;
//		PreparedStatement stmt = null;
//		Statement st = null;
//		try {
//			Class.forName(JDBC_DRIVER);
//
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
//
//			String sql = "INSERT INTO apply(activity,name,department,job,startTime,endTime,reason,other) VALUES(?,?,?,?,?,?,?,?)";
//			stmt = conn.prepareStatement(sql);
//			stmt.setString(1, apply.getActivity());
//			stmt.setString(2, apply.getName());
//			stmt.setString(3, apply.getDepartment());
//			stmt.setString(4, apply.getJob());
//			stmt.setTimestamp(5, Timestamp.valueOf(apply.getStartTime()));
//			stmt.setTimestamp(6, Timestamp.valueOf(apply.getEndTime()));
//			stmt.setString(7, apply.getReason());
//			stmt.setString(8, apply.getOther());
//
//			if (stmt.executeUpdate() > 0) {
//				return true;
//			} else
//				return false;
//		} catch (Exception e) {
//			System.out.println("e : " + e);
//		} finally {
//			try {
//				if (stmt != null)
//					stmt.close();
//			} catch (Exception e2) {
//				System.out.println("e2: " + e2);
//			}
//
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (Exception e3) {
//				System.out.println("e3: " + e3);
//			}
//		}
//
//		return false;
	}

	public ApplyBean doSelect(String applyId) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		ApplyBean apply = null;
		
		try {
			// 获取数据库连接会话
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlsession执行SQL语句
			apply = sqlSession.selectOne("Apply.doSelect", Integer.valueOf(applyId));
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
	
	public int doDelete(String applyId) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result = 0;
		
		try {
			// 获取数据库连接会话
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlsession执行SQL语句
			result = sqlSession.delete("Apply.doDelete", Integer.valueOf(applyId));
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
