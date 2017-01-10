package com.fx.dao;

import java.util.List;

import com.fx.beans.Question;

public interface QuestionDao {
	/**
	 * 根据用户id查询问题
	 * @param uid
	 * @return
	 */
	public List<Question> findBuUid(Integer uid);
	
	/**
	 * 插入一条密码问题
	 * @param question
	 */
	public void insert(String aname, String qname, Integer uid);
}
