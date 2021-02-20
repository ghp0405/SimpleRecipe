package com.simplerecipe.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simplerecipe.login.service.LoginService;
import com.simplerecipe.login.vo.AdminVO;
import com.simplerecipe.login.vo.UserVO;

@RequestMapping("/login")
@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/weather", method=RequestMethod.GET)
	public String getWeather() {
		return "/login/weather";
	}
	
	// 로그인 창을 나타낸다.
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginPage() {
		return "/login/login";
	}

	// 로그인 처리
	@RequestMapping(value="/loginCheck", method=RequestMethod.POST)
	public String loginCheck(HttpSession session, UserVO uvo, AdminVO avo) {
		// uvo 객체로 가져온 사용자의 id 및 password를 토대로, 
		// 일반 사용자 목록에 있는 정보와 일치하는지 확인한다.
		boolean loginResult = loginService.userLoginCheck(uvo);
		
		// 일반 사용자 로그인 성공시
		if(loginResult) {
			uvo = loginService.getUser(uvo);
			// 세션에 사용자 정보를 등록
			session.setAttribute("userLogin", uvo);
			session.setAttribute("userTbId", uvo.getUserTbId());
			session.setAttribute("userTbNo", uvo.getUserTbNo());
			session.setAttribute("userType", "일반사용자");
			return "redirect:/main/main"; // 메인 창으로 이동
		}
		else { // 일반 사용자 로그인 실패시
			// 사용자 정보를 토대로, 이번엔 관리자 목록에 있는지 확인한다.
			avo.setAdminTbId(uvo.getUserTbId());
			avo.setAdminTbPwd(uvo.getUserTbPwd());
			loginResult = loginService.adminLoginCheck(avo);
			// 관리자 로그인 성공시
			if(loginResult) {
				avo = loginService.getAdmin(avo);
				// 세션에 관리자 정보를 등록
				session.setAttribute("adminLogin", avo);
				session.setAttribute("adminTbId", avo.getAdminTbId());
				session.setAttribute("adminTbNo", avo.getAdminTbNo());
				session.setAttribute("userType", "관리자");
				return "redirect:/main/main"; // 메인 창으로 이동
				
			}
			else { // 로그인 실패시
				return "redirect:/login/login"; // 로그인 창으로 이동시킨다.
			}
		}
		
	}
	
	// 로그아웃 처리
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		try { // 일반 사용자에 대한 세션 정보 제거 시도
			session.removeAttribute("userTbId");
			session.removeAttribute("userType");
		}catch (Exception e) { // 일반 사용자가 아닐 경우
			e.printStackTrace();
			try { // 관리자에 대한 세션 정보 제거 시도
				session.removeAttribute("adminTbId");
				session.removeAttribute("userType");
			}catch (Exception e2) { // 관리자도 아닌 경우
				e2.printStackTrace(); // 로그아웃 오류
			}
		}
		session.invalidate(); // 세션 초기화
		return "redirect:/login/login"; // 로그인 창으로 이동
	}
	
}
