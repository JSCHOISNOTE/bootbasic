package com.simple.basic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.basic.command.MemoVO;
import com.simple.basic.service.memo.MemoService;

@Controller
@RequestMapping("/memo")
public class MemoController {

	@Autowired
	@Qualifier("memoService")
	MemoService memoService;
		
	@GetMapping("/memoWrite")
	public String memoWrite() {
		return "memo/memoWrite";
	}
	
	@GetMapping("/memoList")
	public String memoList(Model model) {
		
		List<MemoVO> list = memoService.getList();
		model.addAttribute("list", list); //데이터를 가지고나간다.
		
		return "memo/memoList";
	}
	
	@GetMapping("/memoDetail")
	public String memoDetail(@RequestParam("mno") int mno
							,Model model) {
		
		MemoVO vo = memoService.getDetail(mno);
		model.addAttribute("vo", vo);
		
		
		return "memo/memoDetail";
	}
	
	@PostMapping("/memoForm")
	public String memoForm(@Valid MemoVO vo, Errors errors, Model model) {
		
		if(errors.hasErrors()) {
			List<FieldError> list = errors.getFieldErrors();
			for(FieldError err : list) {
				model.addAttribute("valid_" + err.getField(), err.getDefaultMessage());
			}
			
			model.addAttribute("vo", vo);
			return "memo/memoWrite";
			
		}
		
		memoService.memoInsert(vo);
		
		
		return "redirect:/memo/memoList";
	}
	
	
	
	
	
	
	
	
	
	
	
}
