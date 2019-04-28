package org.dreamtech.xiuxian.service;

import org.dreamtech.xiuxian.entity.Person;
import org.dreamtech.xiuxian.entity.State;

/**
 * 首页服务层
 * 
 * @author Xu Yiqing
 *
 */
public interface HomeService {
	/**
	 * 根据境界ID获得初始化信息
	 * 
	 * @param stateId 境界ID
	 * @return 境界信息
	 */
	State getInitInfoByStateId(String stateId);

	/**
	 * 每3秒进行一次经验保存
	 * 
	 * @param userId
	 * @param exp
	 * @return
	 */
	int saveExpChange(String userId, String exp);

	/**
	 * 突破
	 * 
	 * @param user 用户
	 * @return 返回信息
	 */
	int breakState(Person user);

	/**
	 * 根据用户ID得到用户信息
	 * 
	 * @param userId 用户ID
	 * @return 用户信息
	 */
	Person getUserById(String userId);
}
