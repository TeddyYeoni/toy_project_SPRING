package com.toyProject.controller.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.toyProject.domain.ToDoListVO;
import com.toyProject.domain.paging.Criteria;
import com.toyProject.service.menu.ToDoListService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/todo")
@Log4j
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

	@PostMapping("/add")
	@ResponseBody
	public String insert(ToDoListVO toDoListVO,@RequestParam("checkNum") Long checkNumber, RedirectAttributes rttr) {
		log.info("체크리스트 갯수 : " + checkNumber);
		return "redirect:/todo";
	}

}
