package com.fx.service.impl;

import java.util.List;
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

	@Override
	public void addPerson(Person person) {
		this.personDao.addPerson(person);
	}

	@Override
	public void updatePer1(Person person) {
		this.personDao.updatePerson1(person);
	}

	@Override
	public List<Person> findAll(String condition, Object[] array) {
		return this.personDao.findAll(condition, array);
	}
	
	
}
