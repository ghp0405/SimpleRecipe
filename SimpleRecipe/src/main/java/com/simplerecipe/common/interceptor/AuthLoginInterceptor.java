package com.simplerecipe.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 로그인 처리를 담당하는 인터셉터
public class AuthLoginInterceptor extends HandlerInterceptorAdapter {

	// preHandle() : 컨트롤러보다 먼저 수행되는 메서드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		// session 객체를 가져옴
		HttpSession session = request.getSession();
		// login 처리를 담당하는 사용자 정보를 담고 있는 객체를 가져옴
		Object userObj = session.getAttribute("userLogin");
		// login 처리를 담당하는 관리자 정보를 담고 있는 객체를 가져옴
		Object adminObj = session.getAttribute("adminLogin");
		
		// 로그인이 되어있지 않을 경우
		if(userObj == null && adminObj == null) {
			// 로그인 폼으로 다시 돌려보냄(redirect)
			response.sendRedirect("/login/login");
			return false;
		}
		
		// preHandle의 return은 컨트롤러 요청 uri로 가도 되냐 안되냐를 허가하는 의미임
		// 따라서 true로 하면 컨트롤러 uri로 가게 됨.
		return true;
		
	}
	
	// 컨트롤러가 수행되고 화면이 보여지기 직전에 수행되는 메서드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception{
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
