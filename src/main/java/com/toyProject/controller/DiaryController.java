package com.toyProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.toyProject.domain.DiaryVO;
import com.toyProject.domain.paging.Criteria;
import com.toyProject.domain.paging.Pagination;
import com.toyProject.service.BoardService;
import com.toyProject.service.DiaryService;

@Controller
@RequestMapping("/diary")
public class DiaryController {

	@Autowired
	private DiaryService diaryService;

	// 다이어리 목록
	@GetMapping(value = { "", "/", "/list" })
	public String list(Model model, @ModelAttribute("cri") Criteria criteria) {

		criteria = new Criteria(1, 12);

		model.addAttribute("diary_list", diaryService.diaryList(criteria));
		model.addAttribute("page", new Pagination(criteria, diaryService.totalCount(criteria)));

		return "diary/diaryList";
	}

	// 다이어리 작성 폼
	@GetMapping("/write")
	public String dairyForm() {
		return "diary/diaryWriteForm";
	}

	// 다이어리 조회
	@GetMapping("/detail")
	public String select(Model model, Long dno) {
		model.addAttribute("diary", diaryService.findByDno(dno));
		return "diary/diaryDetail";
	}

	@PostMapping("/write")
	public String insert(RedirectAttributes rttr, DiaryVO diaryVO) {
		diaryService.addDiary(diaryVO);
		return "redirect:diary/diaryList";
	}
	
	@GetMapping("/remove")
	public String delete(Long dno, RedirectAttributes rttr) {
		diaryService.removeDiary(dno);
		return "redirect:diary/diaryList";
	}

}
