package com.simplerecipe.main.service;

import java.util.List;

import com.simplerecipe.main.vo.RecipeVO;

public interface RecipeService {
	List<RecipeVO> searchRecipe(List<String> ings);
	RecipeVO getDetail(RecipeVO vo);
}
