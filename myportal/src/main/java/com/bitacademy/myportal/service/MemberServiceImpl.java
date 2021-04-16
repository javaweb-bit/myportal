package com.bitacademy.myportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.myportal.repository.MemberDao;
import com.bitacademy.myportal.vo.MemberVo;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	//	DAO 연결
	@Autowired
	MemberDao memberDao;
	
	@Override
	public boolean join(MemberVo vo) {
		int insertedCount = memberDao.insert(vo);
		return 1 == insertedCount;
	}

	@Override
	public MemberVo getUser(String email, String password) {
		MemberVo vo = memberDao.selectUser(email, password);
		return vo;
	}

	//	이메일 중복 처리
	@Override
	public MemberVo getUser(String email) {
		MemberVo vo = memberDao.selectUser(email);
		return vo;
	}

}
