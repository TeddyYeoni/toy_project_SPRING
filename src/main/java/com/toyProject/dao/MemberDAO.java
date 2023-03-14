package com.toyProject.dao;

import com.toyProject.domain.login.MemberVO;

public interface MemberDAO {
	
	// 회원 추가
	void joinMember(MemberVO memberVO);

}
