package com.bitacademy.myportal.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.myportal.vo.BoardVo;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<BoardVo> selectAll() {
		//	TODO: 예외처리
		List<BoardVo> list = sqlSession.selectList("board.selectAll");
		return list;
	}

	@Override
	public int insert(BoardVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardVo getContent(Long no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(BoardVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
