package com.toyProject.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.toyProject.AppTest;
import com.toyProject.domain.MemberVO;
import com.toyProject.domain.MemberVO.MemberGrade;
import com.toyProject.service.MemberService;

public class MemberDAOTest extends AppTest {
	
	@Autowired
	MemberService memberService;

	@Test
	@Ignore
	public void insertTest() {
		MemberVO memberVO = MemberVO.builder().id("testId").pwd("1234").name("tester").email("test@email.com").build();
		memberService.joinMember(memberVO);
	}
	
	@Test
	@Ignore
	public void findGradeTest() {
		String id = "pponyo";
		MemberGrade gradeById = memberService.findMemberGradeById(id);
		System.out.println(gradeById);
	}
	
	@Test
	public void loginConfirmTest() {
		String id = "pponyo";
		String pwd = "1234";
		boolean loginResult = memberService.loginConfirm(id, pwd);
		System.out.println(loginResult);
	}

}
