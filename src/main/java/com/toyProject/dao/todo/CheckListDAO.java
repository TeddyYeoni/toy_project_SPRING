package com.toyProject.dao.todo;

import com.toyProject.domain.todo.CheckListVO;

public interface CheckListDAO {

	// checkList 추가
	void addCheckList(CheckListVO checkListVO);

	// checkList 삭제
	void removeCheckList(Long cno);

}
