package com.yiban.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yiban.bean.ResultBean;
import com.yiban.bean.UserBean;
import com.yiban.service.UserService;

@Controller
public class UserController {
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	@ResponseBody
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
}
