package com.fx.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;

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
	
}
