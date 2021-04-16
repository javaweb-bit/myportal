package com.bitacademy.myportal.service;

import com.bitacademy.myportal.vo.MemberVo;

public interface MemberService {
	public boolean join(MemberVo vo);	//	가입(INSERT)
	public MemberVo getUser(String email, String password);	//	로그인용
	public MemberVo getUser(String email);	//	중복 이메일 체크용
}
