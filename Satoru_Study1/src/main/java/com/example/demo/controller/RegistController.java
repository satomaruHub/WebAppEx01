package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistController {

	@GetMapping("/top")
	public String topShow(){
		return "study-top";
	}
	
	@GetMapping("/study-regist-req")
	public String StudyRegist(){
	    return "study-regist";
	}
	
	@GetMapping("/study-confirm-req")
	public String StudyConfirm(){
	    return "study-confirm";
	}
	
	@GetMapping("/study-complete-req")
	public String StudyCOplete(){
	    return "study-complete";
	}	
}
