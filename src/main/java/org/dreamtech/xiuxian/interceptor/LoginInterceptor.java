package org.dreamtech.xiuxian.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dreamtech.xiuxian.entity.Person;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 登录验证拦截器
 * 
 * @author Xu Yiqing
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 事先拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		Object userObj = request.getSession().getAttribute("user");
		if (userObj != null) {
			Person user = (Person) userObj;
			if (user != null && user.getUserId() != null) {
				return true;
			}
		}
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<script>");
		out.println("window.location.href='/xiuxian/login'");
		out.println("</script>");
		out.println("</html>");
		return false;
	}
}
