package com.toyProject.controller.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.toyProject.domain.qna.QnaReplyVO;
import com.toyProject.service.qna.QnaReplyService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/qnaReply")
@Log4j
public class QnaReplyController {

	@Autowired
	private QnaReplyService qnaReplyService;

	@GetMapping("/list")
	@ResponseBody
	public List<QnaReplyVO> qnaReplyList(@RequestParam("qno") Long qno) {
		List<QnaReplyVO> replyList = qnaReplyService.qnaReplyList(qno);
		return replyList;
	}

	@PostMapping("/add")
	@ResponseBody
	public String insert(@RequestBody QnaReplyVO qnaReplyVO) {
		qnaReplyService.addQnaReply(qnaReplyVO);
		return "댓글이 등록되었습니다 :)";
	}

	@PostMapping("/remove")
	@ResponseBody
	public String delete(@RequestParam("q_rno") Long q_rno, @RequestParam("qno") Long qno) {
		qnaReplyService.removeQnaReply(q_rno, qno);
		return "댓글이 삭제되었습니다 :)";
	}

}
