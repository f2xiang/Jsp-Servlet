package com.tjrac.service;

import java.util.List;

import com.tjrac.domain.Order;
import com.tjrac.domain.OrderListForm;

public interface OrderService {

	/**
	 * 增加订单的方法
	 * @param order
	 */
	void addOrder(Order order);

	/**
	 * 查询指定客户的的订单
	 * @param id
	 */
	List<OrderListForm> findOrdesById(Integer id);

}
