package com.tjrac.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.tjrac.domain.Order;
import com.tjrac.domain.OrderItem;
import com.tjrac.domain.Product;
import com.tjrac.domain.User;
import com.tjrac.factory.BasicFactory;
import com.tjrac.service.OrderService;

public class AddOrderServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			Order order = new Order();
			
			//订单编号
			order.setId(UUID.randomUUID().toString());
			
			//支付状态
			order.setPaystate(0);
			
			//把订单信息存入order中(封装前台的地址信息到bean )
			BeanUtils.populate(order, request.getParameterMap());
			
			//前台的价格不能信 所以要重新遍历map购物车  把价格计算出来
			Map<Product,Integer> carmap = (Map<Product, Integer>) request.getSession().getAttribute("carmap");
			double money = 0;
			List<OrderItem> list = new ArrayList<OrderItem>();
			for(Map.Entry<Product, Integer> entry: carmap.entrySet()){
				//计算总价
				money += entry.getKey().getPrice() * entry.getValue();
				
				//生成订单明细项
				OrderItem item = new OrderItem();
				item.setOrder_id(order.getId());
				item.setProduct_id(entry.getKey().getId());
				item.setBuynum(entry.getValue());
				list.add(item);
			}
			order.setMoney(money);
			order.setList(list);
			
			//获取u_id
			User user = (User) request.getSession().getAttribute("user");
			order.setUser_id(user.getId());
			
			//将订单项明细信息存入order中(有几条购物记录 就有几个Item) --在上面遍历的时候直接存了
			
			
			
			//调用service添加订单的方法
			OrderService service = BasicFactory.getFactory().getInstance(OrderService.class);
			service.addOrder(order);
			
			//清空购物车
			carmap.clear();
			
			//重定向回到主页
			response.sendRedirect("#");//支付页面
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		
		
	}

}
