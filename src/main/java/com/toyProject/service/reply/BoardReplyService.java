package com.toyProject.service.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyProject.dao.BoardReplyDAO;
import com.toyProject.domain.BoardReplyVO;

@Service
public class BoardReplyService {

	@Autowired
	private BoardReplyDAO boardReplyDAO;
	
	public List<BoardReplyVO> boardReplyList(Long bno){
		return boardReplyDAO.boardReplyList(bno);
	}
	
}
