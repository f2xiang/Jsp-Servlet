package com.tjrac.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tjrac.domain.Product;
import com.tjrac.factory.BasicFactory;
import com.tjrac.service.ProductService;

public class DelCarServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductService service = BasicFactory.getFactory().getInstance(ProductService.class);
		
		//��ȡҪɾ������Ʒ��id������id������Ʒ
		String id = request.getParameter("id");
		Product prod = service.findById(id);
		
		//��ȡ���ﳵ ɾ�������Ʒ
		Map<Product,Integer> carmap = (Map<Product, Integer>) request.getSession().getAttribute("carmap");
		carmap.remove(prod);
		
		//�ض���ص����ﳵ
		response.sendRedirect(request.getContextPath()+"/car.jsp");
		
	}

}
