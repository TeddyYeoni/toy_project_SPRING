package com.toyProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.toyProject.domain.paging.Criteria;
import com.toyProject.service.ToDoListService;

@Controller
@RequestMapping("/todo")
public class ToDoListContoller {

	@Autowired
	private ToDoListService toDoListService;

	@GetMapping(value = { "", "/", "/list" })
	public String toDoList(Model model, Criteria criteria) {
		toDoListService.toDoList(criteria);
		return "toDoList/toDoList";
	}
	
	@GetMapping("/add")
	public String addForm() {
		return "toDoList/toDoAddForm";
	}

}
