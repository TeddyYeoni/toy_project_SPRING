package com.toyProject.dao;

import java.util.List;

import com.toyProject.domain.ToDoListVO;
import com.toyProject.domain.paging.Criteria;

public interface ToDoListDAO {
	
	List<ToDoListVO> toDoList(Criteria criteria);

}
