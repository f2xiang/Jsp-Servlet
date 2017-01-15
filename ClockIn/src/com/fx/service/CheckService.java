package com.fx.service;

import java.util.List;
import java.util.Map;

import com.fx.beans.Check;

public interface CheckService {

	/**
	 * �ϰ�򿨵�ʱ��
	 * @param u_id
	 */
	public void workCard(Check check);
	

	/**
	 * �°��ʱ��
	 * @param 
	 */
	public void homeCard(Check check);

	/**
	 * ��ѯ���еĴ򿨼�¼
	 * @return
	 */
	public List<Map<String, String>> findAll();
	
	/**
	 * ��ѯ����Ĵ򿨼�¼
	 * @return
	 */
	public Check findByChecktime();
	
	/**
	 * ���� �°�Ĵ�  ��һ���򿨼�¼����
	 * @param check
	 */
	public void updateHome(Check check);
	
	
	/**
	 * ����idɾ��һ���򿨼�¼
	 * @param cid
	 */
	public void delByCid(Integer cid);


	/**
	 * ������ѯ
	 * @param time
	 * @return
	 */
	public List<Map<String, String>> findByChecktime(String time);




}
