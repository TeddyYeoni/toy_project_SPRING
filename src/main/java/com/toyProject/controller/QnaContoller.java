package com.toyProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.toyProject.domain.paging.Criteria;
import com.toyProject.domain.paging.Pagination;
import com.toyProject.service.QnaService;

@Controller
@RequestMapping("/qna")
public class QnaContoller {

	@Autowired
	private QnaService qnaService;

	@GetMapping(value = { "", "/", "/qna" })
	public String list(Model model, @ModelAttribute("cri") Criteria criteria) {
		model.addAttribute("qna_list", qnaService.qnaList(criteria));
		model.addAttribute("page", new Pagination(criteria, qnaService.totalCount(criteria)));
		return "qna/qnaList";
	}

}
