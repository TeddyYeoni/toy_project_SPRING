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
public class ToDoListVO {
	
	private Long tno;
	private String id;
	private Long checkNumber;
	private String checkList;
	private Date todayDate;
	
}
