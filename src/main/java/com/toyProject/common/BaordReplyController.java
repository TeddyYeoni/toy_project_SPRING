package com.toyProject.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.toyProject.domain.BoardReplyVO;
import com.toyProject.service.BoardReplyService;

@Controller
@RequestMapping("/boardReply")
public class BaordReplyController {

	@Autowired
	private BoardReplyService boardReplyService;

	@GetMapping("/list")
	void boardReplyList(Model model, Long bno) {
		List<BoardReplyVO> boardReplyList = boardReplyService.boardReplyList(bno);
		model.addAttribute("boardReply", boardReplyList);
	}

}
