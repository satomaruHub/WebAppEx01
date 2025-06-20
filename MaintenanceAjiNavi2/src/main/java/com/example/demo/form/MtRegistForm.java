package com.example.demo.form;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MtRegistForm {

	@Size(min=1, max=32, message="1文字から32文字で指定してください。")
	private String restaurantName;

	@Size(min=1, max=64, message="1文字から64文字で指定してください。")
	private String catchPhrase;

}
