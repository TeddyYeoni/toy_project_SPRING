package com.toyProject.dao.board;

import java.util.List;

import com.toyProject.domain.board.BoardVO;
import com.toyProject.domain.paging.Criteria;

public interface BoardDAO {

	// 게시글 목록
	List<BoardVO> boardList(Criteria criteria);
	
	// 게시글 조회
	BoardVO findByBno(Long bno);
	
	// 마지막 게시물 번호 조회
	String getLastBno();
	
	// 게시글 추가
	int addContent(BoardVO boardVO);
	
	// 게시글 수정
	void modifyContent(BoardVO boardVO);
	
	// 게시글 삭제
	void removeContent(Long bno);
	
	// 총 게시물 수
	int totalCount(Criteria criteria);

	// 최근 게시물 목록
	List<BoardVO> recentBoardList();

	// 게시글 수정(첨부파일 제외)
	void modifyOnlyContent(BoardVO boardVO);

	
}
