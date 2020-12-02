package com.simplerecipe.login.dao;

import com.simplerecipe.login.vo.AdminVO;

public interface AdminLoginDAO {
	boolean loginCheck(AdminVO vo);
	AdminVO getAdmin(AdminVO vo);
}
