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

	@ResponseBody
	@RequestMapping(value="/apply", method=RequestMethod.POST)
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
		apply.setPhone(request.getParameter("phone"));
		
		// 将applyBean传参给service层
		if(applyService.insert(apply)) {
			return ResultBean.success().add("apply", apply);
		}
		else {
			return ResultBean.error("插入失败");
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/apply", method=RequestMethod.DELETE)
	public ResultBean deleteById(HttpServletRequest request) {
		
		ApplyService applyService = new ApplyService();
		
		// service层删除apply
		String applyId = request.getParameter("applyId");
		ApplyBean apply = applyService.delete(applyId);
		
		// 返回操作信息
		if(apply != null) {
			return ResultBean.success().add("apply", apply);
		}
		else {
			return ResultBean.error("删除失败");
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/apply", method=RequestMethod.GET)
	public ResultBean selectById(HttpServletRequest request) {
		ApplyService applyService = new ApplyService();
		
		// 查询apply
		String applyId = request.getParameter("applyId");
		ApplyBean apply = applyService.select(applyId);
		
		// 返回操作信息
		if(apply != null) {
			return ResultBean.success().add("apply", apply);
		}
		else {
			return ResultBean.error("查询失败");
		}
	}
}
