package com.toyProject.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.toyProject.dao.board.BoardDAO;
import com.toyProject.domain.Criteria;
import com.toyProject.domain.board.BoardVO;

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
		int boardNO = 0;
		int lastBoardNO;
		
		if(boardDao.getLastBno() == null) {
			lastBoardNO = 0;
			return 1;
		}
		
		lastBoardNO = Integer.parseInt(boardDao.getLastBno());
		boardNO = lastBoardNO + 1;
		return boardNO;
	}

	// 게시물 작성
	public int write(BoardVO boardVO) {
		int boardNO = getNewBno();
		boardVO.setBno((long) boardNO);
		return boardDao.addContent(boardVO);
	}
	
	// 게시물 수정
	public void modifyContent(BoardVO boardVO) {
		boardDao.modifyContent(boardVO);
	}

	public void modifyOnlyContent(BoardVO boardVO) {
		boardDao.modifyOnlyContent(boardVO);
	}
	
	// 게시물 삭제
	public void removeContent(Long bno) {
		boardDao.removeContent(bno);
	}
	
}
