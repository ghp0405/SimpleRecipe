package com.simplerecipe.main.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simplerecipe.main.vo.IngredientListVO;
import com.simplerecipe.main.vo.RecipeVO;

@Repository
public class IngredientListDAOImpl implements IngredientListDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insertIngredientList(int rno, int ino, String ingredientListTbAmt) {
		Map map = new HashMap();
		map.put("rno", rno);
		map.put("ino", ino);
		map.put("ingredientListTbAmt", ingredientListTbAmt);
		sqlSessionTemplate.insert("IngredientListDAO.insertIngredientList", map);
	}
	
	@Override
	public List<IngredientListVO> getIngredientList(RecipeVO vo) {
		return sqlSessionTemplate.selectList("IngredientListDAO.getIngredientList", vo);
	}

}
