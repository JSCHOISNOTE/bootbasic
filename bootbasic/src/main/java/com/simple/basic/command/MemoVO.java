package com.simple.basic.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemoVO {

	private Integer mno;
	
	@NotBlank(message = "값을 입력해주세요 5글자 이상")
	private String memo;
	@Pattern(message = "휴대폰 번호형식 입니다", regexp = "[0-9]{3}-[0-9]{4}-[0-9]{4}")
	private String phone;
	@Pattern(message = "숫자 4자리 입니다", regexp = "[0-9]{4}")
	private String pw;
	
	
	private String secret;
	
	
}
