package com.fx.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.fx.beans.Question;
import com.fx.dao.QuestionDao;
import com.fx.utils.JDBCUtils;

public class QuestionDaoImpl implements QuestionDao{

	@Override
	public List<Question> findBuUid(Integer uid) {
		String sql = "select * from question where u_id = ?";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			return runner.query(sql, new BeanListHandler<Question>(Question.class), uid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public void insert(String aname, String qname, Integer uid) {
		String sql = "insert into question values(null, ?, ?, ?)";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			runner.update(sql, qname, aname, uid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
