package com.fx.service;

import java.util.List;
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

	/**
	 * ���һ�����˵���Ϣ
	 * @param person
	 */
	public void addPerson(Person person);
	
	/**
	 * �������ݿ�ĸ�����Ϣ
	 * @param person
	 */
	public void updatePer1(Person person);

	/**
	 * ��������ѯԱ����Ϣ
	 * @param string
	 * @param array
	 * @return
	 */
	public List<Person> findAll(String condition, Object[] array);
}
