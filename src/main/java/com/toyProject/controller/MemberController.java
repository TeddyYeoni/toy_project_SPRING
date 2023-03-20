package com.toyProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.toyProject.domain.login.MemberVO;
import com.toyProject.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService memberService;

	@GetMapping(value = { "", "/", "/login" })
	public String loginForm() {
		return "member/loginForm";
	}

	@GetMapping("/join")
	public String joinForm() {
		return "member/joinForm";
	}

	@PostMapping("/join")
	public String insert(RedirectAttributes rttr, MemberVO memberVO) {
		memberService.joinMember(memberVO);
		return "redirect:/main";
	}

	@PostMapping("/login")
	public String login(RedirectAttributes rttr, String id, String pwd) {
		memberService.loginConfirm(id, pwd);
		return "redirect:/main";
	}

}
