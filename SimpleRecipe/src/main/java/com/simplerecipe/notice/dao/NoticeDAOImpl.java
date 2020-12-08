package com.simplerecipe.notice.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simplerecipe.notice.vo.NoticeVO;

@Repository
public class NoticeDAOImpl implements NoticeDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insertNotice(NoticeVO vo) {
		sqlSessionTemplate.insert("NoticeDAO.insertNotice", vo);
	}

	@Override
	public void updateNotice(NoticeVO vo) {
		sqlSessionTemplate.update("NoticeDAO.updateNotice", vo);
	}

	@Override
	public void deleteNotice(NoticeVO vo) {
		sqlSessionTemplate.delete("NoticeDAO.deleteNotice", vo);
	}

	@Override
	public NoticeVO getNotice(NoticeVO vo) {
		return (NoticeVO)sqlSessionTemplate.selectOne("NoticeDAO.getNotice", vo);
	}

	@Override
	public List<NoticeVO> getNoticeList(NoticeVO vo) {
		return sqlSessionTemplate.selectList("NoticeDAO.getNoticeList", vo);
	}

}
