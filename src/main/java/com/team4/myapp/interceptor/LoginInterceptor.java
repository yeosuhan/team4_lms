package com.team4.myapp.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		if(!(handler instanceof HandlerMethod)) return true;
		
		String memberId = (String) request.getSession().getAttribute("memberid");
		if(memberId == null || memberId.equals("")) {
			try {
				response.sendRedirect(request.getContextPath() + "/member/login");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {		
	}

}
