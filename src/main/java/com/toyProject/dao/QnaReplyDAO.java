package com.toyProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.toyProject.domain.QnaReplyVO;

public interface QnaReplyDAO {
	
	// 댓글 목록
	List<QnaReplyVO> qnaReplyList(Long qno);
	
	// 댓글 추가
	void addQnaReply(QnaReplyVO qnaReplyVO);
	
	// 댓글 갯수 +
	void updateCountPlus(Long qno);

	// 댓글 삭제
	void removeQnaReply(@Param("q_rno") Long q_rno,@Param("qno") Long qno);
	
	// 댓글 갯수 -
	void updateCountMinus(Long qno);
}
