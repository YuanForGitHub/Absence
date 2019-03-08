package com.yiban.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.yiban.bean.ResultBean;
import com.yiban.bean.UserBean;
import com.yiban.dao.UserDao;
import com.yiban.service.UserService;

@Controller
public class UserController {
	
	@ResponseBody
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public ResultBean create(HttpServletRequest request) {
		UserBean user = new UserBean();
		UserService userService = new UserService();
		
		// 赋值给userbean
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));
		user.setPhone(request.getParameter("phone"));
		
		// 调用service层插入
		if(userService.insert(user)) {
			return ResultBean.success().add("user", user);
		}
		else {
			return ResultBean.error("插入失败");
		}
	}

	@ResponseBody
	@RequestMapping(value="/user", method=RequestMethod.DELETE)
	public ResultBean delete(HttpServletRequest request) {
		UserService userService = new UserService();
		
		String userId = request.getParameter("userId");
		UserBean user = userService.delete(userId);
		
		// 调用service层删除
		if(user != null) {
			return ResultBean.success().add("user", user);
		}
		else {
			return ResultBean.error("删除失败");
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public ResultBean select(HttpServletRequest request) {
		UserService userService = new UserService();
		
		// 查询选定用户
		String userId = request.getParameter("userId");
		UserBean user = userService.select(userId);
		
		// 调用service层删除
		if(user != null) {
			return ResultBean.success().add("user", user);
		}
		else {
			return ResultBean.error("查询失败");
		}
	}

}
