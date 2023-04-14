package com.toyProject.dao.diary;

import java.util.List;

import com.toyProject.domain.Criteria;
import com.toyProject.domain.board.BoardVO;
import com.toyProject.domain.diary.DiaryVO;

public interface DiaryDAO {

	// 다이어리 목록
	List<DiaryVO> diaryList(Criteria criteria);

	// 다이어리 조회
	DiaryVO findByDno(Long dno);

	// 다이어리 추가
	void addDiary(DiaryVO diaryVO);

	// 다이어리 수정
	void modifyDiary(DiaryVO diaryVO);

	// 다이어리 삭제
	void removeDiary(Long dno);

	// 총 게시물 수
	int totalCount(Criteria criteria);

	// 최근 목록 불러오기
	List<DiaryVO> recentDiaryList();

}
