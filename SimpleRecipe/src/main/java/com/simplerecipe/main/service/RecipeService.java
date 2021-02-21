package com.simplerecipe.main.service;

import java.util.List;

import com.simplerecipe.common.paging.Criteria;
import com.simplerecipe.main.vo.IngredientListVO;
import com.simplerecipe.main.vo.IngredientVO;
import com.simplerecipe.main.vo.RecipeVO;

public interface RecipeService {
	List<RecipeVO> searchRecipe(List<String> ings, Criteria cri);
	RecipeVO getDetail(RecipeVO vo);
	int getResultCount(List<String> ings);
	void insertRecipe(RecipeVO rvo, List<IngredientVO> ivoList, 
			List<IngredientListVO> ilvoList);
	void updateRecipe(RecipeVO rvo, List<IngredientVO> ivoList, 
			List<IngredientListVO> ilvoList);
	String getRecipeMaxCount();
	List<RecipeVO> getMyRecipeList(int userTbNo);
	void deleteRecipe(RecipeVO vo);
	List<IngredientListVO> getIngredientList(RecipeVO vo);
	IngredientVO getIngredient(int ingredientTbNo);
	IngredientVO searchIngredient(IngredientVO vo);
}
