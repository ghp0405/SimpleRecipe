package com.simplerecipe.main.dao;

import java.util.List;

import com.simplerecipe.main.vo.IngredientListVO;
import com.simplerecipe.main.vo.RecipeVO;

public interface IngredientListDAO {
	void insertIngredientList(int rno, int ino, String ingredientListTbAmt);
	List<IngredientListVO> getIngredientList(RecipeVO vo);
}
