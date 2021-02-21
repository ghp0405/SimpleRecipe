package com.simplerecipe.qna.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simplerecipe.qna.vo.QnAVO;

@Repository
public class QnADAOImpl implements QnADAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insertQnA(QnAVO vo) {
		sqlSessionTemplate.insert("QnADAO.insertQnA", vo);
	}

	@Override
	public void updateQnA(QnAVO vo) {
		sqlSessionTemplate.update("QnADAO.updateQnA", vo);
	}

	@Override
	public void deleteQnA(QnAVO vo) {
		sqlSessionTemplate.delete("QnADAO.deleteQnA", vo);
	}

	@Override
	public QnAVO getQnA(QnAVO vo) {
		return (QnAVO)sqlSessionTemplate.selectOne("QnADAO.getQnA", vo);
	}

	@Override
	public List<QnAVO> getQnAList(QnAVO vo) {
		return sqlSessionTemplate.selectList("QnADAO.getQnAList", vo);
	}

}
