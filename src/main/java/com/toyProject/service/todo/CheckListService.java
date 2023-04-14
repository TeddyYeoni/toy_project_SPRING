package com.toyProject.service.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyProject.dao.todo.CheckListDAO;
import com.toyProject.domain.todo.CheckListVO;

@Service
public class CheckListService {

	@Autowired
	private CheckListDAO checkListDAO;

	// checkList 추가
	public void addCheckList(CheckListVO checkListVO) {
		checkListDAO.addCheckList(checkListVO);
	}

	// checkList 삭제
	public void removeCheckList(Long cno) {
		checkListDAO.removeCheckList(cno);
	}

}
