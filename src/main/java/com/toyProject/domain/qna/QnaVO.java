package com.toyProject.domain.qna;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class QnaVO {

	private Long qno;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private Long replyCount;
}
