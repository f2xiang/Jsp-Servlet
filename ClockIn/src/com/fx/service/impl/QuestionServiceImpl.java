package com.fx.service.impl;

import java.util.List;

import com.fx.beans.Question;
import com.fx.dao.QuestionDao;
import com.fx.dao.impl.QuestionDaoImpl;
import com.fx.service.QuestionService;

public class QuestionServiceImpl implements QuestionService{

	private QuestionDao questionDao = new QuestionDaoImpl();
	
	@Override
	public List<Question> findByUid(Integer uid) {
		return this.questionDao.findBuUid(uid);
	}

	@Override
	public void insert(String aname, String qname, Integer uid) {
		this.questionDao.insert(aname, qname, uid);
	}

}
