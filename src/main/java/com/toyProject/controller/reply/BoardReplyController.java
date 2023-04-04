package com.toyProject.controller.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.toyProject.domain.BoardReplyVO;
import com.toyProject.service.reply.BoardReplyService;

@Controller
@RequestMapping("/boardReply")
public class BoardReplyController {

	@Autowired
	private BoardReplyService boardReplyService;

	@GetMapping("/list")
	@ResponseBody
	public List<BoardReplyVO> boardReplyList(@RequestParam("bno") Long bno) {
		List<BoardReplyVO> boardReplyList = boardReplyService.boardReplyList(bno);
		return boardReplyList;
	}

}