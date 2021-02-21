package com.simplerecipe.admin.dao;

import java.util.List;

import com.simplerecipe.admin.vo.UserVO;
import com.simplerecipe.common.paging.Criteria;

// 사용자 관리 DAO
public interface UserMgtDAO {
	void suspendUser(UserVO vo);
	void unsuspendUser(UserVO vo);
	List<UserVO> getUserList(Criteria cri);
	int getUserCount();
}
