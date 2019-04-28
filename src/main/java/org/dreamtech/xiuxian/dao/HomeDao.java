package org.dreamtech.xiuxian.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.dreamtech.xiuxian.entity.Person;
import org.dreamtech.xiuxian.entity.State;

/**
 * 主页Dao层
 * 
 * @author Xu Yiqing
 *
 */
public interface HomeDao {
	/**
	 * 根据用户的stateID查询对应境界信息
	 * 
	 * @param stateId 用户的stateID
	 * @return 境界信息
	 */
	State getInitInfoByStateId(String stateId);

	/**
	 * 获取所有境界信息
	 * 
	 * @return 境界信息列表
	 */
	List<State> getStateList();

	/**
	 * 自动存储经验值
	 * 
	 * @param userId 用户ID
	 * @param exp    存储的经验值
	 * @return 影响的行数
	 */
	int saveExpChange(@Param("userId") String userId, @Param("exp") String exp);

	/**
	 * 突破当前境界
	 * 
	 * @param userId     用户ID
	 * @param newStateId 突破后的境界ID
	 * @return 影响的行数
	 */
	int breakState(@Param("userId") String userId, @Param("stateId") String stateId);

	/**
	 * 根据用户ID获得用户信息
	 * 
	 * @param userId 用户ID
	 * @return 用户对象
	 */
	Person getUserById(String userId);
}
