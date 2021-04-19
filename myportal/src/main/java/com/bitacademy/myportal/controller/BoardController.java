package com.bitacademy.myportal.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.myportal.service.BoardService;
import com.bitacademy.myportal.vo.BoardVo;
import com.bitacademy.myportal.vo.MemberVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	//	로거 연결
	private static Logger logger = 
			LoggerFactory.getLogger(BoardController.class);
	//	서비스 연결
	@Autowired
	BoardService boardServiceImpl;
	
	@RequestMapping({"", "/", "/list"})
	public String list(Model model) {
		//	게시물 목록 받아오기
		List<BoardVo> list = boardServiceImpl.getList();
		//	모델에 실어서 View로 전달
		model.addAttribute("list", list);
		logger.debug("게시물 목록:", list);
		
		return "board/list";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String writeForm(HttpSession session) {
		//	사용자를 체크해서 로그인 안한 사용자는 쓰기 기능을 제한
		MemberVo authUser = (MemberVo)session.getAttribute("authUser");
		//	로그인 여부 체크
		if (authUser == null) {
			//	로그인 안한 사용자
			return "redirect:/";
		}
		//	로그인 한 사용자 -> 작성 폼으로 포워드
		return "board/write";
	}

}
