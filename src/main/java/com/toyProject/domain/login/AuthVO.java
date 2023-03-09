package com.toyProject.domain.login;

import com.toyProject.domain.login.MemberVO.MemberGrade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AuthVO {

	private String id;
	private MemberGrade grade;
	
}
