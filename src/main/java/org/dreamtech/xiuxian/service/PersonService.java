package org.dreamtech.xiuxian.service;

import org.dreamtech.xiuxian.entity.Person;

public interface PersonService {
	/**
	 * 根据用户名和密码得到用户信息
	 * 
	 * @return 用户
	 */
	Person getPersonByUsernameAndPassword(String username, String password);
}
