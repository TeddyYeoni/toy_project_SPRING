package com.toyProject.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.toyProject.AppTest;
import com.toyProject.domain.login.MemberVO;
import com.toyProject.domain.login.MemberVO.MemberGrade;
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
	public void findGradeTest() {
		String id = "testId";
		MemberGrade gradeById = memberService.findMemberGradeById(id);
		System.out.println(gradeById);
	}

}
