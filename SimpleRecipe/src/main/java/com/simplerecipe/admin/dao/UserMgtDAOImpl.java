package com.simplerecipe.admin.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simplerecipe.admin.vo.UserVO;
import com.simplerecipe.common.paging.Criteria;

@Repository
public class UserMgtDAOImpl implements UserMgtDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void deleteUser(UserVO vo) {
		sqlSessionTemplate.delete("UserMgtDAO.deleteUser", vo);
	}

	@Override
	public List<UserVO> getUserList(Criteria cri) {
		Map map = new HashMap();
		map.put("cri", cri);
		map.put("startNum", cri.getStartNum());
		map.put("endNum", cri.getEndNum());
		return sqlSessionTemplate.selectList("UserMgtDAO.getUserList", map);
	}
	
	@Override
	public int getUserCount() {
		return sqlSessionTemplate.selectOne("UserMgtDAO.getUserCount");
	}

}
