package com.toyProject.domain;

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
public class BoardReplyVO {

	private Long b_rno;
	private Long bno;
	private String reply;
	private String writer;
	private Date replyDate;
	private Date modifyDate;
	
}
