package com.sh.spring.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sh.spring.member.model.dto.Member;
import com.sh.spring.member.model.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/memberEnroll.do")
	public void memberEnroll() {} // /member/memberEnroll.do -> member/memberEnroll 
	
	
	@PostMapping("/memberEnroll.do")
	public String memberEnroll(Member member, RedirectAttributes redirectAttr) {
		System.out.println("member = " + member);
		int reasult = memberService.insertMember(member);
		return "redirect:/";
	}
}
