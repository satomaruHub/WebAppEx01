package com.example.demo.form;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class StudyRegistForm {
	
	@NotNull(message="入力してください。")
	@Size(min=1, max=32, message="1文字から32文字で指定してください。")
	private String studyContent;

	@NotNull(message="入力してください。")
	@Future(message="今日以降の日付を入力してください。")
	private String examDate;
	
	@NotNull(message="入力してください。")
	private String studyTimeReq;
}
