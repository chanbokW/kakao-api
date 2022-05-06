package com.example.study.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.study.domain.Member;
import com.example.study.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	
	private final MemberRepository memberRepository;
	
	@Transactional
	public Long registerMember(Member member) {
		memberRepository.save(member);
		return member.getId();
	}
	
	
}
