package com.tjrac.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.tjrac.domain.User;
import com.tjrac.util.JDBCUtils;

public class UserDaoImpl implements UserDao{

	@Override
	public User findUserByName(String username) {
		String sql = "select * from users where username = ?";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			return runner.query(sql, new BeanHandler<User>(User.class), username);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public void addUser(User user) {
		String sql = "insert into users values(null,?,?,?,?,?,?,?,null) "; 
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			runner.update(sql,user.getUsername(),user.getPassword(),user.getNickname(),
				user.getEmail(),user.getRole(),user.getState(),user.getActivecode());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public User findUserByUP(String name, String pwd) {
		String sql = "select * from users where username = ? and password = ?";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			return runner.query(sql, new BeanHandler<User>(User.class), name, pwd);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public User findUserById(Integer user_id) {
		String sql = "select * from users where id = ?";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			return runner.query(sql, new BeanHandler<User>(User.class), user_id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
