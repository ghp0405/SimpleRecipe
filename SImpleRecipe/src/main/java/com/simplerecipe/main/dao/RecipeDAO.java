package com.simplerecipe.main.dao;

import java.util.List;

import com.simplerecipe.main.vo.RecipeVO;

public interface RecipeDAO {
	List<RecipeVO> searchRecipe(List<String> ings);
	RecipeVO getDetail(RecipeVO vo);
}
