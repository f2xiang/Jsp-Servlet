package com.fx.service;

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
}
