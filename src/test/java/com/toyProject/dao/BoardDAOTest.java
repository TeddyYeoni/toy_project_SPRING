package com.toyProject.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.toyProject.AppTest;
import com.toyProject.domain.BoardVO;
import com.toyProject.domain.paging.Criteria;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardDAOTest extends AppTest{

	@Autowired
	BoardDAO boardDao;
	
	@Test
	public void boardListTest() {
		Criteria criteria = new Criteria();
		List<BoardVO> boardList = boardDao.boardList(criteria);
		System.out.println(boardList);
	}

}
