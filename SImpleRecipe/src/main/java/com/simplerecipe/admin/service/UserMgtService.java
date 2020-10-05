package com.simplerecipe.admin.service;

import java.util.List;

import com.simplerecipe.admin.vo.UserVO;

public interface UserMgtService {
	void deleteUser(UserVO vo);
	List<UserVO> getUserList(UserVO vo);
}
