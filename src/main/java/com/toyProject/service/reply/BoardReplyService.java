package com.toyProject.service.reply;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toyProject.dao.reply.BoardReplyDAO;
import com.toyProject.domain.BoardReplyVO;

@Service
public class BoardReplyService {

	@Autowired
	private BoardReplyDAO boardReplyDAO;
	
	public List<BoardReplyVO> boardReplyList(Long bno){
		return boardReplyDAO.boardReplyList(bno);
	}
	
	// 댓글 추가
	@Transactional
	public void addBoardReply(BoardReplyVO boardReplyVO) {
		boardReplyDAO.addBoardReply(boardReplyVO);
		boardReplyDAO.updateCountPlus(boardReplyVO.getBno());
	}
	
	// 댓글 삭제
	@Transactional
	public void removeBoardReply(@Param("b_rno") Long b_rno,@Param("bno") Long bno) {
		boardReplyDAO.removeBoardReply(b_rno, bno);
		boardReplyDAO.updateCountMinus(bno);
	}
	
	// 댓글 수정
	@Transactional
	public void modifyBoardReply(BoardReplyVO boardReplyVO) {
		boardReplyDAO.modifyBoardReply(boardReplyVO);
	}
	
	// 댓글 상세
	@Transactional
	public BoardReplyVO boardReplyDetail(Long b_rno) {
		return boardReplyDAO.boardReplyDetail(b_rno);
	}
	
}
