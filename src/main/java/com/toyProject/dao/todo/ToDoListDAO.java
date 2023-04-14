package com.toyProject.dao.todo;

import java.util.List;

import com.toyProject.domain.paging.Criteria;
import com.toyProject.domain.todo.ToDoListVO;

public interface ToDoListDAO {

	// 할 일 목록
	List<ToDoListVO> toDoList(Criteria criteria);

	// 최근 목록 불러오기
	List<ToDoListVO> recentToDoList();

}
