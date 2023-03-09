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

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {

	@Autowired
	private BoardService boardService;

	// 게시물 목록
	@GetMapping(value = { "", "/", "/list" })
	public String list(Model model, @ModelAttribute("cri") Criteria criteria) {

		model.addAttribute("board_list", boardService.boardList(criteria));
		model.addAttribute("page", new Pagination(criteria, boardService.totalCount(criteria)));

		return "board/boardList";
	}
	
	// 게시물 조회
	@GetMapping("/detail")
	public String select(Model model, Long bno) {
		model.addAttribute("board", boardService.findByBno(bno));
		return "board/boardDeatil";
	}
	

}
