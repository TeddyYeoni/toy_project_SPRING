package com.toyProject.dao;

import com.toyProject.domain.CheckListVO;

public interface CheckListDAO {

	// checkList 추가
	void addCheckList(CheckListVO checkListVO);

	// checkList 삭제
	void removeCheckList(Long cno);

}
