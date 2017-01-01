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
			//У����֤��
			String valistr = request.getParameter("valistr");
			String valistr2 = (String) request.getSession().getAttribute("valistr");
			if(valistr == null || valistr2 == null || !valistr.equals(valistr2)){
				request.setAttribute("msg", "��֤�벻��ȷ");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				return;
			}
			
			//��װ����
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			
			//����serviceע��
			service.regist(user);
			
			//ע��ɹ�
			response.getWriter().write("ע��ɹ� �뵽�����н��м���");
			response.setHeader("refresh", "3;url=index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	
	}

}
