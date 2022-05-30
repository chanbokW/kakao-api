package com.mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mybatis.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
	
	
	@GetMapping("/test")
	public String test() {
		boardService.testBoard();
		return "test";
	}
	@GetMapping("/test2")
	public String test2() {
		boardService.test2();
		return "test";
	}
}
