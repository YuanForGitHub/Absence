package com.yiban.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.yiban.bean.PermissionBean;
import com.yiban.bean.RoleBean;
import com.yiban.bean.UserBean;
import com.yiban.service.UserService;

/**
 * 	用作监听接口访问，权限管理
 * 	但是目前使用aop，此类保留参考
 * 	暂不使用
 * @author Administrator
 *
 */
public class PermissionInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		
		// 查询用户信息
		int userId = Integer.valueOf(request.getParameter("userId"));
		UserService userService = new UserService();
		UserBean user = userService.select(userId);
		
		// 整理用户权限
		List<RoleBean> roles = user.getRoles();
		List<Integer> permissionIds = new ArrayList<>();
		for(int i=0; i<roles.size(); i++) {
			
			RoleBean role = roles.get(i);
			List<PermissionBean> permissions = role.getPermissions();
			
			for(int j=0; i<permissions.size(); i++) {
				permissionIds.add(permissions.get(j).getPermissionId());
			}
		}
		
		// 获取用户要访问接口
		String uri = request.getRequestURI();
		String method = request.getMethod();
		
		/* 判断权限等级
		 * 	管理员访问PermissionController, RoleController: 5 6 7 8
		 * 1	审核干事值班请假;
		 * 2	审核干部值班请假;
		 * 3	审核干事会议活动请假;
		 * 4	审核干部会议活动请假;
		 * 5	添加管理员;
		 * 6	删除管理员;
		 * 7	添加审核人员;
		 * 8	删除审核人员;
		 */
		// coding...
		return true;
	}

}
