package com.toyProject.dao;

import org.apache.ibatis.annotations.Param;

import com.toyProject.domain.login.MemberVO;
import com.toyProject.domain.login.MemberVO.MemberGrade;

public interface MemberDAO {

	// 회원 추가
	void joinMember(MemberVO memberVO);

	// 회원 등급 조회
	MemberGrade findMemberGradeById(String id);

	// 로그인 확인
	String loginConfirm(@Param("id") String id, @Param("pwd") String pwd);

}
