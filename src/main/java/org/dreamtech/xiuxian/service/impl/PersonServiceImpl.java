package org.dreamtech.xiuxian.service.impl;

import org.dreamtech.xiuxian.dao.PersonDao;
import org.dreamtech.xiuxian.entity.Person;
import org.dreamtech.xiuxian.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonDao personDao;

	@Override
	public Person getPersonByUsernameAndPassword(String username, String password) {
		if (username != null && !username.equals("")) {
			username = username.replace(" ", "");
		} else {
			throw new RuntimeException("username is null");
		}
		if (password != null && !password.equals("")) {
			password = password.replace(" ", "");
		} else {
			throw new RuntimeException("password is null");
		}
		Person person = null;
		try {
			person = personDao.getPersonByUsernameAndPassword(username, password);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error:PersonDao.getPersonByUsernameAndPassword");
		}
		return person;
	}

}
