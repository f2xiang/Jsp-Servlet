package com.tjrac.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tjrac.domain.Product;

public class ClearCarServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		Map<Product,Integer> carmap = (Map<Product, Integer>) request.getSession().getAttribute("carmap");
		carmap.clear();
		
		//重定向到购物车页面进行展示
		response.sendRedirect(request.getContextPath()+"/car.jsp");
		
	}

}
