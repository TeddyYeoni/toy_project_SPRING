package com.toyProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.toyProject.dao.BoardDAO;
import com.toyProject.domain.BoardVO;
import com.toyProject.domain.paging.Criteria;

@Service
public class BoardService {

	@Autowired
	private BoardDAO boardDao;
	
	// 게시물 목록
	public List<BoardVO> boardList(Criteria criteria){
		return boardDao.boardList(criteria);
	}
	
	// 총 게시물 수
	public int totalCount(Criteria criteria) {
		return boardDao.totalCount(criteria);
	}

	// 최근 게시물 목록(5개)
	public List<BoardVO> recentBoardList() {
		return boardDao.recentBoardList();
	}
	
	// bno로 게시물 조회
	public BoardVO findByBno(Long bno) {
		return boardDao.findByBno(bno);
	}
	
	// 새로운 bno 생성
	public int getNewBno() {
		int newBno = 0;
		int boardNO = boardDao.getLastBno();
		newBno = boardNO + 1;
		if(newBno == 0) {
			newBno = 1;
		} 
		return newBno;
	}
	
	
}
