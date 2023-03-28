package com.toyProject.controller.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.toyProject.domain.QnaReplyVO;
import com.toyProject.service.reply.QnaReplyService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/qnaReply")
@Log4j
public class QnaReplyController {

	@Autowired
	private QnaReplyService qnaReplyService;

	@GetMapping("/list")
	public String qnaReplyList(Model model, Long qno) {
		List<QnaReplyVO> replyList = qnaReplyService.qnaReplyList(qno);
		model.addAttribute("replyList", replyList);
		return "list";
	}

}
