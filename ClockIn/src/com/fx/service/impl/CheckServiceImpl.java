package com.fx.service.impl;

import java.util.List;
import java.util.Map;

import com.fx.beans.Check;
import com.fx.dao.CheckDao;
import com.fx.dao.impl.CheckDaoImpl;
import com.fx.service.CheckService;

public class CheckServiceImpl implements CheckService{
	private CheckDao checkDao = new CheckDaoImpl();

	@Override
	public void workCard(Check check) {
		this.checkDao.addWorkTime(check);
	}

	@Override
	public void homeCard(Check check) {
		this.checkDao.addHomeTime(check);
	}

	@Override
	public List<Map<String, String>> findAll() {
		return this.checkDao.findAll();
	}

	@Override
	public Check findByChecktime() {
		return this.checkDao.findByChecktime();
	}

	@Override
	public void updateHome(Check check) {
		this.checkDao.updateHome(check);
	}

	@Override
	public void delByCid(Integer cid) {
		this.checkDao.delByCid(cid);
		
	}

	@Override
	public List<Map<String, String>> findByChecktime(String time) {
		return this.checkDao.findByChecktime(time);
	}

	
	
	
}
