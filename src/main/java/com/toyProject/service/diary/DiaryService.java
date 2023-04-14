package com.toyProject.service.diary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyProject.dao.diary.DiaryDAO;
import com.toyProject.domain.diary.DiaryVO;
import com.toyProject.domain.paging.Criteria;

@Service
public class DiaryService {

	@Autowired
	private DiaryDAO diaryDao;

	// 다이어리 목록
	public List<DiaryVO> diaryList(Criteria criteria) {
		return diaryDao.diaryList(criteria);
	}

	// 작성한 다이어리의 총 갯수
	public int totalCount(Criteria criteria) {
		return diaryDao.totalCount(criteria);
	}

	// 다이어리 조회
	public DiaryVO findByDno(Long dno) {
		return diaryDao.findByDno(dno);
	}

	// 다이어리 추가
	public void addDiary(DiaryVO diaryVO) {
		diaryDao.addDiary(diaryVO);
	}

	// 다이어리 삭제
	public void removeDiary(Long dno) {
		diaryDao.removeDiary(dno);
	}

	// 다이어리 수정
	public void modifyDiary(DiaryVO diaryVO) {
		diaryDao.modifyDiary(diaryVO);
	}

	// 최근 목록 불러오기
	public List<DiaryVO> recentDiaryList() {
		return diaryDao.recentDiaryList();
	}

}
