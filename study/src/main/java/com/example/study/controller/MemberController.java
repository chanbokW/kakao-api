package com.example.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.study.domain.Member;
import com.example.study.dto.MemberDto;
import com.example.study.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/member/joinForm")
	public String joinform() {
		System.out.println("check");
		return "member/joinForm";
	}
	
	@PostMapping("/member/create")
	public String join(MemberDto dto) {

		Member member = dto.toEntity();
		
		memberService.registerMember(member);
		return "redirect:/index";
	}
}
