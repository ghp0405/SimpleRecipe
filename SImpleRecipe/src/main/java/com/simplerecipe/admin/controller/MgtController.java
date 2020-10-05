package com.simplerecipe.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simplerecipe.admin.service.UserMgtService;
import com.simplerecipe.admin.vo.UserVO;

@Controller
public class MgtController {

	@Autowired
	private UserMgtService userMgtService;
	
	@RequestMapping("/deleteUser.do")
	public String deleteUser(UserVO vo) {
		userMgtService.deleteUser(vo);
		return "redirect:/getUserList.do";
	}
	
	@RequestMapping("/getUserList.do")
	public String getUserList(UserVO vo, Model model) {
		model.addAttribute("userList", userMgtService.getUserList(vo));
		return "getUserList";
	}
	
}
