package com.tjrac.service;

import java.util.List;

import com.tjrac.domain.Order;
import com.tjrac.domain.OrderListForm;

public interface OrderService {

	/**
	 * ���Ӷ����ķ���
	 * @param order
	 */
	void addOrder(Order order);

	/**
	 * ��ѯָ���ͻ��ĵĶ���
	 * @param id
	 */
	List<OrderListForm> findOrdesById(Integer id);

}
