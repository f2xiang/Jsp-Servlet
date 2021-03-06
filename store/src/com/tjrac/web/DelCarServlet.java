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
		
		//获取要删除的商品的id，根据id查找商品
		String id = request.getParameter("id");
		Product prod = service.findById(id);
		
		//获取购物车 删除这个商品
		Map<Product,Integer> carmap = (Map<Product, Integer>) request.getSession().getAttribute("carmap");
		carmap.remove(prod);
		
		//重定向回到购物车
		response.sendRedirect(request.getContextPath()+"/car.jsp");
		
	}

}
