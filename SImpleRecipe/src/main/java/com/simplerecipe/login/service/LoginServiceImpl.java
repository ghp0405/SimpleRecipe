package com.simplerecipe.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simplerecipe.login.dao.AdminLoginDAO;
import com.simplerecipe.login.dao.UserLoginDAO;
import com.simplerecipe.login.vo.AdminVO;
import com.simplerecipe.login.vo.UserVO;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserLoginDAO userLoginDAO;
	
	@Autowired
	private AdminLoginDAO adminLoginDAO;

	@Override
	public boolean userLoginCheck(UserVO vo) {
		System.out.println("LoginService.userLoginCheck 실행");
		return userLoginDAO.loginCheck(vo);
	}
	
	@Override
	public boolean adminLoginCheck(AdminVO vo) {
		System.out.println("LoginService.adminLoginCheck 실행");
		return adminLoginDAO.loginCheck(vo);
	}

	@Override
	public void login() {
		System.out.println("LoginService.login 실행");
	}
	
	@Override
	public void logout() {
		System.out.println("LoginService.logout 실행");
	}

}
