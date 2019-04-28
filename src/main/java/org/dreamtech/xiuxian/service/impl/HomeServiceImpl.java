package org.dreamtech.xiuxian.service.impl;

import java.util.List;

import org.dreamtech.xiuxian.dao.HomeDao;
import org.dreamtech.xiuxian.entity.Person;
import org.dreamtech.xiuxian.entity.State;
import org.dreamtech.xiuxian.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HomeServiceImpl implements HomeService {
	// 满级
	public static final Integer MAX_STATE = -1;
	// 突破成功
	public static final Integer BREAK_SUCCESS = 1;
	// 内部错误
	public static final Integer INNER_ERROR = 0;
	@Autowired
	private HomeDao homeDao;

	@Override
	public State getInitInfoByStateId(String stateId) {
		return homeDao.getInitInfoByStateId(stateId);
	}

	@Override
	public int saveExpChange(String userId, String exp) {
		return homeDao.saveExpChange(userId, exp);
	}

	@Override
	@Transactional
	public int breakState(Person user) {
		List<State> stateList = homeDao.getStateList();
		State state = null;
		if (Integer.parseInt(user.getStateId()) <= Integer.parseInt(stateList.get(stateList.size() - 1).getStateId())) {
			for (State tempState : stateList) {
				if (tempState.getStateId().equals(user.getStateId())) {
					state = tempState;
				}
			}
			String newStateId = (Integer.parseInt(user.getStateId()) + 1) + "";
			int effectedNum = homeDao.breakState(user.getUserId(), newStateId);
			if (effectedNum > 0) {
				Person newUser = homeDao.getUserById(user.getUserId());
				homeDao.saveExpChange(newUser.getUserId(), (newUser.getExp() - state.getStateExp()) + "");
			} else {
				return INNER_ERROR;
			}
		} else {
			return MAX_STATE;
		}
		return BREAK_SUCCESS;
	}

	@Override
	public Person getUserById(String userId) {
		return homeDao.getUserById(userId);
	}

}
