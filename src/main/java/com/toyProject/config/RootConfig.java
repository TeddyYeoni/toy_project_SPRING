package com.toyProject.config;

import java.io.IOException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.toyProject.domain.AlbumVO;
import com.toyProject.domain.BoardVO;
import com.toyProject.domain.DiaryVO;
import com.toyProject.domain.QnaVO;
import com.toyProject.domain.ToDoListVO;

@Configuration
@Import({DbConfig.class })
@MapperScan("com.toyProject.dao")
public class RootConfig {

	@Autowired
	DataSource dataSource;

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath:mappers/**/*Mapper.xml"));
		sqlSessionFactoryBean.setTypeAliases(BoardVO.class);
		return sqlSessionFactoryBean;
	}

	@Bean
	public SqlSessionTemplate sessionTemplate() throws Exception {
		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory().getObject());
		return sessionTemplate;
	}

}
