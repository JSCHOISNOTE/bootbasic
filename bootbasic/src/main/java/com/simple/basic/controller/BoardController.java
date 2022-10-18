package com.simple.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.basic.command.BoardVO;
import com.simple.basic.service.board.BoardService;
import com.simple.basic.service.board.BoardServiceImpl;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	//멤버변수
	//BoardService boardService = new BoardServiceImpl();
	
	@Autowired
	@Qualifier("boardService") //서비스의 이름을 강제연결
	BoardService boardService;
	
	//등록화면
	@GetMapping("/boardRegist")
	public String boardRegist() {
		return "board/boardRegist";
	}
	//목록화면
	@GetMapping("/boardList")
	public String boardList(Model model) {
		
		//데이터 가지고 나간다.
		List<BoardVO> list = boardService.getList();
		model.addAttribute("list", list); //화면에 데이터를 전달
		
		return "board/boardList";
	}
	//결과화면
	@GetMapping("/boardResult")
	public String boardResult() {
		
		return "board/boardResult";
	}
	
	@PostMapping("/boardForm")
	public String boardForm(BoardVO vo) {
		
		boolean result = boardService.insert(vo);
		
		
		System.out.println("성공실패:" + result);
		//화면에 데이터를 가져나갈 필요가 없다면 리다이렉트 방식으로 처리
		//스프링에서 리다이렉트 방식은 다시 컨트롤러를 태워보내는 방식.
		return "redirect:/board/boardResult"; //결과화면으로
	}
	
	//상세화면
	@GetMapping("/boardDetail")
	public String boardDetail(@RequestParam("bno") int bno,
							  Model model) {
		//글 1개를 가지고 화면으로 나간다.
		BoardVO vo = boardService.getDetail(bno);
		model.addAttribute("vo", vo);
		
		
		return "board/boardDetail";
	}
	
	//글 삭제
	@GetMapping("/boardDelete")
	public String boardDelete(@RequestParam("bno") int bno,
							  RedirectAttributes RA) {
		
		boolean result = boardService.delete(bno);
		System.out.println("성공실패:" + result);
		//리다이렉트시에 간단한 메시지 전달방법 (1회성 메시지)
		//RedirectAttributes
		RA.addFlashAttribute("msg", "정상 처리되었습니다");
		
		
		//삭제한 이후에는 
		//데이터를 가지고 화면으로
		return "redirect:/board/boardList";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
