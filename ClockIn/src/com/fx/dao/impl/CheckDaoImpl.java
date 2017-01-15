package com.fx.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.fx.beans.Check;
import com.fx.beans.User;
import com.fx.dao.CheckDao;
import com.fx.utils.JDBCUtils;

public class CheckDaoImpl implements CheckDao{

	@Override
	public void addWorkTime(Check check) {
		//打卡日期
		java.sql.Date checkdate =new java.sql.Date(new Date().getTime());
		
		Timestamp s = Timestamp.valueOf(check.getWorktime());
		String sql = "insert into check1(worktime, worktype, u_id, checkdate) values(?, ?, ?, ?)";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			runner.update(sql, s, check.getWorktype(), check.getU_id(), checkdate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public List<Map<String, String>> findAll() {
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		String sql = "select * from check1, user where check1.u_id = `user`.u_id ";
		
		try {
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps =  conn.prepareStatement(sql);
			ResultSet rs =  ps.executeQuery();
			Map<String, String> map = null;
			while(rs.next()){
				map = new HashMap<String, String>();
				map.put("c_id", rs.getString("c_id"));
				map.put("worktime", rs.getString("worktime"));
				map.put("hometime", rs.getString("hometime"));
				map.put("worktype", rs.getString("worktype"));
				map.put("hometype", rs.getString("hometype"));
				map.put("u_id", rs.getString("u_id"));
				map.put("uname", rs.getString("uname"));
				list.add(map);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}


	@Override
	public List<Check> findByUid(Integer uid) {
		String sql = "select * from check1 where u_id = ?";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			return runner.query(sql, new BeanListHandler<Check>(Check.class), uid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}


	@Override
	public void delByCid(Integer cid) {
		String sql = "delete from check1 where c_id = ?";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			runner.update(sql, cid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public Check findByChecktime() {
		String sql = "select * from check1 where checkdate = ?";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			return runner.query(sql, new BeanHandler<Check>(Check.class), new java.sql.Date(new Date().getTime()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	@Override
	public void addHomeTime(Check check) {
		//打卡日期
		java.sql.Date checkdate =new java.sql.Date(new Date().getTime());
		
		Timestamp s = Timestamp.valueOf( check.getHometime());
		String sql = "insert into check1(hometime, hometype, u_id, checkdate) values(?, ?, ?, ?)";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			runner.update(sql, s, check.getWorktype(), check.getU_id(), checkdate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void updateHome(Check check) {
		Timestamp s = Timestamp.valueOf( check.getHometime());
		String sql = "update check1 set hometime = ?, hometype = ? where c_id = ?";
		try {
			QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
			runner.update(sql, s, check.getHometype(), check.getC_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public List<Map<String, String>> findByChecktime(String time) {
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		String sql = "select * from check1, user where check1.u_id = `user`.u_id and checkdate = ?";
		
		try {
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps =  conn.prepareStatement(sql);
			ps.setString(1, time);
			ResultSet rs =  ps.executeQuery();
			Map<String, String> map = null;
			while(rs.next()){
				map = new HashMap<String, String>();
				map.put("c_id", rs.getString("c_id"));
				map.put("worktime", rs.getString("worktime"));
				map.put("hometime", rs.getString("hometime"));
				map.put("worktype", rs.getString("worktype"));
				map.put("hometype", rs.getString("hometype"));
				map.put("u_id", rs.getString("u_id"));
				map.put("uname", rs.getString("uname"));
				list.add(map);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}



	
	

}
