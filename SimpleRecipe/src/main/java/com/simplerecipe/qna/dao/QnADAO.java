package com.simplerecipe.qna.dao;

import java.util.List;

import com.simplerecipe.qna.vo.QnAVO;

public interface QnADAO {
	void insertQnA(QnAVO vo);
	void updateQnA(QnAVO vo);
	void deleteQnA(QnAVO vo);
	QnAVO getQnA(QnAVO vo);
	List<QnAVO> getQnAList(QnAVO vo);
}
