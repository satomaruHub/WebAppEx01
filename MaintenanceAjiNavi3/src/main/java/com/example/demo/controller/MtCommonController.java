package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MtCommonController {

	/*--- メニュー画面表示 ---*/
	@GetMapping("/mt-top")
	private String mtShowTop() {
		return "mt-top";
	}

	/*--- 完了後のリダイレクト先 ---*/
	@GetMapping("/mt-complete")
	private String mtComplete() {
		return "mt-complete";
	}

}
