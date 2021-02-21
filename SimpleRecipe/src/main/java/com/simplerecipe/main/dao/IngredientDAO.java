package com.simplerecipe.main.dao;

import com.simplerecipe.main.vo.IngredientVO;

public interface IngredientDAO {
	void insertIngredient(IngredientVO vo);
	IngredientVO searchIngredient(IngredientVO vo);
	IngredientVO getIngredient(Integer ingredientTbNo);
}
