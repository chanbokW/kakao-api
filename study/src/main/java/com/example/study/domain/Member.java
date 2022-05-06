package com.example.study.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Member {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String memberid;

	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String name;
	
	//나중에 role 추가할 예정


	@Builder
	public Member(String memberid,String password,String name) {
		this.memberid = memberid;
		this.password = password;
		this.name = name;
	}
	
}
