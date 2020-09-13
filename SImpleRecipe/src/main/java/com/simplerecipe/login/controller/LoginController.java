package com.simplerecipe.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simplerecipe.login.service.LoginService;
import com.simplerecipe.login.vo.AdminVO;
import com.simplerecipe.login.vo.UserVO;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/login.do")
	public String login() {
		System.out.println("login 컨트롤러 실행");
		return "login/login";
	}
	
	@RequestMapping("/loginCheck.do")
	public String loginCheck(UserVO uvo, AdminVO avo, HttpSession session) {
		System.out.println("loginCheck 컨트롤러 실행");
		boolean loginResult = loginService.userLoginCheck(uvo);
		if(loginResult) {
			System.out.println("일반 사용자 로그인");
			session.setAttribute("userTbId", uvo.getUserTbId());
			session.setAttribute("userType", "일반사용자");
			System.out.println("userTbId : " + uvo.getUserTbId());
			return "main";
		}
		else{ 
			avo.setAdminTbId(uvo.getUserTbId());
			avo.setAdminTbPwd(uvo.getUserTbPwd());
			loginResult = loginService.adminLoginCheck(avo);
			if(loginResult) {
				System.out.println("관리자 로그인");
				session.setAttribute("adminTbId", avo.getAdminTbId());
				session.setAttribute("userType", "관리자");
				System.out.println("adminTbId : " + avo.getAdminTbId());
				return "main";
			}
			else {
				System.out.println("로그인 실패");
				return "redirect:/login.do";
			}
		}
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그아웃 컨트롤러 실행");
		try{
			session.removeAttribute("userTbId");
			session.removeAttribute("userType");
		}catch(Exception e) {
			e.printStackTrace();
			try {
				session.removeAttribute("adminTbId");
				session.removeAttribute("userType");
			}catch(Exception e2) {
				e2.printStackTrace();
				System.out.println("로그아웃 오류");
			}
		}
		session.invalidate();
		return "redirect:/login.do";
	}
	
}
