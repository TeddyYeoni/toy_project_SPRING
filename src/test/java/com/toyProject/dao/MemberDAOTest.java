package com.toyProject.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.toyProject.AppTest;
import com.toyProject.domain.login.MemberVO;
import com.toyProject.service.MemberService;

public class MemberDAOTest extends AppTest {
	
	@Autowired
	MemberService memberService;

	@Test
	public void insertTest() {
		MemberVO memberVO = MemberVO.builder().id("testId").pwd("1234").name("tester").email("test@email.com").build();
		memberService.joinMember(memberVO);
	}

}
