package com.simple.basic.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.simple.basic.command.BuilderVO;
import com.simple.basic.command.BuilderVO.Builder;
import com.simple.basic.command.BuilderVO2;

@SpringBootTest
public class TestCode02 {

	@Test
	public void test01() {
		
		 //Builder b = BuilderVO.builder();
		 //BuilderVO vo = b.name("홍길동").age(10).build();
		 
		 BuilderVO vo = BuilderVO.builder().name("홍길동").age(10).build();
		
		 System.out.println(vo.toString());
		 
		 //lombok의 @Builder어노테이션
		 BuilderVO2 vo2 = BuilderVO2.builder().name("이순신").age(20).build();
		 
		 System.out.println(vo2.toString());
		 
		 
		 
		 
	}
}
