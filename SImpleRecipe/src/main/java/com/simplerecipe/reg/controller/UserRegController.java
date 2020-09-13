package com.simplerecipe.reg.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplerecipe.reg.service.UserRegService;
import com.simplerecipe.reg.vo.UserVO;

@Controller
public class UserRegController {
	
	@Autowired
	private UserRegService userRegService;
	
	@RequestMapping(value="/register.do", method=RequestMethod.GET)
	public String registerForm() {
		System.out.println("회원가입 페이지 호출");
		return "register";
	}
	
	@RequestMapping(value="/register.do", method=RequestMethod.POST)
	public String insertUser(@RequestParam("userTbBirthdayTemp") String userTbBirthdayTemp, 
			UserVO vo) {
		System.out.println("회원가입 컨트롤러 실행");
		// 생년월일 데이터 처리
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			vo.setUserTbBirthday(dateFormat.parse(userTbBirthdayTemp));
			userRegService.insertUser(vo);
			return "redirect:/login.do";
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("생년월일 입력에 오류가 발생하였습니다.");
			return "register";
		}
	}
	
}
