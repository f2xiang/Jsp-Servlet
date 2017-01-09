package com.fx.dao;

import java.util.List;

import com.fx.beans.Dept;

public interface DeptDao {

	/**
	 * �����ݿ����һ�����ż�¼
	 * @param dname
	 */
	public void addDept(String dname);

	/**
	 * ��ѯ���в���
	 * @return
	 */
	public List<Dept> findAll();

	/**
	 * ɾ��ָ������
	 * @param d_id
	 */
	public void delDept(Integer d_id);

	/**
	 * �޸�ָ��id�Ĳ���
	 * @param d_id
	 * @param dname
	 */
	public void updateDept(Integer d_id, String dname);

}
