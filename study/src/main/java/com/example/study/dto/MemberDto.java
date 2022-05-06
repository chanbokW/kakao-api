package com.example.study.dto;


import com.example.study.domain.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {
	
	
	private String memberid;
	
	private String password;
	
	private String name;
	
	
	
	@Builder
	public MemberDto(String memberid, String password, String name) {
		this.memberid = memberid;
		this.password = password;
		this.name = name;
	}
	
	public Member toEntity() {
		return Member.builder()
				.memberid(memberid)
				.password(password)
				.name(name)
				.build();
	}
}
