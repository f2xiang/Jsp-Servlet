package com.tjrac.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tjrac.domain.OrderListForm;
import com.tjrac.domain.User;
import com.tjrac.factory.BasicFactory;
import com.tjrac.service.OrderService;

public class OrderListServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		OrderService service = BasicFactory.getFactory().getInstance(OrderService.class);
		
		//��ȡ�û�id
		User user = (User) request.getSession().getAttribute("user");
		Integer id = user.getId();
		
		//����service�и���id��ѯ�û����еĶ����ķ���
		List<OrderListForm> list = service.findOrdesById(id);
		request.setAttribute("list", list);
		
		//����request ����ҳ�����չʾ
		request.getRequestDispatcher("orderList.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
