package com.bitacademy.myportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/fileupload")
@Controller
public class FileUploadController {

	@RequestMapping({"", "/", "form"})
	public String form() {
		return "fileupload/form";
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(@RequestParam MultipartFile uploadfile, Model model) {
		//	파일 업로드 기능 수행
		//	업로드된 이미지 url 생성
		//	결과 페이지로 forward
		
		return "fileupload/result";
	}
}
