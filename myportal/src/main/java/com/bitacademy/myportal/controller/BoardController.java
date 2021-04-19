package com.bitacademy.myportal.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitacademy.myportal.service.BoardService;
import com.bitacademy.myportal.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	//	로거 연결
	private static Logger logger = 
			LoggerFactory.getLogger(BoardController.class);
	//	서비스 연결
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

}
