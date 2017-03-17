package cn.xuxianda.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.xuxianda.entity.Account;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception exception)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object object, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 简单的用户登录拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object object) throws Exception {
		Account account=(Account)request.getSession().getAttribute("account");
		if(account==null){
			String root = request.getContextPath();
			response.sendRedirect(root+"/account/login");
			return false;
		}else{
			request.getRequestDispatcher("/WEB-INF/main/main.jsp");
			return true;
		}
	}

}
