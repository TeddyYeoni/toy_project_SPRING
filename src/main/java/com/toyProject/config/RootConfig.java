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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.toyProject.domain.MemberVO;
import com.toyProject.domain.MemberVO.MemberGrade;
import com.toyProject.domain.album.AlbumVO;
import com.toyProject.domain.board.BoardReplyVO;
import com.toyProject.domain.board.BoardVO;
import com.toyProject.domain.diary.DiaryVO;
import com.toyProject.domain.qna.QnaReplyVO;
import com.toyProject.domain.qna.QnaVO;
import com.toyProject.domain.todo.CheckListVO;
import com.toyProject.domain.todo.ToDoListVO;

@Configuration
@Import({ DbConfig.class })
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
		sqlSessionFactoryBean.setTypeAliases(BoardVO.class, QnaVO.class, DiaryVO.class, MemberVO.class,
				MemberGrade.class, ToDoListVO.class, AlbumVO.class, BoardReplyVO.class, QnaReplyVO.class, CheckListVO.class);
		return sqlSessionFactoryBean;
	}

	@Bean
	public SqlSessionTemplate sessionTemplate() throws Exception {
		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory().getObject());
		return sessionTemplate;
	}

	// 파일업로드 설정
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setDefaultEncoding("UTF-8");
		multipartResolver.setMaxUploadSize(-1);
		return multipartResolver;
	}

	// 트랜잭션 관리자
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}

}
