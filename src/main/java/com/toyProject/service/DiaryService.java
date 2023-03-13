package com.toyProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyProject.dao.DiaryDao;
import com.toyProject.domain.DiaryVO;
import com.toyProject.domain.paging.Criteria;

@Service
public class DiaryService {
	
	@Autowired
	private DiaryDao diaryDao;
	
	// 다이어리 목록
	public List<DiaryVO> diaryList(Criteria criteria){
		return diaryDao.diaryList(criteria);
	}

	// 작성한 다이어리의 총 갯수
	public int totalCount(Criteria criteria) {
		return diaryDao.totalCount(criteria);
	}
	

}
