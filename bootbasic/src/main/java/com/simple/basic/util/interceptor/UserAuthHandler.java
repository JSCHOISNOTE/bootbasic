package com.simple.basic.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.simple.basic.command.UserVO;

public class UserAuthHandler implements HandlerInterceptor {
	
	
	//회원 관련 요청이 들어왔을때 가로채서 처리할 인터셉터
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("유저인터셉터 실행됨");
		
		//세션검사
		HttpSession session = request.getSession();
		UserVO user = (UserVO)session.getAttribute("user");
		
		if(user == null) { //세션이 없음
			//리다이렉트
			response.sendRedirect( request.getContextPath() + "/user/login" );
			return false; //컨트롤러를 실행하지 않음
			
		} else { //세션이 있음
			
			return true; //컨트롤러를 실행함
		}
		
	}

	
}
