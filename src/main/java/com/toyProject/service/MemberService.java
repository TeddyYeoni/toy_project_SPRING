package com.toyProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyProject.dao.MemberDAO;
import com.toyProject.domain.login.MemberVO;
import com.toyProject.domain.login.MemberVO.MemberGrade;
import com.toyProject.domain.paging.Criteria;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	// 회원 목록
	public List<MemberVO> memberList(Criteria criteria){
		return memberDAO.memberList(criteria);
	}

	// 회원 가입
	public void joinMember(MemberVO memberVO) {
		memberDAO.joinMember(memberVO);
	}

	// 회원등급 조회
	public MemberGrade findMemberGradeById(String id) {
		return memberDAO.findMemberGradeById(id);
	}

	// 로그인 확인
	public boolean loginConfirm(String id, String pwd) {
		String loginConfirm = memberDAO.loginConfirm(id, pwd);
		Boolean loginResult = Boolean.parseBoolean(loginConfirm);
		return loginResult;
	}

}
