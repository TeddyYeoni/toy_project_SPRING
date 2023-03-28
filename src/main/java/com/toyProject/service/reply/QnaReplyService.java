package com.toyProject.service.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	public void addQnaReply(QnaReplyVO qnaReplyVO) {
		qnaReplyDAO.addQnaReply(qnaReplyVO);
		qnaReplyDAO.updateCount(qnaReplyVO.getQno());
	}
	
	
}
