package com.toyProject.service.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyProject.dao.ToDoListDAO;
import com.toyProject.domain.ToDoListVO;
import com.toyProject.domain.paging.Criteria;

@Service
public class ToDoListService {
	
	@Autowired
	private ToDoListDAO toDoListDAO;
	
	
	public List<ToDoListVO> toDoList(Criteria criteria){
		return toDoListDAO.toDoList(criteria);
	}

}
