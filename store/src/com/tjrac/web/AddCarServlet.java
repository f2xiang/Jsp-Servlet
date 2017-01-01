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

public class AddCarServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductService service = BasicFactory.getFactory().getInstance(ProductService.class);
		
		//����id����Ҫ�������Ʒ
		String id = request.getParameter("id");
		Product prod = service.findById(id);
		//��carmap�������Ʒ������Ѿ���������Ʒ�ˣ���ԭ�е���������ӡ�
		if(prod == null){
			throw new RuntimeException("û�������Ʒ");
		}else{
			Map<Product,Integer> carmap = (Map<Product, Integer>) request.getSession().getAttribute("carmap");
			carmap.put(prod, carmap.containsKey(prod)? carmap.get(prod)+1 : 1);
		}
		
		//�ض��򵽹��ﳵҳ�����չʾ
		response.sendRedirect(request.getContextPath()+"/car.jsp");
		
	}

}
