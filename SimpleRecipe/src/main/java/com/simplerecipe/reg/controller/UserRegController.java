package com.simplerecipe.reg.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplerecipe.reg.service.UserRegService;
import com.simplerecipe.reg.vo.UserVO;

@RequestMapping("/reg")
@Controller
public class UserRegController {
	
	@Autowired
	private UserRegService userRegService;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerForm() {
		return "/reg/register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String insertUser(@RequestParam("userTbBirthdayTemp") String userTbBirthdayTemp, 
			UserVO vo) {
		// 생년월일 데이터 처리
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			vo.setUserTbBirthday(dateFormat.parse(userTbBirthdayTemp));
			userRegService.insertUser(vo);
			return "redirect:/login/login";
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("생년월일 입력 오류");
			return "/reg/register";
		}
	}
	
}
