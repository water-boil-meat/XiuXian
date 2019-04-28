package org.dreamtech.xiuxian.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面控制器
 * 
 * @author Xu Yiqing
 *
 */
@Controller
public class PageController {
	/**
	 * 登陆页面
	 * 
	 * @return 登录页
	 */
	@RequestMapping("login")
	private String login() {
		return "login";
	}

	/**
	 * 首页
	 * 
	 * @return 首页
	 */
	@RequestMapping("home")
	private String test() {
		return "home";
	}
}
