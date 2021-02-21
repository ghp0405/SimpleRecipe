package com.simplerecipe.main.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simplerecipe.common.paging.Criteria;
import com.simplerecipe.main.vo.RecipeVO;

@Repository
public class RecipeDAOImpl implements RecipeDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<RecipeVO> searchRecipe(List<String> ings, 
			Criteria cri) {
		Map map = new HashMap();
		map.put("ings", ings);
		map.put("cri", cri);
		map.put("startNum", cri.getStartNum());
		map.put("endNum", cri.getEndNum());
		return sqlSessionTemplate.selectList("RecipeDAO.searchRecipe", map);
	}
	
	@Override
	public RecipeVO getDetail(RecipeVO vo) {
		return (RecipeVO)sqlSessionTemplate.selectOne("RecipeDAO.getDetail", vo);
	}
	
	@Override
	public int getResultCount(List<String> ings) {
		Map map = new HashMap();
		map.put("ings", ings); // 기존에 만들어둔 sql 서브쿼리를 재활용하기위한 의도
		return sqlSessionTemplate.selectOne("RecipeDAO.getResultCount", map);
	}
	
	@Override
	public String getRecipeMaxCount() {
		return (String)sqlSessionTemplate.selectOne("RecipeDAO.getRecipeMaxCount");
	}
	
	@Override
	public void insertRecipe(RecipeVO vo) {
		sqlSessionTemplate.insert("RecipeDAO.insertRecipe", vo);
	}
	
	@Override
	public List<RecipeVO> getMyRecipeList(int userTbNo) {
		return sqlSessionTemplate.selectList("RecipeDAO.getMyRecipeList", userTbNo);
	}
	
	@Override
	public void deleteRecipe(RecipeVO vo) {
		sqlSessionTemplate.delete("RecipeDAO.deleteRecipe", vo);
	}
	
	@Override
	public void updateRecipe(RecipeVO vo) {
		sqlSessionTemplate.update("RecipeDAO.updateRecipe", vo);
	}
	
}
