package com.yiban.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.yiban.bean.ResultBean;
import com.yiban.bean.UserBean;
import com.yiban.service.UserService;

/**
 * TODO: 用户密码加密，
 * 网址：https://hello-nick-xu.iteye.com/blog/2103775
 */
@Controller
public class UserController {
	
	@ResponseBody
	@PostMapping("/user")
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
			return ResultBean.error("用户添加失败");
		}
	}

	@ResponseBody
	@DeleteMapping("/user")
	public ResultBean deleteById(HttpServletRequest request) {
		UserService userService = new UserService();
		
		String userId = request.getParameter("userId");
		UserBean user = userService.delete(Integer.valueOf(userId));
		
		// 调用service层删除
		if(user != null) {
			return ResultBean.success().add("user", user);
		}
		else {
			return ResultBean.error("删除失败");
		}
	}
	
	@ResponseBody
	@GetMapping("/user")
	public ResultBean selectById(HttpServletRequest request) {
		UserService userService = new UserService();
		
		// 查询选定用户
		String userId = request.getParameter("userId");
		UserBean user = userService.select(Integer.valueOf(userId));
		
		// 调用service层删除
		if(user != null) {
			return ResultBean.success().add("user", user);
		}
		else {
			return ResultBean.error("查询失败");
		}
	}

}
