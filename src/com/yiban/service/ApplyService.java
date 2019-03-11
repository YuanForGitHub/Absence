package com.yiban.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiban.bean.ApplyBean;
import com.yiban.bean.ReviewBean;
import com.yiban.dao.ApplyDao;
import com.yiban.dao.ReviewDao;

@Service
public class ApplyService {

//	@Autowired
//	private ApplyDao applyDao;
	
	public boolean insert(ApplyBean apply) {
		ApplyDao applyDao = new ApplyDao();
		return applyDao.doCreate(apply) > 0 ? true : false;
	}
	
	public ApplyBean select(Integer applyId) {
		ApplyDao applyDao = new ApplyDao();
		return applyDao.doSelect(applyId);
	}
	
	public ApplyBean delete(Integer applyId) {
		// 被删除的apply
		ApplyDao applyDao = new ApplyDao();
		ApplyBean apply = applyDao.doSelect(applyId);
		
		// 删除选定的apply
		applyDao.doDelete(applyId);
		
		// 返回被删除的apply
		return apply;
	}
	
	public boolean review(ReviewBean review) {
		// 查询被审核申请
		ApplyDao applyDao = new ApplyDao();
		ApplyBean apply = applyDao.doSelect(review.getApplyId());
		
		// 保存审核结果
		apply.setIsPass(review.getIsPass());
		apply.setDescription(review.getDescription());
		
		// 更新bean对象
		int result = applyDao.doUpdate(apply);
		
		// 记录审核情况
		if(result > 0) {
			ReviewDao reviewDao = new ReviewDao();
			// 记录成功
			if(reviewDao.doCreate(review) > 0) {
				return true;
			}
		}
		
		// 审核失败
		return false;
	}
}
