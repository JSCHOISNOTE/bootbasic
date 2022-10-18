package com.simple.basic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.basic.command.MemberVO;
import com.simple.basic.command.ValidVO;

@Controller
@RequestMapping("/valid")
public class ValidController {

	@GetMapping("/view")
	public void view() {
		//void형은 들어오는 경로가 나가는 경로가 됩니다.
	}
	
	//vo에 유효성 검사를 진행하고, 실패하면 Errors객체로 바인딩 됩니다.
	@PostMapping("/validForm")
	public String validForm(@Valid ValidVO vo, Errors errors, Model model ) {
		
		if(errors.hasErrors() ) { //유효성 검사에 실패하면 true
			
			List<FieldError> list = errors.getFieldErrors();
			//System.out.println(list.toString()); 에러가 발생한 필드목록
			
			for(FieldError err : list ) {
				//System.out.println("실패한 필드명:" + err.getField()); 
				//System.out.println("실패한 필드의 메시지:" + err.getDefaultMessage());
				//System.out.println("유효성 검사에 바인딩 실패여부:" + err.isBindingFailure());
				//에러메시지를 모델에 담는다.
				if(err.isBindingFailure()) { //타입이 맞지않아서 바인딩에 실패한 경우
					model.addAttribute("valid_" + err.getField() , "형식을 일치시키세요");
				} else {
					model.addAttribute("valid_" + err.getField() , err.getDefaultMessage() );
				}
				
			}
			model.addAttribute("vo", vo); //사용자가 입력한 값을 다시 사용하기 위해 모델에 담는다.
			
			return "valid/view"; //다시 원래 화면으로
			
		}
		
		
		return "valid/result"; //유효성검사를 성공시 나가는화면
	}
	

	//////////////////////////////////////////
	@GetMapping("/quiz01")
	public String quiz01() {
		
		
		
		return "valid/quiz01";
	}
	
	@PostMapping("/quizForm")
	public String quizForm(@Valid MemberVO vo, Errors errors, Model model) {
		
		if(errors.hasErrors()) {
			List<FieldError> list = errors.getFieldErrors();
			for(FieldError err : list) {
				model.addAttribute("valid_" + err.getField(), err.getDefaultMessage());
			}
			
			model.addAttribute("vo", vo); //데이터 유지를 위해 데이터 저장
			return "valid/quiz01"; //기존페이지로
		}

		return "valid/quiz01_result";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
