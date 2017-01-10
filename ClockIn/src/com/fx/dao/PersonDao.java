package com.fx.dao;

import java.util.List;
import java.util.Map;

import com.fx.beans.Person;

public interface PersonDao {
	/**
	 * �����û�id���Ҹ�����Ϣ
	 * @param uid
	 * @return
	 */
	public Map<String, String> findByUid(Integer uid);

	/**
	 * ���¸�����Ϣ
	 * @param person
	 */
	public void updatePerson(Person person);

	/**
	 * ���һ��������Ϣ
	 * @param person
	 */
	public void addPerson(Person person);
	
	/**
	 * ����Ա����Ա����Ϣ
	 * @param person
	 */
	public void updatePerson1(Person person);

	/**
	 * ��������ѯ
	 * @param condition
	 * @param array
	 * @return
	 */
	public List<Person> findAll(String condition, Object[] array);
}
