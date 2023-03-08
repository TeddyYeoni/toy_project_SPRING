package com.toyProject.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.toyProject.AppTest;
import com.toyProject.domain.BoardVO;
import com.toyProject.domain.Criteria;

import lombok.extern.log4j.Log4j;

public class BoardDaoTest extends AppTest{

	@Autowired
	BoardDao boardDao;
	
	@Test
	public void boardListTest() {
		Criteria criteria = new Criteria();
		List<BoardVO> boardList = boardDao.boardList(criteria);
		System.out.println(boardList);
	}

}
