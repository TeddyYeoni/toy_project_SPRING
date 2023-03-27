package com.toyProject.controller.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.toyProject.domain.QnaVO;
import com.toyProject.domain.paging.Criteria;
import com.toyProject.domain.paging.Pagination;
import com.toyProject.service.menu.QnaService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/qna")
@Log4j
public class QnaContoller {

	@Autowired
	private QnaService qnaService;

	@GetMapping(value = { "", "/", "/qna" })
	public String list(Model model, @ModelAttribute("cri") Criteria criteria) {
		model.addAttribute("qna_list", qnaService.qnaList(criteria));
		model.addAttribute("page", new Pagination(criteria, qnaService.totalCount(criteria)));
		return "qna/qnaList";
	}

	@GetMapping("/add")
	public String addQuestion() {
		return "qna/qnaAddForm";
	}

	@PostMapping("/add")
	public String insert(QnaVO qnaVO, RedirectAttributes rttr) {
		qnaService.addQuestion(qnaVO);
		return "redirect:/qna";
	}

	@GetMapping("/detail")
	public String select(Model model, Long qno) {
		model.addAttribute("qna", qnaService.findByQno(qno));
		return "qna/qnaDetail";
	}

}
