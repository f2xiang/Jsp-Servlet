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
			
			//�������
			order.setId(UUID.randomUUID().toString());
			
			//֧��״̬
			order.setPaystate(0);
			
			//�Ѷ�����Ϣ����order��(��װǰ̨�ĵ�ַ��Ϣ��bean )
			BeanUtils.populate(order, request.getParameterMap());
			
			//ǰ̨�ļ۸����� ����Ҫ���±���map���ﳵ  �Ѽ۸�������
			Map<Product,Integer> carmap = (Map<Product, Integer>) request.getSession().getAttribute("carmap");
			double money = 0;
			List<OrderItem> list = new ArrayList<OrderItem>();
			for(Map.Entry<Product, Integer> entry: carmap.entrySet()){
				//�����ܼ�
				money += entry.getKey().getPrice() * entry.getValue();
				
				//���ɶ�����ϸ��
				OrderItem item = new OrderItem();
				item.setOrder_id(order.getId());
				item.setProduct_id(entry.getKey().getId());
				item.setBuynum(entry.getValue());
				list.add(item);
			}
			order.setMoney(money);
			order.setList(list);
			
			//��ȡu_id
			User user = (User) request.getSession().getAttribute("user");
			order.setUser_id(user.getId());
			
			//����������ϸ��Ϣ����order��(�м��������¼ ���м���Item) --�����������ʱ��ֱ�Ӵ���
			
			
			
			//����service��Ӷ����ķ���
			OrderService service = BasicFactory.getFactory().getInstance(OrderService.class);
			service.addOrder(order);
			
			//��չ��ﳵ
			carmap.clear();
			
			//�ض���ص���ҳ
			response.sendRedirect("#");//֧��ҳ��
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		
		
	}

}
