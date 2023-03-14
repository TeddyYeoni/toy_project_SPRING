package com.toyProject.dao;

import java.util.List;

import com.toyProject.domain.QnaVO;
import com.toyProject.domain.paging.Criteria;

public interface QnaDAO {
	
	// 질문 목록
	List<QnaVO> qnaList(Criteria criteria);
	
	// 질문 조회
	QnaVO findByQno(Long qno);
	
	// 마지막 질문 번호 조회
	int getLastQno();
	
	// 질문 추가
	int addQuestion();
	
	// 질문 수정
	void modifyQuestion();
	
	// 질문 삭제 
	void removeQuestion();

	// 총 게시물 수
	int totalCount(Criteria criteria);
	
	// 최근 질문 목록
	List<QnaVO> recentQnaList();
	
}
