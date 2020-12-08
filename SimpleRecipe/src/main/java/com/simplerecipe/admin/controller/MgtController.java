package com.simplerecipe.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simplerecipe.admin.service.UserMgtService;
import com.simplerecipe.admin.vo.UserVO;
import com.simplerecipe.common.paging.Criteria;
import com.simplerecipe.common.paging.PageMaker;

@RequestMapping("/admin")
@Controller
public class MgtController {

	@Autowired
	private UserMgtService userMgtService;
	
	@RequestMapping("/suspendUser")
	public String suspendUser(UserVO vo) {
		userMgtService.suspendUser(vo);
		return "redirect:/getUserList";
	}
	
	@RequestMapping("/unsuspendUser")
	public String unsuspendUser(UserVO vo) {
		userMgtService.unsuspendUser(vo);
		return "redirect:/getUserList";
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
