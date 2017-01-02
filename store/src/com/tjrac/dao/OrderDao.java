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

	/**
	 * 删除指定订单id关联的所有订单项
	 * @param id
	 */
	void delOrderItem(String id);

	/**
	 * 删除指定id的订单
	 * @param id
	 */
	void delOrder(String id);

	/**
	 * 根据id查找订单
	 * @param p2_Order
	 * @return
	 */
	Order findById(String p2_Order);

	/**
	 * 修改订单的支付状态
	 * @param r6_Order
	 * @param i
	 */
	void changePayState(String r6_Order, int i);

}
