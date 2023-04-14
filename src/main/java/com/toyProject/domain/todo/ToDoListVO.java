package com.toyProject.domain.todo;


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
	private String toDoList;
	private Date todayDate;
	
}
