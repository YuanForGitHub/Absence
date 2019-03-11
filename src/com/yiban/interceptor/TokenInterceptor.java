package com.yiban.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yiban.util.JWTUtil;

public class TokenInterceptor implements HandlerInterceptor {

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
		// 获取我们请求头中的token验证字符
		String headerToken = request.getHeader("token");

		// getParameter的变量是放在我们请求附带的对象中的字符串,例如post方法中附带的account变量等。
		String tokenStr = request.getParameter("token");

		if (headerToken == null && tokenStr == null) {
			// 如果token不存在的话,我们重定向 到登录页面去
			response.sendRedirect("http://baidu.com");
			// 当返回值是false的时候,表示拦截器不会进行处理了,我们调用response来进行响应。
			return false;
		}

		if (tokenStr != null) {
			// 进行token同步,后面我们会对token做验证与更新
			headerToken = tokenStr;
		}
		
		try {
			// 更新和验证token
			headerToken = JWTUtil.updateToken(headerToken);
		} catch (Exception e) {
			// 当token验证出现问题时，返回登录页面
			response.sendRedirect("http://baidu.com");
			return false;
		}
		System.out.println("real token:=="+headerToken);
        System.out.println("real Cookie:=="+request.getHeader("Cookie"));
		
		return false;
	}

}
