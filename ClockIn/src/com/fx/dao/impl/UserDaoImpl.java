package com.fx.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.fx.beans.User;
import com.fx.dao.UserDao;
import com.fx.utils.JDBCUtils;

public class UserDaoImpl implements UserDao{

	@Override
	public User findUserByUP(String name, String pwd) {
		String sql = "select * from user where uname = ? and pwd = ?";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			return runner.query(sql, new BeanHandler<User>(User.class), name, pwd);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public void updatePwd(User user) {
		String sql = "update user set pwd = ? WHERE u_id = ?";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			runner.update(sql, user.getNewPassword(), user.getU_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User findByUname(String uname) {
		String sql = "select * from user where uname = ?";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			return runner.query(sql, new BeanHandler<User>(User.class), uname);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public List<User> findAll() {
		String sql = "select * from user where level = ? ";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			return runner.query(sql, new BeanListHandler<User>(User.class), 2);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	@Override
	public void addUser(String uname, String md5) {
		String sql = "insert into user values(null, ?, ?, ?)";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			runner.update(sql, uname, md5, 2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delStaff(Integer uid) {
		String sql = "delete from user where u_id = ?";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			runner.update(sql, uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public User findByUid(Integer uid) {
		String sql = "select * from user where u_id = ?";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			return runner.query(sql, new BeanHandler<User>(User.class), uid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}



}
