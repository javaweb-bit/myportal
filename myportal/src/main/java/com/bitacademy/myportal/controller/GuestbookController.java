package com.bitacademy.myportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitacademy.myportal.service.GuestbookService;
import com.bitacademy.myportal.vo.GuestbookVo;

@RequestMapping("/guestbook")
@Controller
public class GuestbookController {
	//	서비스 연결
	@Autowired
	GuestbookService guestbookServiceImpl;
	
	@ResponseBody
	@RequestMapping({"", "/", "/list"})
	//	-> /guestbook , /guestbook/ , /guestbook/list
	public String list() {
		List<GuestbookVo> list = guestbookServiceImpl.getList();
		return list.toString();
	}
}
