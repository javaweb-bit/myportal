package com.bitacademy.myportal.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.myportal.exception.MemberDaoException;
import com.bitacademy.myportal.vo.MemberVo;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(MemberVo vo) {
		int insertedCount = 0;
		
		try {
			insertedCount = sqlSession.insert("members.insert", vo);
		} catch (Exception e) {
			//	예외 전환
			//	로그 출력
			System.err.println("예외 발생:" + e.getMessage());
			throw new MemberDaoException("회원 가입 중 오류 발생!", vo);
		}
		return 0;
	}

	@Override
	public MemberVo selectUser(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVo selectUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
