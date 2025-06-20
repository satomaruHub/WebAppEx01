package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.MtRestaurant;
import com.example.demo.form.MtEditForm;
import com.example.demo.service.MtEditService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MtEditController {

	private final MtEditService service;
	
	/*--- 編集画面表示リクエスト ---*/
	@PostMapping("/mt-show-edit")
	public String mtShowEdit(@ModelAttribute MtEditForm form) {
		return "mt-edit";
	}

	/*--- 更新リクエスト（編集画面より） ---*/
	@PostMapping("/mt-edit")
	public String mtEdit(
		@Validated @ModelAttribute MtEditForm form,
		BindingResult result ) {

		if (result.hasErrors()) {
			return "mt-edit";			// 入力がエラーの場合
		}

		return "mt-confirm-edit";		// 入力が正常の場合
	}

	/*--- 更新リクエスト（編集確認画面より） ---*/
	@PostMapping("/mt-confirm-edit")
	public String mtConfirmEdit(
			@Validated @ModelAttribute MtEditForm form,
			BindingResult result,
			RedirectAttributes redirectAttributes ) {

		if (result.hasErrors()) {
			return "mt-edit";			// 入力がエラーの場合
		}

		MtRestaurant r = new MtRestaurant();
		r.setRestaurantId(form.getRestaurantId());
		r.setRestaurantName(form.getRestaurantName());
		r.setCatchPhrase(form.getCatchPhrase());

		service.edit(r);
			
		redirectAttributes.addFlashAttribute("msg", "(店舗更新)");
			
		return "redirect:/mt-complete";
	}

}
