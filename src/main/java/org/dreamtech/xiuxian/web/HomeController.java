package org.dreamtech.xiuxian.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dreamtech.xiuxian.entity.Person;
import org.dreamtech.xiuxian.entity.State;
import org.dreamtech.xiuxian.service.HomeService;
import org.dreamtech.xiuxian.service.impl.HomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 主页控制器
 * 
 * @author Xu Yiqing
 *
 */
@RestController
public class HomeController {
	@Autowired
	private HomeService homeService;

	/**
	 * 获得初始化信息
	 * 
	 * @param request 请求
	 * @return
	 */
	@RequestMapping(value = "getinitinfo", method = RequestMethod.GET)
	private Map<String, Object> getInitInfo(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Person person = (Person) request.getSession().getAttribute("user");
		if (person != null) {
			if (person.getUsername() != null) {
				modelMap.put("user", person);
			}
			if (person.getStateId() != null) {
				State state = homeService.getInitInfoByStateId(person.getStateId());
				if (state != null && state.getStateId() != null) {
					modelMap.put("success", true);
					modelMap.put("state", state);
				} else {
					modelMap.put("success", false);
					modelMap.put("errMsg", "未知错误");
				}
			}
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "非法操作");
		}
		return modelMap;
	}

	/**
	 * 每3秒进行一次经验保存
	 * 
	 * @param request 请求
	 * @return
	 */
	@RequestMapping(value = "submitexpchange", method = RequestMethod.GET)
	private Map<String, Object> sumbitExp(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Person user = (Person) request.getSession().getAttribute("user");
		String userId = user.getUserId();
		String exp = request.getParameter("exp");
		try {
			int effectedNum = homeService.saveExpChange(userId, exp);
			if (effectedNum < 1) {
				modelMap.put("success", false);
				modelMap.put("errMsg", "非法操作");
			} else {
				modelMap.put("success", true);
			}
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}
		return modelMap;
	}

	/**
	 * 突破
	 * 
	 * @param request 请求
	 * @return
	 */
	@RequestMapping(value = "submitbreak", method = RequestMethod.GET)
	private Map<String, Object> sumbitBreak(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Person user = (Person) request.getSession().getAttribute("user");
		try {
			int result = homeService.breakState(user);
			if (result == HomeServiceImpl.BREAK_SUCCESS) {
				modelMap.put("success", true);
				Person newUser = homeService.getUserById(user.getUserId());
				request.getSession().setAttribute("user", newUser);
			} else if (result == HomeServiceImpl.MAX_STATE) {
				modelMap.put("success", false);
				modelMap.put("errMsg", "道友的境界已经达到了巅峰");
			} else if (result == HomeServiceImpl.INNER_ERROR) {
				modelMap.put("success", false);
				modelMap.put("errMsg", "未知错误");
			}
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}
		return modelMap;
	}
}
