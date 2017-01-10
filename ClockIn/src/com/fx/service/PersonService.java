package com.fx.service;

import java.util.List;
import java.util.Map;

import com.fx.beans.Person;

public interface PersonService {
	/**
	 * 根据userid查询部门和个人信息
	 * @param uid
	 * @return
	 */
	public Map<String, String> findByUid(Integer uid);

	/**
	 * 更新数据库的个人信息
	 * @param person
	 */
	public void updatePer(Person person);

	/**
	 * 添加一条个人的信息
	 * @param person
	 */
	public void addPerson(Person person);
	
	/**
	 * 更新数据库的个人信息
	 * @param person
	 */
	public void updatePer1(Person person);

	/**
	 * 多条件查询员工信息
	 * @param string
	 * @param array
	 * @return
	 */
	public List<Person> findAll(String condition, Object[] array);
}
