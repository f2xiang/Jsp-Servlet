package com.fx.dao.impl;

import java.util.Date;

import com.fx.beans.Check;
import com.fx.dao.CheckDao;

public class CheckDaoImpl implements CheckDao{

	@Override
	public Check addWorkTime(Integer u_id) {
		Date now = new Date();
		String sql = "insert into check values";//TODO
		return null;
	}

}
