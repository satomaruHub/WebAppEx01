package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.MtRestaurant;
import com.example.demo.form.MtRegistForm;
import com.example.demo.service.MtRegistService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MtRegistController {

	private final MtRegistService service;
	
	/*--- 登録画面表示リクエスト ---*/
	@PostMapping("/mt-show-regist")
	public String mtShowRtRegist(@ModelAttribute MtRegistForm form) {
		return "mt-regist";
	}

	/*--- 登録リクエスト（登録画面より） ---*/
	@PostMapping("/mt-regist")
	public String mtRegist(
		@Validated @ModelAttribute MtRegistForm form,
		BindingResult result ) {

		if (result.hasErrors()) {
			return "mt-regist";			// 入力がエラーの場合
		}

		return "mt-confirm-regist";		// 入力が正常の場合
	}

	/*--- 登録リクエスト（登録確認画面より） ---*/
	@PostMapping("/mt-confirm-regist")
	public String mtConfirmRegist(
			@Validated @ModelAttribute MtRegistForm form,
			BindingResult result,
			RedirectAttributes redirectAttributes ) {

		if (result.hasErrors()) {
			return "mt-regist";			// 入力がエラーの場合
		}

		MtRestaurant r = new MtRestaurant();
		r.setRestaurantName(form.getRestaurantName());
		r.setCatchPhrase(form.getCatchPhrase());

		service.regist(r);
			
		redirectAttributes.addFlashAttribute("msg", "(店舗登録)");
			
		return "redirect:/mt-complete";
	}

}
