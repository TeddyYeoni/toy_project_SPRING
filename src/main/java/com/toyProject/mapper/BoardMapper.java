package com.toyProject.mapper;

import java.util.List;

import com.toyProject.domain.BoardVO;
import com.toyProject.domain.Criteria;

public interface BoardMapper {
	
	List<BoardVO> boardList();
	
	int getTotalCount(Criteria criteria);
	
}
