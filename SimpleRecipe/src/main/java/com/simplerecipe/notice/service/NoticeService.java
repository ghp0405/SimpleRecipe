package com.simplerecipe.notice.service;

import java.util.List;

import com.simplerecipe.notice.vo.NoticeVO;

public interface NoticeService {
	void insertNotice(NoticeVO vo);
	void updateNotice(NoticeVO vo);
	void deleteNotice(NoticeVO vo);
	NoticeVO getNotice(NoticeVO vo);
	List<NoticeVO> getNoticeList(NoticeVO vo);
}
