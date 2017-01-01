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
		
		//根据id查找要购买的商品
		String id = request.getParameter("id");
		Product prod = service.findById(id);
		//向carmap中添加商品，如果已经买过这个商品了，在原有的数量上添加。
		if(prod == null){
			throw new RuntimeException("没有这个商品");
		}else{
			Map<Product,Integer> carmap = (Map<Product, Integer>) request.getSession().getAttribute("carmap");
			carmap.put(prod, carmap.containsKey(prod)? carmap.get(prod)+1 : 1);
		}
		
		//重定向到购物车页面进行展示
		response.sendRedirect(request.getContextPath()+"/car.jsp");
		
	}

}
