package com.toyProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyProject.dao.MemberDAO;
import com.toyProject.domain.login.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public void joinMember(MemberVO memberVO) {
		memberDAO.joinMember(memberVO);
	}

}
