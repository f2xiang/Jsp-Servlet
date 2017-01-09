package com.fx.service;

import java.util.List;

import com.fx.beans.Dept;

public interface DeptService {

	/**
	 * 添加一个部门
	 * @param dname
	 */
	public void addDept(String dname);

	/**
	 * 查询所有的部门
	 * @return
	 */
	public List<Dept> findAll();

	/**
	 * 删除指定部门
	 * @param d_id
	 */
	public void delDept(Integer d_id);

	/**
	 * 修改部门的信息
	 * @param d_id
	 * @param dname
	 */
	public void updateDept(Integer d_id, String dname);

}
