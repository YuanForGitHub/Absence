package com.yiban.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yiban.bean.ApplyBean;
import com.yiban.service.ApplyService;

/**
 * 鐢宠杞彂
 */
@WebServlet("/ApplyServlet")
public class ApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApplyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
/*		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		
		ApplyBean apply = new ApplyBean();
		apply.setActivity(request.getParameter("activity"));
		apply.setDepartment(request.getParameter("department"));
		apply.setJob(request.getParameter("job"));
		apply.setName(request.getParameter("name"));
		apply.setStartTime(request.getParameter("startTime"));
		apply.setEndTime(request.getParameter("endTime"));
		apply.setReason(request.getParameter("reason"));
		apply.setOther(request.getParameter("other"));

		ApplyService applyService = new ApplyService();
		out = response.getWriter();
		out.append((applyService.insert(apply)?"true":"false"));*/
		
//		页面跳转
//		request.getRequestDispatcher("WEB-INF/jsp/back/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
