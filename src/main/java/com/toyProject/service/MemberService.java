package com.toyProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyProject.dao.MemberDAO;
import com.toyProject.domain.login.MemberVO;
import com.toyProject.domain.login.MemberVO.MemberGrade;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	// 회원 가입
	public void joinMember(MemberVO memberVO) {
		memberDAO.joinMember(memberVO);
	}
	
	// 회원등급 조회
	public MemberGrade findMemberGradeById(String id) {
		return memberDAO.findMemberGradeById(id);
	}

}
