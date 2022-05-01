package com.example.study.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.study.repository.MemberRepository;
import com.example.study.service.MemberService;

@SpringBootTest
@Transactional
public class MemberTest {
	
	@Autowired
	MemberService ms;
	@Autowired
	MemberRepository mr;
	
	
	@Test
	@DisplayName("회원가입 테스트")
	public void registerMember() {
		Member member = new Member();
		member.setMemberid("cks");
		member.setPassword("pw001");
		member.setName("helloworld");
		
		Long id =ms.registerMember(member);
		
		Member result = mr.findById(id).get();
		
		assertThat(result.getId()).isEqualTo(member.getId());
		assertThat(result.getMemberid()).isEqualTo(member.getMemberid());
		assertThat(result.getPassword()).isEqualTo(member.getPassword());
		assertThat(result.getName()).isEqualTo(member.getName());
		
		
	}
}
