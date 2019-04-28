package org.dreamtech.xiuxian.dao;

import org.apache.ibatis.annotations.Param;
import org.dreamtech.xiuxian.entity.Person;

public interface PersonDao {
	/**
	 * 根据用户名和密码得到用户信息
	 * 
	 * @return 用户
	 */
	Person getPersonByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
