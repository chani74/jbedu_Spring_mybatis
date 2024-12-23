package com.jbedu.mybatis.dao;

import java.util.List;

import com.jbedu.mybatis.dto.BoardDto;

public interface BoardDao {

	public void boardWriteDao(String bname, String btitle, String bcontent);
	public List<BoardDto> boardListDao();
	public int boardDeleteDao(String bnum);
	public int boardUpdateDao(String bname, String btitle, String bcontent, String bnum);
	public BoardDto boardContentDao(String bnum);
	public int HitCountDao(String bnum);
	
}
