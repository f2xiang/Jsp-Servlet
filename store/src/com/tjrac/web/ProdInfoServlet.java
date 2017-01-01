package com.tjrac.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tjrac.domain.Product;
import com.tjrac.factory.BasicFactory;
import com.tjrac.service.ProductService;

public class ProdInfoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
				//�õ�Ҫ��ѯ����Ʒ��id
				String id = request.getParameter("id");
				
				//����id����service��ѯ��Ʒ
				ProductService  service = BasicFactory.getFactory().getInstance(ProductService.class);
				Product prod = service.findById(id);
				
				//����Ʒ����ҳ��չʾ
				if(prod == null){
					throw new RuntimeException("û�������Ʒ");
				}else{
					request.setAttribute("prod", prod);
					request.getRequestDispatcher("/prodInfo.jsp").forward(request, response);
				}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
