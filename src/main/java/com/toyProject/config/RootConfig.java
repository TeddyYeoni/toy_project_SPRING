package com.toyProject.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.toyProject.domain.AlbumVO;
import com.toyProject.domain.BoardVO;
import com.toyProject.domain.DiaryVO;
import com.toyProject.domain.QnaVO;
import com.toyProject.domain.ToDoListVO;

@Configuration
@MapperScan("com.toyProject.mapper")
public class RootConfig {

	@Autowired
	DataSource dataSource;

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setTypeAliases(BoardVO.class, AlbumVO.class, DiaryVO.class, ToDoListVO.class,
				QnaVO.class);
		return sqlSessionFactoryBean;
	}

	@Bean
	public SqlSessionTemplate sessionTemplate() throws Exception {
		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory().getObject());
		return sessionTemplate;
	}

}