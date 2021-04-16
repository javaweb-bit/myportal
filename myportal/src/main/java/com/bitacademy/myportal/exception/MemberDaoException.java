package com.bitacademy.myportal.exception;

import com.bitacademy.myportal.vo.MemberVo;

//	MemberDao에서의 예외 처리를 위한 예외 클래스
public class MemberDaoException extends RuntimeException {
	//	예외가 발생했을 때의 상황을 저장할 변수
	private MemberVo memberVo = null;
	
	//	생성자
	public MemberDaoException() {
		
	}
	
	public MemberDaoException(String message) {
		super(message);
	}
	
	public MemberDaoException(String message, MemberVo memberVo) {
		super(message);
		this.memberVo = memberVo;
	}

	//	Getter / Setter
	public MemberVo getMemberVo() {
		return memberVo;
	}

	public void setMemberVo(MemberVo memberVo) {
		this.memberVo = memberVo;
	}
	
	

}
