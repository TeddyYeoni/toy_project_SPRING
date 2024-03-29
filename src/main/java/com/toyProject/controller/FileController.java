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

	public static final String BOARD_FILE_PATH = "c:/mou_fileRepo/board/";
	public static final String ALBUM_FILE_PATH = "c:/mou_fileRepo/album/";

	@GetMapping("/boardImgDisplay")
	public ResponseEntity<byte[]> boardImgDisplay(String imageFileName) throws IOException {
		File file = new File(BOARD_FILE_PATH, imageFileName);
		if (!file.exists()) {
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}

		HttpHeaders headers = new HttpHeaders();
		FileNameMap fileNameMap = URLConnection.getFileNameMap();
		headers.add("Content-Type", fileNameMap.getContentTypeFor(imageFileName));

		return new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);
	}

	@GetMapping("/albumImgDisplay")
	public ResponseEntity<byte[]> albumImgDisplay(String imageFileName) throws IOException {
		File file = new File(ALBUM_FILE_PATH, imageFileName);
		if (!file.exists()) {
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}

		HttpHeaders headers = new HttpHeaders();
		FileNameMap fileNameMap = URLConnection.getFileNameMap();
		headers.add("Content-Type", fileNameMap.getContentTypeFor(imageFileName));

		return new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);
	}

}
