package com.team4.myapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AuthInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//Controller에 있는 메소드인지 확인한다.
		if(!(handler instanceof HandlerMethod)) return true;
		
		// @Auth 받아오기
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		
		if(auth == null) return true;
		
		//@Auth가 있는 경우
		HttpSession session = request.getSession();
		Role identity = (Role) session.getAttribute("identity");
		
		// @Auth professor인 경우
		Role role = auth.role();
		if(role != null) {
			if(Role.PROFESSOR == role) {
				if(identity != Role.PROFESSOR) {
					// 유저는 접근 뷸가한다는 페이지나 로그인 페이지로 이동
					response.sendRedirect("/member/denied");
					return false;
				}
			}
		}		
		// 다음 인터셉터로 넘어가는 것을 허용한다.
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
