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
		UserVO user = (UserVO)sqlSessionTemplate.selectOne("UserDAO.loginCheck", vo);
		return (user == null) ? false : true;
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return (UserVO)sqlSessionTemplate.selectOne("UserDAO.getUser", vo);
	}
	
}
