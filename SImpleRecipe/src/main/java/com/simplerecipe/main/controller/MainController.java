package com.simplerecipe.main.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplerecipe.main.service.RecipeService;
import com.simplerecipe.main.vo.RecipeVO;

@Controller
public class MainController {
	
	@Autowired
	private RecipeService recipeService;
	
	@RequestMapping("/main.do")
	public String mainPage(RecipeVO vo) {
		System.out.println("메인 컨트롤러 실행");
		return "main";
	}
	
	@RequestMapping("/search.do")
	public String searchRecipe(RecipeVO vo) {
		System.out.println("레시피 검색 컨트롤러 실행");
		return "result";
	}
	
	@RequestMapping("/result.do")
	public String resultRecipe(@RequestParam("keywords") String keywords, 
			Model model) {
		System.out.println("레시피 검색 결과 컨트롤러 실행");
		List<String> ings = new ArrayList<>();
		ings.add("양파");
		ings.add("감자");
		model.addAttribute("resultList", recipeService.searchRecipe(ings));
		model.addAttribute("keywords", keywords);
		return "result";
	}
	
	@RequestMapping("/detail.do")
	public String detailRecipe(RecipeVO vo, Model model) {
		try {
			// src/main/resources 위치에서 파일을 쉽게 가져올 수 있도록 마련된 클래스.
			ClassPathResource resource_txt = 
					new ClassPathResource(recipeService.getDetail(vo).getRecipeTbImageLink());
			System.out.println(recipeService.getDetail(vo).getRecipeTbImageLink());
			// java 7에 새롭게 추가된 nio 패키지의 Files, Path 클래스를 사용하면 파일을 쉽게 읽을 수 있다.
			Path path = Paths.get(resource_txt.getURI());
			List<String> content = Files.readAllLines(path);
			model.addAttribute("content", content);
			model.addAttribute("recipe", recipeService.getDetail(vo));
		}catch(IOException e) {
			e.printStackTrace();
		}
		return "detail";
	}
	
}
