package com.simplerecipe.admin.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simplerecipe.admin.vo.UserVO;

@Repository
public class UserMgtDAOImpl implements UserMgtDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void deleteUser(UserVO vo) {
		sqlSessionTemplate.delete("UserMgtDAO.deleteUser", vo);
	}

	@Override
	public List<UserVO> getUserList(UserVO vo) {
		return sqlSessionTemplate.selectList("UserMgtDAO.getUserList", vo);
	}

}
