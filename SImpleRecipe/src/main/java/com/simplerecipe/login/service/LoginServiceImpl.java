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
		return userLoginDAO.loginCheck(vo);
	}
	
	@Override
	public boolean adminLoginCheck(AdminVO vo) {
		return adminLoginDAO.loginCheck(vo);
	}
	
	@Override
	public UserVO getUser(UserVO vo) {
		return userLoginDAO.getUser(vo);
	}
	
	@Override
	public AdminVO getAdmin(AdminVO vo) {
		return adminLoginDAO.getAdmin(vo);
	}

}
