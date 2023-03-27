package com.toyProject.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.toyProject.AppTest;
import com.toyProject.domain.DiaryVO;
import com.toyProject.domain.paging.Criteria;

import lombok.extern.log4j.Log4j;

@Log4j
public class DiaryDAOTest extends AppTest {

	@Autowired
	private DiaryDAO diaryDao;

	@Test
	@Ignore
	public void listTest() {
		Criteria criteria = new Criteria(1, 15);
		List<DiaryVO> diaryList = diaryDao.diaryList(criteria);
		log.info(diaryList);
	}

	@Test
	@Ignore
	public void insertTest() {
		DiaryVO diaryVO = DiaryVO.builder().id("관리자").content("test").praise("없음").thanks("모두").emotion("happy").weather("sunny").build();
		diaryDao.addDiary(diaryVO);
	}
	
	@Test
	@Ignore
	public void deleteTest() {
		Long dno = 2L;
		diaryDao.removeDiary(dno);
	}

}
