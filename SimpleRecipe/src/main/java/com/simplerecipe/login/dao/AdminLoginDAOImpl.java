package com.simplerecipe.login.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simplerecipe.login.vo.AdminVO;

@Repository
public class AdminLoginDAOImpl implements AdminLoginDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public boolean loginCheck(AdminVO vo) {
		AdminVO admin = (AdminVO)sqlSessionTemplate.selectOne("AdminDAO.loginCheck", vo);
		return (admin == null) ? false : true;
	}

	@Override
	public AdminVO getAdmin(AdminVO vo) {
		return (AdminVO)sqlSessionTemplate.selectOne("AdminDAO.getAdmin", vo);
	}

}
