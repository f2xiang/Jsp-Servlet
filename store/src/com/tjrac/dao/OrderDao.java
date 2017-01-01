package com.tjrac.dao;

import java.util.List;

import com.tjrac.domain.Order;
import com.tjrac.domain.OrderItem;

public interface OrderDao {

	/**
	 * 在订单表中插入记录
	 * @param order
	 */
	void addOrder(Order order);

	/**
	 * 在订单项表中插入数据
	 * @param item
	 */
	void addOrderItem(OrderItem item);

	List<Order> findOrderById(Integer id);

	/**
	 * 查询指定订单的所有单项
	 * @param id
	 * @return
	 */
	List<OrderItem> findOrderItems(String id);

}
