package com.simplerecipe.reg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.simplerecipe.reg.dao.UserRegDAO;
import com.simplerecipe.reg.vo.UserVO;

@Service
public class UserRegServiceImpl implements UserRegService {
	
	@Autowired
	private UserRegDAO userRegDAO;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	@Override
	public void insertUser(UserVO vo) {
		if(!userRegDAO.existUserIdCheck(vo)) { // 중복되는 ID가 없으면 삽입
			// 스프링 시큐리티 기능 중 bcrypt 암호화를 반드시 거쳐야 
			// 시큐리티로부터 발생하는 오류를 막을 수 있음. + 보안성 강화
			String endcodedPassword = bcryptPasswordEncoder.encode(vo.getUserTbPwd());
			vo.setUserTbPwd(endcodedPassword);
			
			// 암호화한 후의 vo를 저장
			userRegDAO.insertUser(vo);
		}
		else {
			System.out.println("중복되는 ID입니다.");
		}
	}

}
