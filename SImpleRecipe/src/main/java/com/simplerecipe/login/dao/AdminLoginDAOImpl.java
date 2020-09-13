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
		System.out.println("AdminDAO.loginCheck() 처리");
		AdminVO admin = (AdminVO)sqlSessionTemplate.selectOne("AdminDAO.loginCheck", vo);
		return (admin == null) ? false : true;
	}

	@Override
	public AdminVO getAdmin(AdminVO vo) {
		System.out.println("AdminDAO.getAdmin() 처리");
		return (AdminVO)sqlSessionTemplate.selectOne("AdminDAO.getAdmin", vo);
	}

}
