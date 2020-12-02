package com.mycompany.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/login")
	public void loginPage(String error, String logout, Model model) {
		logger.info("로그인 페이지로 이동");
		logger.info("err : " + error);
		logger.info("logout : " + logout);
		if(error != null) {
			model.addAttribute("error", "로그인 실패");
		}
		if(logout != null) {
			model.addAttribute("logout", "로그아웃");
		}
	}
	
	@PostMapping("/login-processing")
	public void loginProcessing(String error) {
		logger.info("login-processing!");
		logger.info("err : " + error);
	}
	
	@GetMapping("/all")
	public void doAll() {
		logger.info("all로그인");
	}
	
	@GetMapping("/member")
	public void doMember() {
		logger.info("멤버로그인");
	}
	
	@GetMapping("/admin")
	public void doAdmin() {
		logger.info("관리자로그인");
	}
	
}
