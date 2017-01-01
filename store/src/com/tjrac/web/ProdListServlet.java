package com.tjrac.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tjrac.domain.Product;
import com.tjrac.factory.BasicFactory;
import com.tjrac.service.ProductService;

public class ProdListServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductService service = BasicFactory.getFactory().getInstance(ProductService.class);
		//调用service查询所有的商品
		List<Product> allProducts = service.findAll();
		
		//将商品带到页面展示
		request.setAttribute("allProducts", allProducts);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
