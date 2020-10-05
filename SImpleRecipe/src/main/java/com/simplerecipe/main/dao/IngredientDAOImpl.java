package com.simplerecipe.main.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simplerecipe.main.vo.IngredientVO;

@Repository
public class IngredientDAOImpl implements IngredientDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insertIngredient(IngredientVO vo) {
		sqlSessionTemplate.insert("IngredientDAO.insertIngredient", vo);
	}
	
	@Override
	public IngredientVO searchIngredient(IngredientVO vo) {
		return (IngredientVO)sqlSessionTemplate.selectOne("IngredientDAO.searchIngredient", vo);
	}
	
	@Override
	public IngredientVO getIngredient(Integer ingredientTbNo) {
		return (IngredientVO)sqlSessionTemplate.selectOne("IngredientDAO.getIngredient", ingredientTbNo);
	}

}
