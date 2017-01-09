package com.fx.dao;

import java.util.List;

import com.fx.beans.Dept;

public interface DeptDao {

	/**
	 * 向数据库插入一条部门记录
	 * @param dname
	 */
	public void addDept(String dname);

	/**
	 * 查询所有部门
	 * @return
	 */
	public List<Dept> findAll();

	/**
	 * 删除指定部门
	 * @param d_id
	 */
	public void delDept(Integer d_id);

	/**
	 * 修改指定id的部门
	 * @param d_id
	 * @param dname
	 */
	public void updateDept(Integer d_id, String dname);

}
