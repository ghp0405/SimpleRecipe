package com.simplerecipe.qna.service;

import java.util.List;

import com.simplerecipe.qna.vo.QnAVO;

public interface QnAService {
	void insertQnA(QnAVO vo);
	void updateQnA(QnAVO vo);
	void deleteQnA(QnAVO vo);
	QnAVO getQnA(QnAVO vo);
	List<QnAVO> getQnAList(QnAVO vo);
}
