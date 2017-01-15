package com.fx.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fx.beans.Check;

public interface CheckDao {

	/**
	 * ����һ���򿨵ļ�¼
	 * @param u_id
	 * @return
	 */
	public void addWorkTime(Check check);
	
	/**
	 * ����һ���򿨵ļ�¼
	 * @param u_id
	 * @return
	 */
	public void addHomeTime(Check check);
	
	/**
	 * ��ѯ���д򿨼�¼
	 * @return
	 */
	public List<Map<String, String>> findAll();
	
	/**
	 * ��ѯָ���û��Ĵ򿨼�¼
	 * @param uid
	 * @return
	 */
	public List<Check> findByUid(Integer uid);

	
	/**
	 * ɾ��ָ��id������
	 * @param cid
	 */
	public void delByCid(Integer cid);
	
	/**
	 * ��ѯ����Ĵ򿨼�¼
	 * @return
	 */
	public Check findByChecktime();
	
	
	
	public void updateHome(Check check);

	public List<Map<String, String>> findByChecktime(String time);

	
}
