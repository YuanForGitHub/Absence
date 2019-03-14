package com.yiban.test;

import java.security.Key;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yiban.bean.ApplyBean;
import com.yiban.bean.DepartmentBean;
import com.yiban.bean.UserBean;
import com.yiban.db.DBAccess;
import com.yiban.service.ApplyService;
import com.yiban.util.JWTUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import junit.framework.TestCase;

import io.jsonwebtoken.*;

public class JunitTest extends TestCase {

	@Test
	public void testPrintMessage() {
//		ApplyService applyService = new ApplyService();
//		ApplyBean apply = applyService.select(2);
//		System.out.println(apply);
		
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		ApplyBean apply = null;
		
		try {
			// 获取数据库连接会话
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlsession执行SQL语句
			apply = sqlSession.selectOne("Apply.doSelect", 2);
		} catch (Exception e) {
			// 打印错误信息
			System.out.println("DepartmentDao has an error:" + e);
			System.out.println(apply.toString());
		} finally {
			// 关闭数据库连接会话
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		
		System.out.println(apply);
	}
}
