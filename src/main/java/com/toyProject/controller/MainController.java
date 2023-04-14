package com.toyProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.toyProject.service.album.AlbumService;
import com.toyProject.service.board.BoardService;
import com.toyProject.service.diary.DiaryService;
import com.toyProject.service.qna.QnaService;
import com.toyProject.service.todo.ToDoListService;

@Controller
@RequestMapping(value = { "/main", "" })
public class MainController {

	@Autowired
	BoardService boardService;

	@Autowired
	QnaService qnaService;

	@Autowired
	ToDoListService toDoListService;

	@Autowired
	AlbumService albumService;

	@Autowired
	DiaryService diaryService;

	@GetMapping
	public String mainPage(Model model) {
		model.addAttribute("recentBoard", boardService.recentBoardList());
		model.addAttribute("recentQna", qnaService.recentQnaList());
		return "main";
	}

	@GetMapping("/mySpace")
	public String mySpace(Model model) {
		model.addAttribute("recentTodo", toDoListService.recentToDoList());
		model.addAttribute("recentAlbum", albumService.recentAlbumList());
		model.addAttribute("recentDiary", diaryService.recentDiaryList());
		return "mySpace";
	}
}