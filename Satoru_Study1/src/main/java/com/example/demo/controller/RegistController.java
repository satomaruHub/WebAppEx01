package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Study;
import com.example.demo.form.StudyRegistForm;
import com.example.demo.service.RegistService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RegistController {
	
	private final RegistService service;

	@GetMapping("/top")
	public String topShow(){
		return "study-top";
	}
	
	
	
	@GetMapping("/study-regist-req")
	public String StudyRegist(@ModelAttribute StudyRegistForm studyForm){
	    return "study-regist";
	}
	
	@PostMapping("/study-confirm-req")
	public String StudyConfirm(@ModelAttribute StudyRegistForm studyForm, Model model){
		
		Study s = new Study();
		s.setStudyContent(studyForm.getStudyContent());
		s.setExamDate(studyForm.getExamDate());
		s.setStudyTimeReq(studyForm.getStudyTimeReq());
		service.regist(s);
		
		model.addAttribute("msg", "完了しました。");
		
	    return "study-confirm";
	}
	
	@PostMapping("/study-complete-req")
	public String StudyCOplete(@ModelAttribute StudyRegistForm studyForm){
	    return "study-complete";
	}
	
	@PostMapping("/top")
	public String topShow2(@ModelAttribute StudyRegistForm studyForm){
		return "study-top";
	}
	
}
