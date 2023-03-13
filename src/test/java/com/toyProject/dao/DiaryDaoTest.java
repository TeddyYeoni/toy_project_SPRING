package com.toyProject.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.toyProject.AppTest;
import com.toyProject.domain.DiaryVO;
import com.toyProject.domain.paging.Criteria;

import lombok.extern.log4j.Log4j;

@Log4j
public class DiaryDaoTest extends AppTest{
	
	@Autowired
	private DiaryDao diaryDao;

	@Test
	public void test() {
		Criteria criteria = new Criteria(1,15);
		List<DiaryVO> diaryList = diaryDao.diaryList(criteria);
		log.info(diaryList);
	}

}
