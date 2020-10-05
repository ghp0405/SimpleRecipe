package com.simplerecipe.admin.dao;

import java.util.List;

import com.simplerecipe.admin.vo.UserVO;

// 사용자 관리 DAO
public interface UserMgtDAO {
	void deleteUser(UserVO vo);
	List<UserVO> getUserList(UserVO vo);
}
