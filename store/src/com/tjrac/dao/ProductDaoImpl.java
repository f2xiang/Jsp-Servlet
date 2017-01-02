package com.tjrac.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tjrac.domain.Product;
import com.tjrac.util.JDBCUtils;

public class ProductDaoImpl implements ProductDao{

	@Override
	public List<Product> findAll() {
		String sql = "select * from products ";
		QueryRunner runner  = new QueryRunner(JDBCUtils.getDataSource());
		try {
			return runner.query(sql, new BeanListHandler<Product>(Product.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	@Override
	public Product findById(String id) {
		String sql = "Select * from products where id = ?";
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			return runner.query(sql, new BeanHandler<Product>(Product.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public void delPnum(String product_id, Integer buynum) {
		String sql = "update products set pnum = pnum - ? where id = ? and pnum - ? >= 0";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			int count = runner.update(sql, buynum, product_id, buynum);
			if(count <= 0){
				throw new RuntimeException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addPnum(String product_id, Integer buynum) {
		String sql = "update products set pnum = pnum + ? where id = ? ";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			runner.update(sql, buynum, product_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
