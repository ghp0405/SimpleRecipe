package com.simplerecipe.qna.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simplerecipe.qna.service.QnAService;
import com.simplerecipe.qna.vo.QnAVO;

@Controller
public class QnAController {

	@Autowired
	private QnAService qnaService;
	
	@RequestMapping(value="insertQnA.do", method=RequestMethod.GET)
	public String insertQnAForm(QnAVO vo, Model model, HttpSession session) {
		model.addAttribute("userTbId", session.getAttribute("userTbId"));
		return "insertQnA";
	}
	
	@RequestMapping(value="insertQnA.do", method=RequestMethod.POST)
	public String insertQnA(QnAVO vo, HttpSession session) {
		vo.setUserTbId((String)session.getAttribute("userTbId"));
		qnaService.insertQnA(vo);
		return "redirect:/getQnAList.do";
	}
	
	@RequestMapping(value="updateQnA.do", method=RequestMethod.GET)
	public String updateQnAForm(QnAVO vo, Model model) {
		model.addAttribute("qna", qnaService.getQnA(vo));
		return "updateQnA";
	}
	
	@RequestMapping(value="updateQnA.do", method=RequestMethod.POST)
	public String updateQnA(QnAVO vo) {
		qnaService.updateQnA(vo);
		return "redirect:/getQnAList.do";
	}
	
	@RequestMapping("deleteQnA.do")
	public String deleteQnA(QnAVO vo) {
		qnaService.deleteQnA(vo);
		return "redirect:/getQnAList.do";
	}
	
	@RequestMapping("getQnA.do")
	public String getQnA(QnAVO vo, Model model) {
		model.addAttribute("qna", qnaService.getQnA(vo));
		return "getQnA";
	}
	
	@RequestMapping("getQnAList.do")
	public String getQnAList(QnAVO vo, Model model) {
		model.addAttribute("qnaList", qnaService.getQnAList(vo));
		return "getQnAList";
	}
	
}
