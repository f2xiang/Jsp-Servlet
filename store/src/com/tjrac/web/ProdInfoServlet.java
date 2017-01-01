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
				
				//拿到要查询的商品的id
				String id = request.getParameter("id");
				
				//根据id，用service查询商品
				ProductService  service = BasicFactory.getFactory().getInstance(ProductService.class);
				Product prod = service.findById(id);
				
				//把商品带到页面展示
				if(prod == null){
					throw new RuntimeException("没有这个商品");
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
