package com.simplerecipe.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplerecipe.admin.dao.UserMgtDAO;
import com.simplerecipe.admin.vo.UserVO;
import com.simplerecipe.common.paging.Criteria;

@Service
public class UserMgtServiceImpl implements UserMgtService {
	
	@Autowired
	private UserMgtDAO userMgtDAO;

	@Override
	public void deleteUser(UserVO vo) {
		userMgtDAO.deleteUser(vo);
	}

	@Override
	public List<UserVO> getUserList(Criteria cri) {
		return userMgtDAO.getUserList(cri);
	}
	
	@Override
	public int getUserCount() {
		return userMgtDAO.getUserCount();
	}

}
