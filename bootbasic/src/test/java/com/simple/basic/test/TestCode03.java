package com.simple.basic.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.simple.basic.service.board.BoardService;
import com.simple.basic.service.board.BoardServiceImpl;

@SpringBootTest
public class TestCode03 {
	/*
	@Autowired
	ApplicationContext app;
	
	@Autowired //컨테이너 안에 타입이 적합한 빈을 찾아서 주입.
	BoardService board;
	
	@Test
	public void test01() {
		BoardServiceImpl boardService = app.getBean(BoardServiceImpl.class);
		System.out.println("빈생성여부:" + boardService);
		
		System.out.println("빈주입여부:" + board );
		
	}
	*/
}
