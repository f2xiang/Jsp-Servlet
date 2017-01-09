package com.fx.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.fx.beans.Dept;
import com.fx.dao.DeptDao;
import com.fx.utils.JDBCUtils;



public class DeptDaoImpl implements DeptDao{

	@Override
	public void addDept(String dname) {
		String sql = "insert into dept values(null, ?)";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			runner.update(sql, dname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Dept> findAll() {
		String sql = "select * from dept";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			return runner.query(sql, new BeanListHandler<Dept>(Dept.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public void delDept(Integer d_id) {
		String sql = "delete from dept where d_id = ?";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			runner.update(sql, d_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateDept(Integer d_id, String dname) {
		String sql = "update dept set dname = ? where d_id = ?";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			runner.update(sql, dname, d_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
