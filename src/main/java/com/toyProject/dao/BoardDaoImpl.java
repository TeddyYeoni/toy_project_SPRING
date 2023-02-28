package com.toyProject.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.toyProject.domain.BoardVO;

public class BoardDaoImpl implements BoardDao {
	
	SqlSessionTemplate sessionTemplate;

	@Override
	public List<BoardVO> boardList() {
		return null;
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

}
