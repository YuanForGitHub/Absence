package com.yiban.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yiban.bean.ResultBean;
import com.yiban.bean.PermissionBean;
import com.yiban.service.PermissionService;

/**
 * 此控制器只用于管理权限，
 * 不向用户和管理员展示
 */
@Controller
public class PermissionController {
	
	@ResponseBody
	@PostMapping("/permission")
	public ResultBean create(HttpServletRequest request) {
		PermissionService permissionService = new PermissionService();
		PermissionBean permission = new PermissionBean();
		
		// 构造Bean
		permission.setPermissionName(request.getParameter("permissionName"));
		
		// 调用service层插入
		if(permissionService.insert(permission)) {
			return ResultBean.success().add("permission", permission);
		}
		else {
			return ResultBean.error("插入权限失败");
		}
	}
	
	@ResponseBody
	@DeleteMapping("/permission")
	public ResultBean deleteById(HttpServletRequest request) {
		PermissionService permissionService = new PermissionService();
		
		// 调用service层删除
		PermissionBean permission = permissionService.delete(request.getParameter("permissionId"));
		
		// 返回操作信息
		if(permission != null) {
			return ResultBean.success().add("permission", permission);
		}
		else {
			return ResultBean.error("删除权限失败");
		}
		
	}
}
