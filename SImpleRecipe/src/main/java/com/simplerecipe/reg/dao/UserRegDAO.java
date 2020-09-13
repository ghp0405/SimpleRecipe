package com.simplerecipe.reg.dao;

import com.simplerecipe.reg.vo.UserVO;

public interface UserRegDAO {
	boolean existUserIdCheck(UserVO vo);
	void insertUser(UserVO vo);
}
