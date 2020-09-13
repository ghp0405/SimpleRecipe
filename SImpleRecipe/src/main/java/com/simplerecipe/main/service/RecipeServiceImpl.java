package com.simplerecipe.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplerecipe.main.dao.RecipeDAO;
import com.simplerecipe.main.vo.RecipeVO;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeDAO recipeDAO;
	
	@Override
	public List<RecipeVO> searchRecipe(List<String> ings) {
		System.out.println("RecipeService.searchRecipe() 실행");
		return recipeDAO.searchRecipe(ings);
	}
	
	@Override
	public RecipeVO getDetail(RecipeVO vo) {
		System.out.println("RecipeService.getDetail() 실행");
		return recipeDAO.getDetail(vo);
	}

}
