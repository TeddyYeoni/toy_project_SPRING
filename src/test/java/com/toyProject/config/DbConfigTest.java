package com.toyProject.config;

import static org.junit.Assert.*;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.toyProject.AppTest;

import lombok.extern.log4j.Log4j;

public class DbConfigTest extends AppTest {

	@Autowired
	DataSource dataSource;
	
	@Test
	public void test() { // 데이터소스를 잘 불러오는지 확인
		System.out.println(dataSource);
	}

}
