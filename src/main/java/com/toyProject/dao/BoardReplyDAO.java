package com.toyProject.dao;

import java.util.List;

import com.toyProject.domain.BoardReplyVO;

public interface BoardReplyDAO {
	
	List<BoardReplyVO> boardReplyList(Long bno);

}
