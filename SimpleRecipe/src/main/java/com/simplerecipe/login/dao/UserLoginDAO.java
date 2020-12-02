package com.simplerecipe.login.dao;

import com.simplerecipe.login.vo.UserVO;

public interface UserLoginDAO {
	boolean loginCheck(UserVO vo);
	UserVO getUser(UserVO vo);
}
