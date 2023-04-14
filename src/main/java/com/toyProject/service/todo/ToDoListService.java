package com.toyProject.service.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyProject.dao.todo.ToDoListDAO;
import com.toyProject.domain.paging.Criteria;
import com.toyProject.domain.todo.ToDoListVO;

@Service
public class ToDoListService {

	@Autowired
	private ToDoListDAO toDoListDAO;

	public List<ToDoListVO> toDoList(Criteria criteria) {
		return toDoListDAO.toDoList(criteria);
	}

	// 최근 목록 불러오기
	public List<ToDoListVO> recentToDoList() {
		return toDoListDAO.recentToDoList();
	}

}
