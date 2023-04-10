package com.toyProject.dao.reply;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.toyProject.domain.BoardReplyVO;

public interface BoardReplyDAO {
	
	// 댓글 목록
	List<BoardReplyVO> boardReplyList(Long bno);
	
	// 댓글 추가
	void addBoardReply(BoardReplyVO boardReplyVO);
	
	// 댓글 개수 +
	void updateCountPlus(Long bno);
	
	// 댓글 삭제
	void removeBoardReply(@Param("b_rno") Long b_rno,@Param("bno") Long bno);

	// 댓글 개수-
	void updateCountMinus(Long bno);
	
	// 댓글 수정
	void modifyBoardReply(BoardReplyVO boardReplyVO);
	
	// 댓글 상세
	BoardReplyVO boardReplyDetail(Long b_rno);
	
}
