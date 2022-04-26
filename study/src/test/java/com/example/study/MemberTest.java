package com.example.study;

import static org.assertj.core.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;

import test.Member;
import test.MemberRepository;


public class MemberTest {
	
	MemberRepository memberRepository;
	
	@Test
	@Transactional
	@Rollback(false)
	@DisplayName("회원가입 및 회원 찾기")
	public void memberTest() {

		Member member = new Member("id001","pw001");
		Long id= memberRepository.save(member);
		Member result = memberRepository.find(id);
		
		assertThat(result.getMemberId()).isEqualTo(member.getMemberId());
		assertThat(result.getId()).isEqualTo(member.getId());
		assertThat(result).isEqualTo(member);
		
	}

}
