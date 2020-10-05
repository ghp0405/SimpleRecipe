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
		return "login/login";
	}
	
	@RequestMapping("/loginCheck.do")
	public String loginCheck(UserVO uvo, AdminVO avo, HttpSession session) {
		boolean loginResult = loginService.userLoginCheck(uvo);
		if(loginResult) {
			System.out.println("일반 사용자 로그인");
			session.setAttribute("userTbId", uvo.getUserTbId());
			session.setAttribute("userTbNo", loginService.getUser(uvo).getUserTbNo());
			session.setAttribute("userType", "일반사용자");
			return "redirect:/main.do";
		}
		else{ 
			avo.setAdminTbId(uvo.getUserTbId());
			avo.setAdminTbPwd(uvo.getUserTbPwd());
			loginResult = loginService.adminLoginCheck(avo);
			if(loginResult) {
				System.out.println("관리자 로그인");
				session.setAttribute("adminTbId", avo.getAdminTbId());
				session.setAttribute("adminTbNo", loginService.getAdmin(avo).getAdminTbNo());
				session.setAttribute("userType", "관리자");
				return "redirect:/main.do";
			}
			else {
				System.out.println("로그인 실패");
				return "redirect:/login.do";
			}
		}
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		try{
			session.removeAttribute("userTbId");
			session.removeAttribute("userTbNo");
			session.removeAttribute("userType");
		}catch(Exception e) {
			e.printStackTrace();
			try {
				session.removeAttribute("adminTbId");
				session.removeAttribute("adminTbNo");
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
