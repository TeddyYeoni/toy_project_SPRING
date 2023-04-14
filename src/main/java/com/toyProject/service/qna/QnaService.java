package com.toyProject.service.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyProject.dao.qna.QnaDAO;
import com.toyProject.domain.paging.Criteria;
import com.toyProject.domain.qna.QnaVO;

@Service
public class QnaService {

	@Autowired
	private QnaDAO qnaDao;

	// 질문 목록
	public List<QnaVO> qnaList(Criteria criteria) {
		return qnaDao.qnaList(criteria);
	}

	// 총 게시물 수
	public int totalCount(Criteria criteria) {
		return qnaDao.totalCount(criteria);
	}

	// 질문 추가
	public void addQuestion(QnaVO qnaVO) {
		qnaDao.addQuestion(qnaVO);
	}

	// 최근 목록 불러오기
	public List<QnaVO> recentQnaList() {
		return qnaDao.recentQnaList();
	}

	// 질문 상세 조회
	public QnaVO findByQno(Long qno) {
		return qnaDao.findByQno(qno);
	}

	// 질문 삭제
	public void removeQuestion(Long qno) {
		qnaDao.removeQuestion(qno);
	}
	
}
