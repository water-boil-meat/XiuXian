package org.dreamtech.xiuxian.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dreamtech.xiuxian.entity.Person;
import org.dreamtech.xiuxian.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.kaptcha.Constants;

/**
 * 登录页控制器
 * 
 * @author Xu Yiqing
 *
 */
@RestController
public class PersonController {
	@Autowired
	private PersonService personService;

	/**
	 * 登陆
	 * 
	 * @param request 请求
	 * @return
	 */
	@RequestMapping(value = "logincheck", method = RequestMethod.POST)
	private Map<String, Object> login(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		String verifyCodeActual = request.getParameter("verifyCodeActual");
		String verifyCodeExpected = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if (verifyCodeActual == null || !verifyCodeActual.equals(verifyCodeExpected)) {
			modelMap.put("errMsg", "验证码错误");
			modelMap.put("success", false);
		}
		try {
			Person person = personService.getPersonByUsernameAndPassword(username, password);
			System.out.println("[-*-User: " + person.getUsername() + " login-*-]");
			request.getSession().setAttribute("user", person);
			if (person != null && person.getUserId() != null) {
				modelMap.put("success", true);
			} else {
				modelMap.put("success", false);
				modelMap.put("errMsg", "用户名或密码错误");
			}
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", "用户名或密码错误");
		}
		return modelMap;
	}
}
