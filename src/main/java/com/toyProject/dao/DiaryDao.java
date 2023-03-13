package com.toyProject.dao;

import java.util.List;

import com.toyProject.domain.BoardVO;
import com.toyProject.domain.DiaryVO;
import com.toyProject.domain.paging.Criteria;

public interface DiaryDao {

	// 다이어리 목록
	List<DiaryVO> diaryList(Criteria criteria);
	
	// 다이어리 조회
	DiaryVO findByDno(Long dno);
	
	// 다이어리 추가
	int addDiary();
	
	// 다이어리 수정
	void modifyDiary(DiaryVO diaryVO);
	
	// 다이어리 삭제
	void deleteDiary(Long dno);
	
	// 총 게시물 수
	int totalCount(Criteria criteria);

}
