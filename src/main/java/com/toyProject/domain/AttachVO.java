package com.toyProject.domain;

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
public class AttachVO {

	private Long attachNo;
	private Long postNo;
	private String filePath; // 파일 경로
	private String fileName; // 파일 이름
	private FileType fileType; // 파일 타입
	
}
