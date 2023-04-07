package com.toyProject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.toyProject.domain.login.AuthVO;
import com.toyProject.domain.login.MemberVO;
import com.toyProject.domain.login.MemberVO.MemberGrade;
import com.toyProject.domain.paging.Criteria;
import com.toyProject.service.MemberService;

import lombok.extern.log4j.Log4j;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/member")
@Log4j
public class MemberController {

	@Autowired
	MemberService memberService;

	@GetMapping("/list")
	public String select(Model model, Criteria criteria) {
		List<MemberVO> memberList = memberService.memberList(criteria);
		model.addAttribute("member", memberList);
		return "member/memberList";
	}
	
	
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
	public String login(Model model, @RequestParam String id, @RequestParam String pwd, MemberVO memberVO,
			HttpServletRequest request, RedirectAttributes rttr) {
		boolean loginResult = memberService.loginConfirm(id, pwd);
		memberVO.setId(id);
		memberVO.setPwd(pwd);

		if (loginResult) {
			HttpSession session = request.getSession();
			MemberGrade grade = memberService.findMemberGradeById(memberVO.getId());
			AuthVO authVO = new AuthVO();
			authVO.setId(memberVO.getId());
			authVO.setGrade(grade);
			session.setAttribute("auth", authVO);

			String userUri = (String) session.getAttribute("userUri");
			if (userUri != null) {
				session.removeAttribute(userUri);
				return "redirect:" + userUri;
			}
			return "redirect:/main";
		} else {
			System.out.println("아이디 비ㅣㅁㄹ번호를 잘못 입력했슈");
			return "member/loginForm";
		}

	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request, RedirectAttributes rttr) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute("auth");
			session.invalidate();
		}
		log.info("로그아웃 성공");
		return "redirect:/main";
	}
	

}
