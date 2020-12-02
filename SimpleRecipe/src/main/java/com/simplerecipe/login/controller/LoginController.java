package com.simplerecipe.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login/login")
	public void loginPage(String error, String logout, Model model) {
		if(error != null) {
			model.addAttribute("error", "로그인 실패");
		}
		if(logout != null) {
			model.addAttribute("logout", "로그아웃");
		}
	}
	
	@PostMapping("/login/login-processing")
	public void loginProcessing(String error) {
		
	}
	
}
