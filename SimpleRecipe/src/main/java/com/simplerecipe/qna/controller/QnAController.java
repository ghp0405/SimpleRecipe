package com.simplerecipe.qna.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simplerecipe.qna.service.QnAService;
import com.simplerecipe.qna.vo.QnAVO;

@RequestMapping("/board")
@Controller
public class QnAController {

	@Autowired
	private QnAService qnaService;
	
	@RequestMapping(value="insertQnA", method=RequestMethod.GET)
	public String insertQnAForm(QnAVO vo, Model model, HttpSession session) {
		model.addAttribute("userTbId", session.getAttribute("userTbId"));
		return "/board/insertQnA";
	}
	
	@RequestMapping(value="insertQnA", method=RequestMethod.POST)
	public String insertQnA(QnAVO vo, HttpSession session) {
		vo.setUserTbId((String)session.getAttribute("userTbId"));
		qnaService.insertQnA(vo);
		return "redirect:/board/getQnAList";
	}
	
	@RequestMapping(value="updateQnA", method=RequestMethod.GET)
	public String updateQnAForm(QnAVO vo, Model model) {
		model.addAttribute("qna", qnaService.getQnA(vo));
		return "/board/updateQnA";
	}
	
	@RequestMapping(value="updateQnA", method=RequestMethod.POST)
	public String updateQnA(QnAVO vo) {
		qnaService.updateQnA(vo);
		return "redirect:/board/getQnAList";
	}
	
	@RequestMapping("deleteQnA")
	public String deleteQnA(QnAVO vo) {
		qnaService.deleteQnA(vo);
		return "redirect:/board/getQnAList";
	}
	
	@RequestMapping("getQnA")
	public String getQnA(QnAVO vo, Model model) {
		model.addAttribute("qna", qnaService.getQnA(vo));
		return "/board/getQnA";
	}
	
	@RequestMapping("getQnAList")
	public String getQnAList(QnAVO vo, Model model) {
		model.addAttribute("qnaList", qnaService.getQnAList(vo));
		return "/board/getQnAList";
	}
	
}
