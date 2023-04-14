package com.toyProject.controller.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.toyProject.domain.paging.Criteria;
import com.toyProject.domain.paging.Pagination;
import com.toyProject.domain.qna.QnaVO;
import com.toyProject.service.qna.QnaService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/qna")
public class QnaContoller {

	@Autowired
	private QnaService qnaService;

	// 질문 목록
	@GetMapping(value = { "", "/", "/qna" })
	public String list(Model model, @ModelAttribute("cri") Criteria criteria) {
		model.addAttribute("qna_list", qnaService.qnaList(criteria));
		model.addAttribute("page", new Pagination(criteria, qnaService.totalCount(criteria)));
		return "qna/qnaList";
	}

	// 질문 작성 폼
	@GetMapping("/add")
	public String addQuestion() {
		return "qna/qnaAddForm";
	}

	// 게시글 추가 처리
	@PostMapping("/add")
	public String insert(QnaVO qnaVO, RedirectAttributes rttr) {
		qnaService.addQuestion(qnaVO);
		return "redirect:/qna";
	}

	// 질문 상세 조회
	@GetMapping("/detail")
	public String select(Model model, Long qno) {
		model.addAttribute("qna", qnaService.findByQno(qno));
		return "qna/qnaDetail";
	}

	// 게시글 삭제
	@PostMapping("/remove")
	public String delete(Long qno, RedirectAttributes rttr) {
		qnaService.removeQuestion(qno);
		return "redirect:/qna";
	}
	
}