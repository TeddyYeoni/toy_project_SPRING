package com.toyProject.dao;

import com.toyProject.domain.login.MemberVO;
import com.toyProject.domain.login.MemberVO.MemberGrade;

public interface MemberDAO {
	
	// 회원 추가
	void joinMember(MemberVO memberVO);
	
	// 회원 등급 조회
	MemberGrade findMemberGradeById(String id);

}
