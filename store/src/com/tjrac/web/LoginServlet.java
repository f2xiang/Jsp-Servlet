package com.tjrac.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.tjrac.domain.User;
import com.tjrac.factory.BasicFactory;
import com.tjrac.service.UserService;

public class LoginServlet extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		UserService service = BasicFactory.getFactory().getInstance(UserService.class);
		
		//获取用户名 密码 
		String name = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		
		//找到用户
		User user = service.findUserByUP(name, pwd);
		if(user == null){
			req.getSession().setAttribute("msg", "用户名或者密码错误");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		
		//查看用户的激活状态
		if(user.getState() == 0){
			req.getSession().setAttribute("msg", "用户尚未激活 请先去邮箱激活");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		
		req.getSession().setAttribute("user", user);
		resp.sendRedirect(req.getContextPath()+"/index.jsp");
		//重定向到主页
	}

}
