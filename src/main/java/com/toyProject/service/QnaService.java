package com.toyProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyProject.dao.QnaDAO;
import com.toyProject.domain.QnaVO;
import com.toyProject.domain.paging.Criteria;

@Service
public class QnaService {

	@Autowired
	private QnaDAO qnaDao;

	public List<QnaVO> qnaList(Criteria criteria) {
		return qnaDao.qnaList(criteria);
	}

	public int totalCount(Criteria criteria) {
		return qnaDao.totalCount(criteria);
	}
	
	public List<QnaVO> recentQnaList(){
		return qnaDao.recentQnaList();
	}
	
	public QnaVO findByQno(Long qno) {
		return qnaDao.findByQno(qno);
	}

}
