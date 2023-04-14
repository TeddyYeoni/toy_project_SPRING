package com.toyProject.domain.board;

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
public class BoardVO {
	
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private String imageFileName;
	private Date writeDate;
	
}
