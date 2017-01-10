package com.fx.test;

import java.util.List;

import org.junit.Test;

import com.fx.beans.Person;
import com.fx.dao.PersonDao;
import com.fx.dao.impl.PersonDaoImpl;

public class Demo {
	@Test
	public void demo(){
		PersonDao personDao = new PersonDaoImpl();
		List<Person> list = personDao.findAll(" and name like ? and d_id = ?", new Object[] {"%Οι%", 3});
		System.out.println(list);
		
	}
}
