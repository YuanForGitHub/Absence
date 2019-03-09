package com.yiban.dao;

import org.apache.ibatis.session.SqlSession;

import com.yiban.bean.ReviewBean;
import com.yiban.db.DBAccess;

public class ReviewDao {
	
	public int doCreate(ReviewBean review) {

		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result = 0;
		
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlsession执行SQL语句
			result = sqlSession.insert("Review.doCreate", review);
		} catch (Exception e) {
			System.out.println("ReviewDao has an error:" + e);
			System.out.println(review.toString());
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return result;
	}
}
