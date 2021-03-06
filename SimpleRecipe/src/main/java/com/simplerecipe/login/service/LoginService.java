package com.simplerecipe.login.service;

import com.simplerecipe.login.vo.AdminVO;
import com.simplerecipe.login.vo.UserVO;

public interface LoginService {
	boolean userLoginCheck(UserVO vo);
	boolean adminLoginCheck(AdminVO vo);
	UserVO getUser(UserVO vo);
	AdminVO getAdmin(AdminVO vo);
}
