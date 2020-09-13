package com.simplerecipe.main.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simplerecipe.main.vo.RecipeVO;

@Repository
public class RecipeDAOImpl implements RecipeDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<RecipeVO> searchRecipe(List<String> ings) {
		System.out.println("RecipeDAO.searchRecipe 실행");
		return sqlSessionTemplate.selectList("RecipeDAO.searchRecipe", ings);
	}
	
	@Override
	public RecipeVO getDetail(RecipeVO vo) {
		System.out.println("RecipeDAO.getDetail 실행");
		return (RecipeVO)sqlSessionTemplate.selectOne("RecipeDAO.getDetail", vo);
	}
	
}
