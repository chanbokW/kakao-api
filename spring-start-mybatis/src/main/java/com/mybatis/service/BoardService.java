package com.mybatis.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.mybatis.dto.Board;
import com.mybatis.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	
	private final BoardMapper boardMapper;
	
	Board pushBoardTest = new Board();
	
	public void testBoard() {
		long startTime = System.currentTimeMillis();
		for(int i=0; i<10000; i++) {
			boardMapper.addBoardTest(pushBoardTest);
		}
		System.out.println(System.currentTimeMillis()-startTime);
		//17561
	}
	
	
	public void test2() {
		List<Board> list = IntStream.range(0, 10000)
				.mapToObj(i-> pushBoardTest)
				.collect(Collectors.toList());
		long startTime = System.currentTimeMillis();
		boardMapper.addBoardTest2(list);
		System.out.println(System.currentTimeMillis()-startTime);
		//476
		
	}
}
