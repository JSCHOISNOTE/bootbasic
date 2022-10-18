package com.simple.basic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.basic.command.UserVO;

@Controller
@RequestMapping("/user")
public class SessionController {
	//로그인화면
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	//로그인 성공페이지
	@GetMapping("/success")
	public String success(HttpSession session) {
		//세션이 없는 사용자가 못들어가게 하는 방법
//		if( session.getAttribute("user") == null ) {
//			return "redirect:/user/login";
//		}
		
		
		
		return "user/success";
	}
	//마이페이지
	@GetMapping("/mypage")
	public String mypage(HttpSession session) {
		//세션이 없는 사용자가 못들어가게 하는 방법
//		if( session.getAttribute("user") == null ) {
//			return "redirect:/user/login";
//		}
		
		return "user/mypage";
	}
	
	//로그인폼요청
	@PostMapping("/login")
	public String loginForm(UserVO vo, HttpServletRequest request ) {
	
		//vo를 가지고 로그인sql을 실행
		//select * from 유저 id = ? and pw = ?
		//UserVO vo = 로그인메서드();
		//로그인 성공이라 가정
		HttpSession session = request.getSession();
		UserVO user = UserVO.builder().id("홍길동").pw("1234").build();
		session.setAttribute("user", user);
		
		
		return "redirect:/user/success"; 
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/user/login";
	}
	
	
	
	
	
}
