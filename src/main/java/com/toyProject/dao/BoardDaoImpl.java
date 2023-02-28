package com.toyProject.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.toyProject.domain.BoardVO;

import lombok.AllArgsConstructor;


@Repository
@AllArgsConstructor
public class BoardDaoImpl implements BoardDao {
	
	SqlSessionTemplate sessionTemplate;

	@Override
	public List<BoardVO> boardList() {
		return sessionTemplate.selectList("com.toyProject.dao.BoardDao.boardList");
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
