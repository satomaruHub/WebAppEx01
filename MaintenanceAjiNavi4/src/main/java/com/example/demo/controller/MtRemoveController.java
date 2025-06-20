package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.MtRestaurant;
import com.example.demo.form.MtRemoveForm;
import com.example.demo.service.MtRemoveService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MtRemoveController {

	private final MtRemoveService service;
	
	/*--- 削除リクエスト（一覧画面より） ---*/
	@PostMapping("/mt-remove")
	public String mtRemove(
			@Validated @ModelAttribute MtRemoveForm form,
			BindingResult result) {

		if (result.hasErrors()) {
			return "mt-remove"; // 入力がエラーの場合
		}

		return "mt-confirm-remove"; // 入力が正常の場合
	}

	/*--- 削除リクエスト（削除確認画面より） ---*/
	@PostMapping("/mt-confirm-remove")
	public String confirmRemoveRt(
			@Validated @ModelAttribute MtRemoveForm form,
			BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "mt-remove"; // 入力がエラーの場合
		}

		MtRestaurant r = new MtRestaurant();
		r.setRestaurantId(form.getRestaurantId());
		r.setRestaurantName(form.getRestaurantName());
		r.setCatchPhrase(form.getCatchPhrase());

		service.remove(r);

		redirectAttributes.addFlashAttribute("msg", "(店舗削除)");

		return "redirect:/mt-complete";
	}
}
