package com.toyProject.domain;

import java.util.Date;

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
public class DiaryVO {

	private Long dno;
	private String writer;
	private String content;
	private String weather;
	private String emotion;
	private String praise;
	private String thanks;
	private Date writeDate;

}
