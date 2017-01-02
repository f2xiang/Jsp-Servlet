package com.tjrac.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tjrac.factory.BasicFactory;
import com.tjrac.service.OrderService;

public class DelOrderServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OrderService service = BasicFactory.getFactory().getInstance(OrderService.class);
		
		//��ȡ������id
		String id = request.getParameter("id");
		
		//����service��ɾ�������ķ���
		service.delOrderById(id);
		
		//�ص������б�ҳ��
		request.getRequestDispatcher("OrderListServlet").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
