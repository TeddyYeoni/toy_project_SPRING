package com.toyProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.toyProject.service.DiaryService;

@Controller
@RequestMapping("/diary")
public class DiaryController {
	
	@Autowired
	private DiaryService diaryService;


}
