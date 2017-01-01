package com.tjrac.dao;

import java.util.List;

import com.tjrac.domain.Order;
import com.tjrac.domain.OrderItem;

public interface OrderDao {

	/**
	 * �ڶ������в����¼
	 * @param order
	 */
	void addOrder(Order order);

	/**
	 * �ڶ�������в�������
	 * @param item
	 */
	void addOrderItem(OrderItem item);

	List<Order> findOrderById(Integer id);

	/**
	 * ��ѯָ�����������е���
	 * @param id
	 * @return
	 */
	List<OrderItem> findOrderItems(String id);

}
