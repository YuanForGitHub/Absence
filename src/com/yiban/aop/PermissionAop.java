package com.yiban.aop;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.yiban.bean.PermissionBean;
import com.yiban.bean.ResultBean;
import com.yiban.bean.RoleBean;
import com.yiban.bean.UserBean;
import com.yiban.service.UserService;
import com.yiban.util.JWTUtil;

import io.jsonwebtoken.Claims;


@Aspect
@Component
public class PermissionAop {
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
	
	/**
	 *	user增删查改接口权限访问限制
	 *	role接口访问权限限制
	 *	（因为时间不够，所以暂时没有限制其他接口）
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("execution(* com.yiban.controller.UserController.*(..)) || "
			+ "execution(* com.yiban.controller.RoleController.create*(..)) ||"
			+ "execution(* com.yiban.controller.RoleController.delete*(..)) ")
	public Object permissionOption(ProceedingJoinPoint joinPoint) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
		
		// 获取token
//		String token = request.getParameter("token");
//		Claims body = JWTUtil.verifyToken(token);
//		System.out.println(body.getSubject());
		
		// 查询用户信息
		int userId = Integer.valueOf(request.getParameter("userId"));
//		int userId = Integer.valueOf(body.getSubject());
		UserService userService = new UserService();
		UserBean user = userService.select(userId);

		// 整理用户权限
		List<RoleBean> roles = user.getRoles();
		List<Integer> permissionIds = new ArrayList<>();
		for (int i = 0; i < roles.size(); i++) {

			RoleBean role = roles.get(i);
			List<PermissionBean> permissions = role.getPermissions();

			for (int j = 0; i < permissions.size(); i++) {
				permissionIds.add(permissions.get(j).getPermissionId());
			}
		}
		
		// 检查权限
		if(permissionIds.contains(5) || permissionIds.contains(6) || 
			permissionIds.contains(7) || permissionIds.contains(8)) {
			// 允许访问接口
			return joinPoint.proceed();
		}
		
		// 禁止访问接口
		return ResultBean.error("权限不足");
	}

}
