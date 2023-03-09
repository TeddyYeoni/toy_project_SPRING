package com.toyProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.toyProject.dao.BoardDao;
import com.toyProject.domain.BoardVO;
import com.toyProject.domain.Criteria;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;
	
	public List<BoardVO> boardList(Criteria criteria){
		return boardDao.boardList(criteria);
	}
	
	public int totalCount(Criteria criteria) {
		return boardDao.totalCount(criteria);
	}

	public List<BoardVO> recentBoardList() {
		return boardDao.recentBoardList();
	}
	
	public BoardVO findByBno(Long bno) {
		return boardDao.findByBno(bno);
	}
	
	
}
