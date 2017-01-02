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

	/**
	 * ɾ��ָ������id���������ж�����
	 * @param id
	 */
	void delOrderItem(String id);

	/**
	 * ɾ��ָ��id�Ķ���
	 * @param id
	 */
	void delOrder(String id);

	/**
	 * ����id���Ҷ���
	 * @param p2_Order
	 * @return
	 */
	Order findById(String p2_Order);

	/**
	 * �޸Ķ�����֧��״̬
	 * @param r6_Order
	 * @param i
	 */
	void changePayState(String r6_Order, int i);

}
