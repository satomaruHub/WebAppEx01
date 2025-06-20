package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.MtRestaurant;
import com.example.demo.form.MtSearchForm;
import com.example.demo.service.MtListService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MtListController {

	private final MtListService service;
	
	/*--- 検索画面表示リクエスト ---*/
	@PostMapping("/mt-show-list")
	private String showRtList(@ModelAttribute MtSearchForm form) {
		return "mt-list";
	}
	
	/*--- 検索リクエスト ---*/
	@PostMapping("/mt-search")
	private String searchRt(
		@ModelAttribute MtSearchForm form,
		Model model	) {

		List<MtRestaurant> list 
			= service.findByNameWildcard(form.getRestaurantName());
		
		if (list.size() > 0) {
			model.addAttribute("mtRestaurantList", list);
		}
		
		return "mt-list";
	}

}
