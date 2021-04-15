package com.bitacademy.myportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitacademy.myportal.service.GuestbookService;
import com.bitacademy.myportal.vo.GuestbookVo;

@RequestMapping("/guestbook")
@Controller
public class GuestbookController {
	//	서비스 연결
	@Autowired
	GuestbookService guestbookServiceImpl;
	
//	@ResponseBody
	@RequestMapping({"", "/", "/list"})
	//	-> /guestbook , /guestbook/ , /guestbook/list
	public String list(Model model) {
		List<GuestbookVo> list = guestbookServiceImpl.getList();
		//	데이터를 모델에 추가
		model.addAttribute("list", list);
		return "guestbook/list";
	}
}
