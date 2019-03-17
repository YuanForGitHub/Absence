package com.yiban.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiban.bean.ApplyBean;
import com.yiban.bean.ReviewBean;
import com.yiban.dao.ApplyMapper;
import com.yiban.dao.ReviewMapper;
import com.yiban.db.DBAccess;

@Service
public class ApplyService {
	
	
	
	public boolean insert(ApplyBean apply) {
		SqlSession sqlSession = null;
		int result = 0;
		try {
			// 获取数据库连接会话
			sqlSession = new DBAccess().getSqlSession();
			// 获取映射对象
			ApplyMapper mapper = sqlSession.getMapper(ApplyMapper.class);
			// 执行SQL语句
			result = mapper.doCreate(apply);
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return ((result > 0) ? true : false); 
	}
	
	public ApplyBean select(Integer applyId) {
		SqlSession sqlsession = null;
		ApplyBean apply = null;
		try {
			// 获取数据库连接会话
			SqlSession sqlSession = new DBAccess().getSqlSession();
			// 获取映射对象
			ApplyMapper mapper = sqlSession.getMapper(ApplyMapper.class);
			// 执行SQL语句
			apply = mapper.doSelect(applyId);
		} catch (Exception e) {
			System.out.println(e);
			return apply;
		} finally {
			if(sqlsession != null) {
				sqlsession.close();
			}
		}
		
		return apply; 
	}
	
	public ApplyBean delete(Integer applyId) {
		SqlSession sqlsession = null;
		ApplyBean apply = null;
		int result = 0;
		try {
			// 获取数据库连接会话
			SqlSession sqlSession = new DBAccess().getSqlSession();
			// 获取映射对象
			ApplyMapper mapper = sqlSession.getMapper(ApplyMapper.class);
			// 查询要删除对象
			apply = mapper.doSelect(applyId);
			// 执行删除
			result = mapper.doDelete(applyId);
		} catch (Exception e) {
			System.out.println(e);
			return apply;
		} finally {
			if(sqlsession != null) {
				sqlsession.close();
			}
		}
		
		return result > 0 ? apply : null;
	}
	
	public boolean review(ReviewBean review) {
		SqlSession sqlSession = null;
		ApplyBean apply = null;
		int result = 0;
		try {
			// 获取数据库连接会话
			sqlSession = new DBAccess().getSqlSession();
			ApplyMapper mapper = sqlSession.getMapper(ApplyMapper.class);
			
			// 查询被审核申请
			apply = mapper.doSelect(review.getApplyId());
			
			// 保存审核结果
			apply.setIsPass(review.getIsPass());
			apply.setDescription(review.getDescription());
			
			// 更新bean对象
			result = mapper.doUpdate(apply);
			
			// 记录审核情况
			if(result > 0) {
				ReviewMapper reviewMapper = sqlSession.getMapper(ReviewMapper.class);
				result = reviewMapper.doCreate(review);
			}
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			sqlSession.close();
		}
		
		return (result > 0 ? true : false);
	}
}
