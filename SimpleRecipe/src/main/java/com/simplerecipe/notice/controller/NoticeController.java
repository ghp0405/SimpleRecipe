package com.simplerecipe.notice.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simplerecipe.notice.service.NoticeService;
import com.simplerecipe.notice.vo.NoticeVO;

@RequestMapping("/board")
@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="/insertNotice", method=RequestMethod.GET)
	public String insertNoticeForm(NoticeVO vo, HttpSession session, Model model) {
		model.addAttribute("adminTbId", session.getAttribute("adminTbId"));
		return "/board/insertNotice";
	}
	
	@RequestMapping(value="/insertNotice", method=RequestMethod.POST)
	public String insertNotice(NoticeVO vo, HttpSession session) {
		vo.setAdminTbId((String)session.getAttribute("adminTbId"));
		noticeService.insertNotice(vo);
		return "redirect:/board/getNoticeList";
	}
	
	@RequestMapping(value="/updateNotice", method=RequestMethod.GET)
	public String updateNoticeForm(NoticeVO vo, Model model) {
		model.addAttribute("notice", noticeService.getNotice(vo));
		return "/board/updateNotice";
	}
	
	@RequestMapping(value="/updateNotice", method=RequestMethod.POST)
	public String updateNotice(NoticeVO vo) {
		noticeService.updateNotice(vo);
		return "redirect:/board/getNoticeList";
	}
	
	@RequestMapping("/deleteNotice")
	public String deleteNotice(NoticeVO vo) {
		noticeService.deleteNotice(vo);
		return "redirect:/board/getNoticeList";
	}
	
	@RequestMapping("/getNotice")
	public String getNotice(NoticeVO vo, Model model) {
		model.addAttribute("notice", noticeService.getNotice(vo));
		return "/board/getNotice";
	}
	
	@RequestMapping("/getNoticeList")
	public String getNoticeList(NoticeVO vo, Model model,
			HttpSession session) {
		model.addAttribute("noticeList", noticeService.getNoticeList(vo));
		model.addAttribute("userType", session.getAttribute("userType"));
		return "/board/getNoticeList";
	}
	
}
