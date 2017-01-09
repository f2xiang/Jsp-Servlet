package com.fx.web.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fx.beans.User;
import com.fx.service.CheckService;
import com.fx.service.impl.CheckServiceImpl;

public class CheckServlet extends HttpServlet {
	
	private CheckService checkService = new CheckServiceImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer cid = Integer.valueOf(request.getParameter("cid"));
		
		switch (cid) {
		case 1:
			this.work(request, response);
			break;

		case 2:
			this.home(request, response);
			break;
		default:
			break;
		}
	}
	
	/**
	 * 上班打卡
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void work(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//点击上班打卡 往数据库插入一条当前的时间
		User user =  (User) request.getSession().getAttribute("user");
		this.checkService.workCard(user.getU_id());
		
	}
	
	
	/**
	 * 下班打卡
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void home(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
