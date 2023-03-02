package com.toyProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.toyProject.domain.Criteria;
import com.toyProject.domain.Pagination;
import com.toyProject.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;

	@GetMapping(value = { "/", "/list" })
	public String list(Model model) {
		model.addAttribute("board_list", boardService.lookUpList());
		return "board/list";
	}

}
