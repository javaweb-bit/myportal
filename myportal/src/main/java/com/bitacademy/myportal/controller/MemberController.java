package com.bitacademy.myportal.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitacademy.myportal.service.MemberService;
import com.bitacademy.myportal.vo.MemberVo;

@Controller
@RequestMapping("/members")
public class MemberController {
	//	Logger
	private static Logger logger = LoggerFactory.getLogger(MemberController.class);
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
//		System.out.println("Form 전송된 데이터:" + memberVo);
		logger.debug("Form 전송된 데이터:" + memberVo);
		
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
	
	//	JSON 매핑 확인
	@ResponseBody	//	MessageConverter 작동
	@RequestMapping("/show")
	public Object showUserByEmail(@RequestParam String email) {
		MemberVo vo = memberService.getUser(email);
		return vo;
	}
	
	//	중복 이메일 체크
	@ResponseBody
	@RequestMapping("/emailcheck")
	public Object existsEmail(
			@RequestParam(value="email", required=false, defaultValue="") String email) {
		MemberVo vo = memberService.getUser(email);
		boolean exists = vo != null ? true: false;	//	vo 객체가 null -> 이미 존재하는 사용자
		
		//	결과 MAP -> 컨버터 -> JSON 변환
		Map<String, Object> map = new HashMap<>();
		map.put("result", "success");
		map.put("data", exists);
		
		return map;
	}
	
	//	로그인 폼 처리
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() {
		return "users/loginform";
	}
	
	//	로그인 처리
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginAction(
			@RequestParam String email,
			@RequestParam String password,
			HttpSession session) {	//	사용자 세션 저장을 위한 세션 객체
		
		MemberVo authUser = memberService.getUser(email, password);
		
		//	만약에 찾는 유저가 없으면 login 폼으로 되돌려보냄
		if (authUser != null) {
			//	세션에 추가
			session.setAttribute("authUser", authUser);
			//	홈페이지로 리다이렉트
			return "redirect:/";
		} else {
			//	로그인 실패
			return "redirect:/members/login";
		}
		
	}
	
	//	로그아웃 처리
	@RequestMapping("/logout")
	public String logoutAction(HttpSession session) {
		//	세션 지우기
		session.removeAttribute("authUser");
		//	세션 무효화
		session.invalidate();
		return "redirect:/";
	}
	
}
