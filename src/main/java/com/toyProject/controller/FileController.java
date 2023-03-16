package com.toyProject.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.FileNameMap;
import java.net.URLConnection;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {

	@GetMapping("/imgDisplay")
	public ResponseEntity<byte[]> imgDisplay(String fileName) throws IOException {
		File file = new File("c:/mou_repo", fileName);
		if (!file.exists()) {
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}

		HttpHeaders headers = new HttpHeaders();
		FileNameMap fileNameMap = URLConnection.getFileNameMap();
		headers.add("Content-Type", fileNameMap.getContentTypeFor(fileName));

		return new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);
	}

	@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> download(@RequestHeader("User-Agent") String userAgent, String fileName)
			throws UnsupportedEncodingException {
		Resource resource = new FileSystemResource("c:/mou_repo/" + fileName);
		if (!resource.exists()) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
		// 다운로드 시 파일 이름 처리
		HttpHeaders headers = new HttpHeaders();
		String downloadName = new String(resource.getFilename().getBytes("UTF-8"), "ISO-8859-1");
		headers.add("Content-Disposition", "attach;fileName=" + downloadName);
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}

}
