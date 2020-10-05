package com.simplerecipe.notice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simplerecipe.notice.service.NoticeService;
import com.simplerecipe.notice.vo.NoticeVO;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="/insertNotice.do", method=RequestMethod.GET)
	public String insertNoticeForm(NoticeVO vo, HttpSession session, Model model) {
		model.addAttribute("adminTbId", session.getAttribute("adminTbId"));
		return "insertNotice";
	}
	
	@RequestMapping(value="/insertNotice.do", method=RequestMethod.POST)
	public String insertNotice(NoticeVO vo, HttpSession session) {
		vo.setAdminTbId((String)session.getAttribute("adminTbId"));
		noticeService.insertNotice(vo);
		return "redirect:/getNoticeList.do";
	}
	
	@RequestMapping(value="/updateNotice.do", method=RequestMethod.GET)
	public String updateNoticeForm(NoticeVO vo, Model model) {
		model.addAttribute("notice", noticeService.getNotice(vo));
		return "updateNotice";
	}
	
	@RequestMapping(value="/updateNotice.do", method=RequestMethod.POST)
	public String updateNotice(NoticeVO vo) {
		noticeService.updateNotice(vo);
		return "redirect:/getNoticeList.do";
	}
	
	@RequestMapping("/deleteNotice.do")
	public String deleteNotice(NoticeVO vo) {
		noticeService.deleteNotice(vo);
		return "redirect:/getNoticeList.do";
	}
	
	@RequestMapping("/getNotice.do")
	public String getNotice(NoticeVO vo, Model model) {
		model.addAttribute("notice", noticeService.getNotice(vo));
		return "getNotice";
	}
	
	@RequestMapping("/getNoticeList.do")
	public String getNoticeList(NoticeVO vo, Model model,
			HttpSession session) {
		model.addAttribute("noticeList", noticeService.getNoticeList(vo));
		model.addAttribute("userType", session.getAttribute("userType"));
		return "getNoticeList";
	}
	
}
