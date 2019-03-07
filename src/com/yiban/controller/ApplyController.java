package com.yiban.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yiban.bean.ApplyBean;
import com.yiban.bean.ResultBean;
import com.yiban.service.ApplyService;

@Controller
public class ApplyController {

//	@Autowired
//	ApplyService applyService;
//	@Autowired
//	ApplyBean apply;
	
	@RequestMapping(value="/apply", method=RequestMethod.POST)
	@ResponseBody
	public ResultBean create(HttpServletRequest request) {
		ApplyService applyService = new ApplyService();
		ApplyBean apply = new ApplyBean();
		
		// 赋值给applyBean
		apply.setActivity(request.getParameter("activity"));
		apply.setDepartment(request.getParameter("department"));
		apply.setJob(request.getParameter("job"));
		apply.setName(request.getParameter("name"));
		apply.setStartTime(request.getParameter("startTime"));
		apply.setEndTime(request.getParameter("endTime"));
		apply.setReason(request.getParameter("reason"));
		apply.setOther(request.getParameter("other"));
		
		// 将applyBean传参给service层
		if(applyService.insert(apply)) {
			return ResultBean.success().add("apply", apply);
		}
		else {
			return ResultBean.error("插入失败");
		} 
	}
}
