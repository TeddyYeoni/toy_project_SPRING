package com.toyProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyProject.dao.CheckListDAO;
import com.toyProject.domain.CheckListVO;

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
