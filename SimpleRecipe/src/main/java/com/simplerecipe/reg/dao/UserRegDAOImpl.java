package com.simplerecipe.reg.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simplerecipe.reg.vo.UserVO;

@Repository
public class UserRegDAOImpl implements UserRegDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public boolean existUserIdCheck(UserVO vo) { // 기존 일반사용자/관리자의 ID와의 중복 방지
		List<UserVO> matchedUsers = sqlSessionTemplate.selectList("UserDAO.existUserIdCheck", vo);
		return (matchedUsers.size() > 0) ? true : false;
	}

	@Override
	public void insertUser(UserVO vo) {
		sqlSessionTemplate.insert("UserDAO.insertUser", vo);
	}
	
}
