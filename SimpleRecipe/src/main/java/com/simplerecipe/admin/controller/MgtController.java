package com.simplerecipe.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simplerecipe.admin.service.UserMgtService;
import com.simplerecipe.admin.vo.UserVO;
import com.simplerecipe.common.paging.Criteria;
import com.simplerecipe.common.paging.PageMaker;

@Controller
public class MgtController {

	@Autowired
	private UserMgtService userMgtService;
	
	@RequestMapping("/deleteUser.do")
	public String deleteUser(UserVO vo) {
		userMgtService.deleteUser(vo);
		return "redirect:/getUserList.do";
	}
	
	@RequestMapping("/getUserList")
	public String getUserList(Criteria cri, Model model) {
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(userMgtService.getUserCount());
		cri = pageMaker.getCri();
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("userList", userMgtService.getUserList(cri));
		return "getUserList";
	}
	
}
