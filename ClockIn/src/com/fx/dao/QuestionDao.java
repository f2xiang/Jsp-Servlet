package com.fx.dao;

import java.util.List;

import com.fx.beans.Question;

public interface QuestionDao {
	/**
	 * �����û�id��ѯ����
	 * @param uid
	 * @return
	 */
	public List<Question> findBuUid(Integer uid);
	
	/**
	 * ����һ����������
	 * @param question
	 */
	public void insert(String aname, String qname, Integer uid);
}
