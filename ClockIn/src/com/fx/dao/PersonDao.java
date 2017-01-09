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
}
