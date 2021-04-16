package com.bitacademy.myportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.myportal.service.MemberService;
import com.bitacademy.myportal.vo.MemberVo;

@Controller
@RequestMapping("/members")
public class MemberController {
	//	서비스 연결
	@Autowired
	private MemberService memberService;
	
	//	가입 폼
	@RequestMapping(value= {"", "/", "/join"}, 
			method=RequestMethod.GET)
	public String join() {
		return "users/joinform";
	}
	
	//	가입 처리
	@RequestMapping(value="/join",
			method=RequestMethod.POST)
	public String joinAction(@ModelAttribute MemberVo memberVo) {
		System.out.println("Form 전송된 데이터:" + memberVo);
		
		boolean success = memberService.join(memberVo);
		
		if (success) {	//	insert 성공
			System.out.println("가입 성공!");
			return "redirect:/members/joinsuccess";
		} else {
			System.err.println("가입 실패!");
			return "redirect:/members/";	//	가입 폼으로 다시 돌려보냄
		}
	}
	
	//	성공 화면
	@RequestMapping("/joinsuccess")
	public String joinSuccess() {
		return "users/joinsuccess";
	}
}
