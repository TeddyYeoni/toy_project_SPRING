package com.toyProject.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.toyProject.dao.BoardDao;
import com.toyProject.domain.BoardVO;
import com.toyProject.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDao {

	@Autowired
	SqlSessionTemplate sessionTemplate;
	
	@Override
	public List<BoardVO> boardList(Criteria criteria) {
		return sessionTemplate.selectList("com.toyProeject.dao.BoardDao", criteria);
	}

	@Override
	public BoardVO findByBno(Long bno) {
		return null;
	}

	@Override
	public int getNewBno() {
		return 0;
	}

	@Override
	public int addContent() {
		return 0;
	}

	@Override
	public void modifyContent(BoardVO boardVO) {
	}

	@Override
	public void deleteContent(Long bno) {
	}

	@Override
	public int totalCount(Criteria criteria) {
		return 0;
	}

}
