package com.bitacademy.myportal.service;

import java.util.List;

import com.bitacademy.myportal.vo.BoardVo;

public interface BoardService {
	public List<BoardVo> getList();	//	게시물 목록
	public boolean write(BoardVo vo);	//	게시물 추가용
	public BoardVo getContent(Long no);	//	게시물 조회용
	public boolean update(BoardVo vo);	//	게시물 업데이트용
}
