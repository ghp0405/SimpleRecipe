package com.simplerecipe.reg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplerecipe.reg.dao.UserRegDAO;
import com.simplerecipe.reg.vo.UserVO;

@Service
public class UserRegServiceImpl implements UserRegService {
	
	@Autowired
	private UserRegDAO userRegDAO;

	@Override
	public void insertUser(UserVO vo) {
		if(!userRegDAO.existUserIdCheck(vo)) { // 중복되는 ID가 없으면 삽입
			userRegDAO.insertUser(vo);
		}
		else {
			System.out.println("중복되는 ID입니다.");
		}
	}

}
