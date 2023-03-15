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
public class AlbumVO {

	private Long ano;
	private String id;
	private String title;
	private String content;
	private String imageFileName;
	private Date uploadDate;

}
