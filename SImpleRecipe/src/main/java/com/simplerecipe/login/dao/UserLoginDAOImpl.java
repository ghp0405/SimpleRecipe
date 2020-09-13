package com.simplerecipe.login.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simplerecipe.login.vo.UserVO;

@Repository
public class UserLoginDAOImpl implements UserLoginDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public boolean loginCheck(UserVO vo) {
		System.out.println("UserLoginDAO.loginCheck() 실행");
		UserVO user = (UserVO)sqlSessionTemplate.selectOne("UserDAO.loginCheck", vo);
		return (user == null) ? false : true;
	}

	@Override
	public UserVO getUser(UserVO vo) {
		System.out.println("UserLoginDAO.getUser() 실행");
		return (UserVO)sqlSessionTemplate.selectOne("UserDAO.getUser", vo);
	}
	
}
