package com.fx.service.impl;

import java.util.Map;

import com.fx.beans.Person;
import com.fx.dao.PersonDao;
import com.fx.dao.impl.PersonDaoImpl;
import com.fx.service.PersonService;

public class PersonServiceImpl implements PersonService{
	private PersonDao personDao = new PersonDaoImpl();

	@Override
	public Map<String, String> findByUid(Integer uid) {
		return this.personDao.findByUid(uid);
	}

	@Override
	public void updatePer(Person person) {
		this.personDao.updatePerson(person);
	}
	
	
}
