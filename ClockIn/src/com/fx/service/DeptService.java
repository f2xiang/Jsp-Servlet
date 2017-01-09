package com.fx.service;

import java.util.List;

import com.fx.beans.Dept;

public interface DeptService {

	/**
	 * ���һ������
	 * @param dname
	 */
	public void addDept(String dname);

	/**
	 * ��ѯ���еĲ���
	 * @return
	 */
	public List<Dept> findAll();

	/**
	 * ɾ��ָ������
	 * @param d_id
	 */
	public void delDept(Integer d_id);

	/**
	 * �޸Ĳ��ŵ���Ϣ
	 * @param d_id
	 * @param dname
	 */
	public void updateDept(Integer d_id, String dname);

}
