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
		
		//��ȡ�û��� ���� 
		String name = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		
		//�ҵ��û�
		User user = service.findUserByUP(name, pwd);
		if(user == null){
			req.getSession().setAttribute("msg", "�û��������������");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		
		//�鿴�û��ļ���״̬
		if(user.getState() == 0){
			req.getSession().setAttribute("msg", "�û���δ���� ����ȥ���伤��");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		
		req.getSession().setAttribute("user", user);
		resp.sendRedirect(req.getContextPath()+"/index.jsp");
		//�ض�����ҳ
	}

}
