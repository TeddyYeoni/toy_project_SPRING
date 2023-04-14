package com.toyProject.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.toyProject.AppTest;
import com.toyProject.domain.qna.QnaReplyVO;
import com.toyProject.service.qna.QnaReplyService;

import lombok.extern.log4j.Log4j;

@Log4j
public class QnaDAOTest extends AppTest {
	
	@Autowired
	QnaReplyService qnaReplyService;

	@Test
	public void listTest() {
		Long qno = 205L;
		List<QnaReplyVO> qnaReplyList = qnaReplyService.qnaReplyList(qno);
		log.info("댓글 목록 : " + qnaReplyList);
	}

}
