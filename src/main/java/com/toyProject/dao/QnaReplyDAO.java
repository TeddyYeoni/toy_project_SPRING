package com.toyProject.dao;

import java.util.List;

import com.toyProject.domain.BoardReplyVO;
import com.toyProject.domain.QnaReplyVO;

public interface QnaReplyDAO {
	
	List<QnaReplyVO> qnaReplyList(Long qno);
	
	void addQnaReply(QnaReplyVO qnaReplyVO);
	
	int updateCount(Long qno);

}
