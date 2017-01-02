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

	/**
	 * ���ݶ������ɾ������
	 * @param id
	 */
	void delOrderById(String id);

	/**
	 * ���ݶ�����id��ѯ����
	 * @param p2_Order
	 * @return
	 */
	Order findOrderById(String p2_Order);

	/**
	 * �޸�ָ��������֧��״̬
	 * @param r6_Order
	 * @param i
	 */
	void changePayState(String r6_Order, int i);

}
