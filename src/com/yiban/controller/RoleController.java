package com.yiban.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yiban.bean.ResultBean;
import com.yiban.bean.RoleBean;
import com.yiban.service.RoleService;

@Controller
public class RoleController {
	
	@ResponseBody
	@PostMapping("/role")
	public ResultBean create(HttpServletRequest request) {
//		RoleService roleService = new RoleService();
//		RoleBean role = new RoleBean();
//		
//		// 构造RoleBean
//		role.setRoleName(request.getParameter("roleName"));
//		
//		// 调用service层插入role
//		if(roleService.insert(role)) {
//			return ResultBean.success().add("role", role);
//		}
//		else {
//			return ResultBean.error("插入角色失败");
//		}
		System.out.println("create");
		return null;
	}
	
	@ResponseBody
	@DeleteMapping("/role")
	public ResultBean deleteById(@RequestParam Integer roleId) {
		
//		System.out.println("delete Id: " + roleId);
//		RoleService roleService = new RoleService();
//		
//		// service层删除role
//		RoleBean role = roleService.delete(roleId);
//		
//		// 返回操作信息
//		if(role != null) {
//			return ResultBean.success().add("role", role);
//		}
//		else {
//			return ResultBean.error("删除失败");
//		}
		System.out.println("delete");
		return null;
	}
	

	@ResponseBody
	@GetMapping("/role")
	public ResultBean selectById(@RequestParam Integer roleId) {
		RoleService roleService = new RoleService();
		
		// 查询给定id的role
		RoleBean role = roleService.select(roleId);
		
		// 返回操作信息
		if(role != null) {
			return ResultBean.success().add("role", role);
		}
		else {
			return ResultBean.error("查询失败");
		}
	}
}
