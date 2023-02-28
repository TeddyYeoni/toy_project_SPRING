package com.toyProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.toyProject.dao.BoardDao;
import com.toyProject.domain.BoardVO;

@Repository
public class BoardService {
	
	@Autowired
	BoardDao boardDao;
	
	public List<BoardVO> lookUpList(){
		return boardDao.boardList();
	}

}
