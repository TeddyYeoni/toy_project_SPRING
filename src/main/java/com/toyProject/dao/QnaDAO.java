package com.toyProject.dao;

import java.util.List;

import com.toyProject.domain.QnaVO;
import com.toyProject.domain.paging.Criteria;

public interface QnaDAO {
	
	// 질문 목록
	List<QnaVO> qnaList(Criteria criteria);
	
	// 질문 추가
	void addQuestion(QnaVO qnaVO);

	// 질문 조회
	QnaVO findByQno(Long qno);
	
	// 질문 삭제 
	void removeQuestion(Long qno);

	// 총 게시물 수
	int totalCount(Criteria criteria);
	
	// 최근 질문 목록
	List<QnaVO> recentQnaList();
	
}
