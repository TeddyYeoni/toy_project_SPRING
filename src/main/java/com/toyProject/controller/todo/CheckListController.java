package com.toyProject.controller.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.toyProject.domain.todo.CheckListVO;
import com.toyProject.service.todo.CheckListService;

@Controller
@RequestMapping("/checkList")
public class CheckListController {

	@Autowired
	private CheckListService checkListService;

	@GetMapping("/add")
	public void insert(CheckListVO checkListVO) {
		checkListService.addCheckList(checkListVO);
	}

}
