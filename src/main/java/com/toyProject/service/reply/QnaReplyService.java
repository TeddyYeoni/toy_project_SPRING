package com.toyProject.service.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyProject.dao.BoardReplyDAO;
import com.toyProject.dao.QnaReplyDAO;
import com.toyProject.domain.BoardReplyVO;
import com.toyProject.domain.QnaReplyVO;

@Service
public class QnaReplyService {

	@Autowired
	private QnaReplyDAO qnaReplyDAO;
	
	public List<QnaReplyVO> qnaReplyList(Long qno){
		return qnaReplyDAO.qnaReplyList(qno);
	}
	
	public void addQnaReply(QnaReplyVO qnaReplyVO) {
		qnaReplyDAO.addQnaReply(qnaReplyVO);
	}
	
	public int updateCount(Long qno) {
		return qnaReplyDAO.updateCount(qno);
	}
	
}
