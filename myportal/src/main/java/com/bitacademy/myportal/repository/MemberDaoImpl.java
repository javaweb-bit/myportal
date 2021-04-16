package com.bitacademy.myportal.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.myportal.exception.MemberDaoException;
import com.bitacademy.myportal.vo.MemberVo;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {
	//	Logger
	private static Logger logger = LoggerFactory.getLogger(MemberDaoImpl.class);
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(MemberVo vo) {
		int insertedCount = 0;

		try {
			insertedCount = sqlSession.insert("members.insert", vo);
		} catch (Exception e) {
			// 예외 전환
			// 로그 출력
//			System.err.println("예외 발생:" + e.getMessage());
			logger.error("예외 발생:" + e.getMessage());
			throw new MemberDaoException("회원 가입 중 오류 발생!", vo);
		}
		return insertedCount;
	}

	//	email과 password로 사용자 찾기
	@Override
	public MemberVo selectUser(String email, String password) {
		Map<String, String> userMap = new HashMap<>();
		userMap.put("email", email);
		userMap.put("password", password);
		
		MemberVo vo = sqlSession.selectOne("members.selectUserByEmailAndPassword", userMap);
		return vo;
	}

	@Override
	public MemberVo selectUser(String email) {
		MemberVo vo = sqlSession.selectOne("members.selectUserByEmail", email);
		
		return vo;
	}

}
