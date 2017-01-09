package com.fx.service.impl;

import java.util.List;

import com.fx.beans.Dept;
import com.fx.dao.DeptDao;
import com.fx.dao.impl.DeptDaoImpl;
import com.fx.service.DeptService;

public class DeptServiceImpl implements DeptService{

	private DeptDao deptDao = new DeptDaoImpl();
	
	@Override
	public void addDept(String dname) {
		this.deptDao.addDept(dname);
	}

	@Override
	public List<Dept> findAll() {
		return this.deptDao.findAll();
	}

	@Override
	public void delDept(Integer d_id) {
		this.deptDao.delDept(d_id);
	}

	@Override
	public void updateDept(Integer d_id, String dname) {
		this.deptDao.updateDept(d_id, dname);
	}

}
