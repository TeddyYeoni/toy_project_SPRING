package com.toyProject.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.toyProject.domain.BoardVO;
import com.toyProject.domain.Criteria;

public interface BoardDao {

	// 게시글 목록
	List<BoardVO> boardList(Criteria criteria);
	
	// 게시글 상세
	BoardVO findByBno(Long bno);
	
	// 새로운 bno 생성
	int getNewBno();
	
	// 게시글 추가
	int addContent();
	
	// 게시글 수정
	void modifyContent(BoardVO boardVO);
	
	// 게시글 삭제
	void deleteContent(Long bno);
	
	// 총 게시물 수
	int totalCount(Criteria criteria);

	// 최근 게시물 목
	List<BoardVO> recentBoardList();

	
}
