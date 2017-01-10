package com.fx.service;

import java.util.List;

import com.fx.beans.Question;

public interface QuestionService {
	/**
	 * �����û�id��ȡ�û����õ���������
	 * @param uid
	 * @return
	 */
	public List<Question> findByUid(Integer uid);
	
	/**
	 * ����һ�����밲ȫ����
	 * @param aname
	 * @param qname
	 * @param uid
	 */
	public void insert(String aname, String qname, Integer uid) ;
}
