package com.toyProject.service.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toyProject.dao.board.BoardReplyDAO;
import com.toyProject.dao.qna.QnaReplyDAO;
import com.toyProject.domain.board.BoardReplyVO;
import com.toyProject.domain.qna.QnaReplyVO;

@Service
public class QnaReplyService {

	@Autowired
	private QnaReplyDAO qnaReplyDAO;
	
	// 댓글 목록
	public List<QnaReplyVO> qnaReplyList(Long qno){
		return qnaReplyDAO.qnaReplyList(qno);
	}
	
	// 댓글 추가
	@Transactional
	public void addQnaReply(QnaReplyVO qnaReplyVO) {
		qnaReplyDAO.addQnaReply(qnaReplyVO);
		qnaReplyDAO.updateCountPlus(qnaReplyVO.getQno());
	}
	
	// 댓글 삭제
	@Transactional
	public void removeQnaReply(Long q_rno, Long qno) {
		qnaReplyDAO.removeQnaReply(q_rno, qno);
		qnaReplyDAO.updateCountMinus(qno);
	}
	
	
}
