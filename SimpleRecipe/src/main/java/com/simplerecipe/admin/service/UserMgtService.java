package com.simplerecipe.admin.service;

import java.util.List;

import com.simplerecipe.admin.vo.UserVO;
import com.simplerecipe.common.paging.Criteria;

public interface UserMgtService {
	void suspendUser(UserVO vo);
	void unsuspendUser(UserVO vo);
	List<UserVO> getUserList(Criteria cri);
	int getUserCount();
}
