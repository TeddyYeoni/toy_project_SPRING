package com.toyProject.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.toyProject.AppTest;

public class BoardDaoTest extends AppTest{

	@Autowired
	BoardDao boardDao;
	
	@Test
	public void boardListTest() {
		boardDao.boardList();
	}

}
