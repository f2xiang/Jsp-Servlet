package com.fx.service;

import java.util.Map;

import com.fx.beans.Person;

public interface PersonService {
	/**
	 * ����userid��ѯ���ź͸�����Ϣ
	 * @param uid
	 * @return
	 */
	public Map<String, String> findByUid(Integer uid);

	/**
	 * �������ݿ�ĸ�����Ϣ
	 * @param person
	 */
	public void updatePer(Person person);
}
