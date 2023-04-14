package com.toyProject.controller.diary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.toyProject.domain.Criteria;
import com.toyProject.domain.Pagination;
import com.toyProject.domain.diary.DiaryVO;
import com.toyProject.service.diary.DiaryService;

@Controller
@RequestMapping("/diary")
public class DiaryController {

	@Autowired
	private DiaryService diaryService;

	// 다이어리 목록
	@GetMapping(value = { "", "/", "/list" })
	public String list(Model model, @ModelAttribute("cri") Criteria criteria) {
		criteria.setPagingAmount(9);
		
		model.addAttribute("page", new Pagination(criteria, diaryService.totalCount(criteria)));
	    model.addAttribute("diary_list", diaryService.diaryList(criteria));
		
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
		return "redirect:/diary";
	}

	// 다이어리 삭제
	@PostMapping("/remove")
	public String delete(Long dno, RedirectAttributes rttr) {
		diaryService.removeDiary(dno);
		return "redirect:/diary";
	}
	
	@GetMapping("/modify")
	public void modifyForm(Long dno, Model model) {
		DiaryVO diaryVO = diaryService.findByDno(dno);
		model.addAttribute("mod_board", diaryVO);
	}
	
	@PostMapping("/modify")
	public String modify(DiaryVO diaryVO, RedirectAttributes rttr) {
		diaryService.modifyDiary(diaryVO);
		return "redirect:/diary";
	}

}
