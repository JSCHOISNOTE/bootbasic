package com.simple.basic.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class TestCode01 {
	//1. 반드시 기본패키지 하위에 작성
	//2. @Test를 붙여서 사용
	/*
	@Autowired
	private ApplicationContext app;
	
	@Test
	public void test01() {
		//데이터베이스 정보
		DataSource ds = app.getBean(DataSource.class);
		try {
			Connection conn = ds.getConnection();
			System.out.println("데이터베이스:" + conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	*/
	
}
