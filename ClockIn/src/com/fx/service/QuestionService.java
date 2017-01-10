package com.fx.service;

import java.util.List;

import com.fx.beans.Question;

public interface QuestionService {
	/**
	 * 根据用户id获取用户设置的密码问题
	 * @param uid
	 * @return
	 */
	public List<Question> findByUid(Integer uid);
	
	/**
	 * 插入一条密码安全问题
	 * @param aname
	 * @param qname
	 * @param uid
	 */
	public void insert(String aname, String qname, Integer uid) ;
}
