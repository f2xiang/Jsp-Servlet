package com.tjrac.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.tjrac.dao.OrderDao;
import com.tjrac.dao.ProductDao;
import com.tjrac.dao.UserDao;
import com.tjrac.domain.Order;
import com.tjrac.domain.OrderItem;
import com.tjrac.domain.OrderListForm;
import com.tjrac.domain.Product;
import com.tjrac.domain.User;
import com.tjrac.factory.BasicFactory;

public class OrderServiceImpl implements OrderService{

	private OrderDao orderDao = BasicFactory.getFactory().getInstance(OrderDao.class);
	private ProductDao prodDao = BasicFactory.getFactory().getInstance(ProductDao.class);
	private UserDao userDao = BasicFactory.getFactory().getInstance(UserDao.class);
	
	@Override
	public void addOrder(Order order) {
		
		
		//生成订单
		orderDao.addOrder(order);
		
		//生成订单明细，扣除商品数量
		for(OrderItem item : order.getList()){
			orderDao.addOrderItem(item);
			prodDao.delPnum(item.getProduct_id(), item.getBuynum());
		}
		
		
	}

	@Override
	public List<OrderListForm> findOrdesById(Integer id) {
		
		//根据用户id查询这个用户的所有订单
		try {
			List<Order> list =  orderDao.findOrderById(id);
			List<OrderListForm> olfList = new ArrayList<OrderListForm>();
			
			for(Order order : list){
				//遍历 生成对象 存入 list				
				OrderListForm olf = new OrderListForm();
				BeanUtils.copyProperties(olf, order);
				
				//设置用户名
				User user = userDao.findUserById(olf.getUser_id());
				olf.setUsername(user.getUsername());
				
				//设置商品信息
				List<OrderItem> itemList = orderDao.findOrderItems(order.getId());
				Map<Product, Integer> prodMap = new HashMap<Product, Integer>();
				for(OrderItem item : itemList){
					String prod_id = item.getProduct_id();
					Product prod = prodDao.findById(prod_id);
					prodMap.put(prod, item.getBuynum());
				}
				olf.setProdMap(prodMap);
				
				olfList.add(olf);
			}
			return olfList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		
	}

	@Override
	public void delOrderById(String id) {
		//根据id查询所有订单项
		List<OrderItem> list =  orderDao.findOrderItems(id);
		
		//遍历订单项  将对应的商品id的库存加回去
		for(OrderItem item : list){
			prodDao.addPnum(item.getProduct_id(), item.getBuynum());
		}
		
		//删除订单项
		orderDao.delOrderItem(id);
		
		//删除订单
		orderDao.delOrder(id);
	}

	@Override
	public Order findOrderById(String p2_Order) {
		return orderDao.findById(p2_Order);
	}

	@Override
	public void changePayState(String r6_Order, int i) {
		orderDao.changePayState(r6_Order, i);
	}

}
