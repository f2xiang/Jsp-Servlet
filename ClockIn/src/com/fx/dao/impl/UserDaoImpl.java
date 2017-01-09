package com.fx.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

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

}
