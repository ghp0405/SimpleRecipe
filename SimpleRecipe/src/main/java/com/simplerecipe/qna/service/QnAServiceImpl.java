package com.simplerecipe.qna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplerecipe.qna.dao.QnADAO;
import com.simplerecipe.qna.vo.QnAVO;

@Service
public class QnAServiceImpl implements QnAService {
	
	@Autowired
	private QnADAO qnaDAO;

	@Override
	public void insertQnA(QnAVO vo) {
		qnaDAO.insertQnA(vo);
	}

	@Override
	public void updateQnA(QnAVO vo) {
		qnaDAO.updateQnA(vo);
	}

	@Override
	public void deleteQnA(QnAVO vo) {
		qnaDAO.deleteQnA(vo);
	}

	@Override
	public QnAVO getQnA(QnAVO vo) {
		return qnaDAO.getQnA(vo);
	}

	@Override
	public List<QnAVO> getQnAList(QnAVO vo) {
		return qnaDAO.getQnAList(vo);
	}

}
