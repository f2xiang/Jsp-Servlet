package com.tjrac.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tjrac.domain.Order;
import com.tjrac.domain.OrderItem;
import com.tjrac.util.JDBCUtils;

public class OrderDaoImpl implements OrderDao{

	@Override
	public void addOrder(Order order) {
		String sql = "insert into orders values(?, ?, ?, ?, null, ?)";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			runner.update(sql, order.getId(), order.getMoney(), order.getReceiverinfo(),
							   order.getPaystate(), order.getUser_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addOrderItem(OrderItem item) {
		String sql = "insert into orderitem values(?, ?, ?)";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			runner.update(sql, item.getOrder_id(), item.getProduct_id(), item.getBuynum());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Order> findOrderById(Integer id) {
		String sql = "select * from orders where user_id = ?";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			return runner.query(sql, new BeanListHandler<Order>(Order.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public List<OrderItem> findOrderItems(String id) {
		String sql = "select * from orderitem where order_id = ?";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			return runner.query(sql, new BeanListHandler<OrderItem>(OrderItem.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
