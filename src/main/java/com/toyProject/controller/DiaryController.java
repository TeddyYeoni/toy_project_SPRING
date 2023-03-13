package com.toyProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.toyProject.domain.paging.Criteria;
import com.toyProject.domain.paging.Pagination;
import com.toyProject.service.BoardService;
import com.toyProject.service.DiaryService;

@Controller
@RequestMapping("/diary")
public class DiaryController {

	@Autowired
	private DiaryService diaryService;

	@GetMapping(value = { "", "/", "/list" })
	public String diaryList(Model model, @ModelAttribute("cri") Criteria criteria) {
		
		criteria = new Criteria(1,12);
		
		model.addAttribute("diary_list", diaryService.diaryList(criteria));
		model.addAttribute("page", new Pagination(criteria, diaryService.totalCount(criteria)));
		
		return "diary/diaryList";
	}

}
