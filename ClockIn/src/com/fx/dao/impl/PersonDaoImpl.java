package com.fx.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.fx.beans.Person;
import com.fx.dao.PersonDao;
import com.fx.utils.JDBCUtils;

public class PersonDaoImpl implements PersonDao{

	@Override
	public Map<String, String> findByUid(Integer uid) {
		Map<String, String> map = new HashMap<String, String>();
		String sql = "select * from dept,person where dept.d_id = person.d_id and person.u_id = ?";
		try {
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps =  conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs =  ps.executeQuery();
			if(rs.next()){
				map.put("p_id", rs.getString("p_id"));
				map.put("u_id", rs.getString("u_id"));
				map.put("name", rs.getString("name"));
				map.put("dname", rs.getString("dname"));
				map.put("age", rs.getString("age"));
				map.put("sal", rs.getString("sal"));
				map.put("birth", rs.getString("birth"));
				map.put("phone", rs.getString("phone"));
				map.put("address", rs.getString("address"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	
	
	@Override
	public void updatePerson(Person person) {
		java.sql.Date birth =new java.sql.Date(person.getBirth().getTime());
		String sql = "update person set `name` = ? , age = ?, sal = ?, birth = ?, phone = ?, address = ? WHERE p_id = ?";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			runner.update(sql, person.getName(), person.getAge(),
					person.getSal(), birth, person.getPhone(), person.getAddress(), person.getP_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	@Override
	public void addPerson(Person person) {
		java.sql.Date birth =new java.sql.Date(person.getBirth().getTime());
		String sql = "INSERT into person VALUES(null, ?, ?, ?, ?, ?, ?, ?, ? )";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			runner.update(sql, person.getName(), person.getAge(),
					person.getSal(), birth, person.getPhone(), person.getAddress(), 
					person.getU_id(), person.getD_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updatePerson1(Person person) {
		java.sql.Date birth =new java.sql.Date(person.getBirth().getTime());
		String sql = "update person set `name` = ? , age = ?, sal = ?, birth = ?, phone = ?, address = ?, d_id = ? WHERE p_id = ?";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			runner.update(sql, person.getName(), person.getAge(),
					person.getSal(), birth, person.getPhone(), person.getAddress(), person.getD_id(), person.getP_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	@Override
	public List<Person> findAll(String condition, Object[] array) {
		String sql = "select * from person where 1 = 1" + condition;
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			return runner.query(sql, new BeanListHandler<Person>(Person.class), array);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	
}
