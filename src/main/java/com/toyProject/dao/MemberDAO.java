package com.toyProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.toyProject.domain.Criteria;
import com.toyProject.domain.MemberVO;
import com.toyProject.domain.MemberVO.MemberGrade;

public interface MemberDAO {
	
	// 회원 목록
	List<MemberVO> memberList(Criteria criteria);

	// 회원 추가
	void joinMember(MemberVO memberVO);

	// 회원 등급 조회
	MemberGrade findMemberGradeById(String id);

	// 로그인 확인
	String loginConfirm(@Param("id") String id, @Param("pwd") String pwd);

}
