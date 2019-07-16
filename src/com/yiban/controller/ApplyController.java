package com.yiban.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.yiban.bean.ApplyBean;
import com.yiban.bean.DepartmentBean;
import com.yiban.bean.ResultBean;
import com.yiban.bean.ReviewBean;
import com.yiban.service.ApplyService;
import com.yiban.service.DepartmentService;
import com.yiban.service.UserService;

@Controller
public class ApplyController {

	@ResponseBody
	@PostMapping("/apply")
	public ResultBean create(HttpServletRequest request) {
		ApplyService applyService = new ApplyService();
		ApplyBean apply = new ApplyBean();

		// 查找对应的department
		DepartmentService departmentService = new DepartmentService();
		DepartmentBean department = departmentService.select(Integer.valueOf(request.getParameter("departmentId")));

		// 赋值给applyBean
		apply.setActivity(request.getParameter("activity"));
		apply.setJob(request.getParameter("job"));
		apply.setName(request.getParameter("name"));
		apply.setStartTime(request.getParameter("startTime"));
		apply.setEndTime(request.getParameter("endTime"));
		apply.setReason(request.getParameter("reason"));
		apply.setOther(request.getParameter("other"));
		apply.setPhone(request.getParameter("phone"));
		apply.setDepartment(department);

		// 将applyBean传参给service层
		if (applyService.insert(apply)) {
			return ResultBean.success().add("apply", apply);
		} else {
			return ResultBean.error("插入失败");
		}
	}

	@ResponseBody
	@DeleteMapping("/apply")
	public ResultBean deleteById(HttpServletRequest request) {

		ApplyService applyService = new ApplyService();

		// service层删除apply
		String applyId = request.getParameter("applyId");
		ApplyBean apply = applyService.delete(Integer.valueOf(applyId));

		// 返回操作信息
		if (apply != null) {
			return ResultBean.success().add("apply", apply);
		} else {
			return ResultBean.error("删除失败");
		}
	}

	/**
	 * 给定申请id查询
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@GetMapping("/apply")
	public ResultBean selectById(HttpServletRequest request) {
		ApplyService applyService = new ApplyService();

		// 查询apply
		String applyId = request.getParameter("applyId");
		ApplyBean apply = applyService.select(Integer.valueOf(applyId));

		// 返回操作信息
		if (apply != null) {
			return ResultBean.success().add("apply", apply);
		} else {
			return ResultBean.error("查询失败");
		}
	}

	/**
	 * 根据当前用户的权限，
	 * 返回可以审核的申请
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@GetMapping("/user/apply")
	public ResultBean selectByUser(@RequestParam Integer userId) {
		// 调用service层查询
		ApplyService applyService = new ApplyService();
		List<ApplyBean> applys = applyService.selectByUser(userId);

		// 返回操作信息
		if (applys != null && !applys.isEmpty()) {
			return ResultBean.success().add("applys", applys);
		} else {
			return ResultBean.error("查询失败");
		}
	}

	@ResponseBody
	@PostMapping("/apply/review")
	public ResultBean review(@RequestParam Integer applyId, @RequestParam Integer userId,
			@RequestParam(required = false) String description, @RequestParam Integer isPass) {

		// 封装成bean
		ReviewBean review = new ReviewBean();
		review.setApplyId(applyId);
		review.setUserId(userId);
		review.setDescription(description);
		review.setIsPass(isPass);

		// 传递给service层执行
		ApplyService applyService = new ApplyService();
		if (applyService.review(review)) {
			return ResultBean.success();
		} else {
			return ResultBean.error("审核失败");
		}
	}
	
	@Autowired
	private ApplyBean applyTest;
	
	@ResponseBody
	@GetMapping("/apply/testone")
	public ResultBean testone() {
		System.out.println(applyTest.hashCode());
		return null;
	}
	
	@ResponseBody
	@GetMapping("/apply/testtwo")
	public ResultBean testotwo() {
		System.out.println("testtwo");
		return ResultBean.success();
	}
}
