package com.tjrac.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.tjrac.domain.User;
import com.tjrac.factory.BasicFactory;
import com.tjrac.service.UserService;

public class RegisterServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService service = BasicFactory.getFactory().getInstance(UserService.class);
		
		try {
			//校验验证码
			String valistr = request.getParameter("valistr");
			String valistr2 = (String) request.getSession().getAttribute("valistr");
			if(valistr == null || valistr2 == null || !valistr.equals(valistr2)){
				request.setAttribute("msg", "验证码不正确");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				return;
			}
			
			//封装数据
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			
			//调用service注册
			service.regist(user);
			
			//注册成功
			response.getWriter().write("注册成功 请到邮箱中进行激活");
			response.setHeader("refresh", "3;url=index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	
	}

}
