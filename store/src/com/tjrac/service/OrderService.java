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

	/**
	 * 根据订单编号删除订单
	 * @param id
	 */
	void delOrderById(String id);

	/**
	 * 根据订单的id查询订单
	 * @param p2_Order
	 * @return
	 */
	Order findOrderById(String p2_Order);

	/**
	 * 修改指定订单的支付状态
	 * @param r6_Order
	 * @param i
	 */
	void changePayState(String r6_Order, int i);

}
