package com.simplerecipe.main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.simplerecipe.common.paging.Criteria;
import com.simplerecipe.main.vo.RecipeVO;

public interface RecipeDAO {
	List<RecipeVO> searchRecipe(List<String> ings, 
			Criteria cri);
	RecipeVO getDetail(RecipeVO vo);
	int getResultCount(List<String> ings);
	void insertRecipe(RecipeVO vo);
	String getRecipeMaxCount();
	List<RecipeVO> getMyRecipeList(int userTbNo);
	void deleteRecipe(RecipeVO vo);
	void updateRecipe(RecipeVO vo);
}
