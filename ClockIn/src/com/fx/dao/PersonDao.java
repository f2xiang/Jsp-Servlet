package com.fx.dao;

import java.util.List;
import java.util.Map;

import com.fx.beans.Person;

public interface PersonDao {
	/**
	 * 根据用户id查找个人信息
	 * @param uid
	 * @return
	 */
	public Map<String, String> findByUid(Integer uid);

	/**
	 * 跟新个人信息
	 * @param person
	 */
	public void updatePerson(Person person);

	/**
	 * 添加一条个人信息
	 * @param person
	 */
	public void addPerson(Person person);
	
	/**
	 * 管理员更新员工信息
	 * @param person
	 */
	public void updatePerson1(Person person);

	/**
	 * 多条件查询
	 * @param condition
	 * @param array
	 * @return
	 */
	public List<Person> findAll(String condition, Object[] array);
}
