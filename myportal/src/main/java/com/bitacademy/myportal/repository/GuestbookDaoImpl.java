package com.bitacademy.myportal.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.myportal.vo.GuestbookVo;

@Repository		//	이름 명시 안하면 클래스 이름을 기반으로 자동 명명
//	-> guestbookDaoImpl 이름을 bean 등록
//@Repository("guestbookDao")
public class GuestbookDaoImpl implements GuestbookDao {
	//	데이터 소스 연결
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<GuestbookVo> selectAll() {
		// 가상 데이터
		//	TODO: 실제 DB와 연결
		List<GuestbookVo> list = new ArrayList<>();
		// Long no, String name, String password, String content, Date regDate
		list.add(new GuestbookVo(1L, "홍길동", "1234", "왔다 가요", new Date()));
		list.add(new GuestbookVo(2L, "장길산", "pass", "저두요", new Date()));
		list.add(new GuestbookVo(3L, "전우치", "test", "반갑습니다", new Date()));
		return list;
	}

	@Override
	public int insert(GuestbookVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(GuestbookVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
