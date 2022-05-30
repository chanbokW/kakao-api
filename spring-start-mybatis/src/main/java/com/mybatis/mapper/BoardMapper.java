package com.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mybatis.dto.Board;

@Mapper
public interface BoardMapper {

	int addBoardTest(Board board);
	
	int addBoardTest2(List<Board> board);
}
