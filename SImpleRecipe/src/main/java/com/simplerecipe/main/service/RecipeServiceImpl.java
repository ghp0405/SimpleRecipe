package com.simplerecipe.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplerecipe.common.paging.Criteria;
import com.simplerecipe.main.dao.IngredientDAO;
import com.simplerecipe.main.dao.IngredientListDAO;
import com.simplerecipe.main.dao.RecipeDAO;
import com.simplerecipe.main.vo.IngredientListVO;
import com.simplerecipe.main.vo.IngredientVO;
import com.simplerecipe.main.vo.RecipeVO;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeDAO recipeDAO;
	@Autowired
	private IngredientListDAO ingredientListDAO;
	@Autowired
	private IngredientDAO ingredientDAO;
	
	@Override
	public List<RecipeVO> searchRecipe(List<String> ings, Criteria cri) {
		return recipeDAO.searchRecipe(ings, cri);
	}
	
	@Override
	public RecipeVO getDetail(RecipeVO vo) {
		return recipeDAO.getDetail(vo);
	}
	
	@Override
	public int getResultCount(List<String> ings) {
		return recipeDAO.getResultCount(ings);
	}
	
	@Override
	public String getRecipeMaxCount() {
		return recipeDAO.getRecipeMaxCount();
	}
	
	@Override
	public void insertRecipe(RecipeVO rvo, List<IngredientVO> ivoList, 
			List<IngredientListVO> ilvoList) { // 재료가 list형태로 와야함
		recipeDAO.insertRecipe(rvo);
		rvo.setRecipeTbNo(Integer.parseInt(recipeDAO.getRecipeMaxCount()));
		// 아래는 반복문을 통해 삽입해야함. 레시피 1개에 재료 i개가 들어감
		for(int i = 0; i < ivoList.size(); i++) { 
			IngredientVO ivo = new IngredientVO();
			IngredientListVO ilvo = new IngredientListVO();
			ivo = ivoList.get(i);
			ilvo = ilvoList.get(i);
			// 신규 재료일 경우
			if(ingredientDAO.searchIngredient(ivo) == null) {
				System.out.println("신규 재료 삽입");
				ingredientDAO.insertIngredient(ivo);
			} // 기존 재료일 경우
			else {
				System.out.println("기존 재료 삽입");
			}
			// 해당 no를 검색한 뒤, 재료 목록 테이블에 삽입한다
			ingredientListDAO.insertIngredientList(
				rvo.getRecipeTbNo(), 
				ingredientDAO.searchIngredient(ivo).getIngredientTbNo(),
				ilvo.getIngredientListTbAmt());
		}
	}
	
	@Override
	public void updateRecipe(RecipeVO rvo, List<IngredientVO> ivoList,
			List<IngredientListVO> ilvoList) { // 재료가 list형태로 와야함
		recipeDAO.updateRecipe(rvo);
		// 아래는 반복문을 통해 삽입해야함. 레시피 1개에 재료 i개가 들어감
		for(int i = 0; i < ivoList.size(); i++) { 
			IngredientVO ivo = new IngredientVO();
			IngredientListVO ilvo = new IngredientListVO();
			ivo = ivoList.get(i);
			ilvo = ilvoList.get(i);
			// 신규 재료일 경우
			if(ingredientDAO.searchIngredient(ivo) == null) {
				System.out.println("신규 재료 삽입");
				ingredientDAO.insertIngredient(ivo);
			} // 기존 재료일 경우
			else {
				System.out.println("기존 재료 삽입");
			}
			// 해당 no를 검색한 뒤, 재료 목록 테이블에 삽입한다
			ingredientListDAO.insertIngredientList(
				rvo.getRecipeTbNo(), 
				ingredientDAO.searchIngredient(ivo).getIngredientTbNo(),
				ilvo.getIngredientListTbAmt());
		}
	}
	
	@Override
	public IngredientVO searchIngredient(IngredientVO vo) {
		return ingredientDAO.searchIngredient(vo);
	}
	
	@Override
	public List<RecipeVO> getMyRecipeList(int userTbNo){
		return recipeDAO.getMyRecipeList(userTbNo);
	}
	
	@Override
	public List<IngredientListVO> getIngredientList(RecipeVO vo){
		return ingredientListDAO.getIngredientList(vo);
	}
	
	@Override
	public IngredientVO getIngredient(int ingredientTbNo){
		return ingredientDAO.getIngredient(ingredientTbNo);
	}
	
	@Override
	public void deleteRecipe(RecipeVO vo) {
		recipeDAO.deleteRecipe(vo);
	}

}
