package com.example.demo.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MtEditForm {

	@NotNull(message="入力してください。")
	@Min(value=1,  message="正の整数を入力してください。")
	private Integer restaurantId;

	@Size(min=1, max=32, message="1文字から32文字で指定してください。")
	private String restaurantName;

	@Size(min=1, max=64, message="1文字から64文字で指定してください。")
	private String catchPhrase;

}
