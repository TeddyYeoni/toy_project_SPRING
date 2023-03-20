package com.toyProject.controller.menu;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.toyProject.domain.BoardVO;
import com.toyProject.domain.paging.Criteria;
import com.toyProject.domain.paging.Pagination;
import com.toyProject.service.menu.BoardService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {

	@Autowired
	private BoardService boardService;

	// 게시물 목록
	@GetMapping(value = { "", "/", "/list" })
	public String list(Model model, @ModelAttribute("cri") Criteria criteria) {

		model.addAttribute("board_list", boardService.boardList(criteria));
		model.addAttribute("page", new Pagination(criteria, boardService.totalCount(criteria)));

		return "board/boardList";
	}

	// 게시물 조회
	@GetMapping("/detail")
	public String select(Model model, Long bno) {
		model.addAttribute("board", boardService.findByBno(bno));
		return "board/boardDeatil";
	}

	// 게시믈 작성 폼
	@GetMapping("/write")
	public String writeForm() {
		return "board/boardWriteForm";
	}

	private void fileUpload(BoardVO boardVO, RedirectAttributes rttr,
			@RequestParam("attachFile") MultipartFile multipartFile) {
		String imageFileName = multipartFile.getOriginalFilename();
		boardVO.setImageFileName(imageFileName);
		boardService.write(boardVO); // 데이터베이스에 저장

		// 업로드
		File uploadPath = new File("c:/mou_fileRepo/" + boardVO.getBno());
		if (!uploadPath.exists()) { // 업로드 패스 생성
			uploadPath.mkdirs();
		}
		// 업로드 파일 경로 지정
		File uploadFile = new File(uploadPath, imageFileName);
		try {
			multipartFile.transferTo(uploadFile); // 파일 업로드
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}

	@PostMapping("/write")
	public String insert(RedirectAttributes rttr, BoardVO boardVO,
			@RequestParam("attachFile") MultipartFile multipartFile) {
		log.info(multipartFile);

		if (!multipartFile.isEmpty()) {
			fileUpload(boardVO, rttr, multipartFile);
		} else {
			boardService.write(boardVO);
		}
		return "redirect:/board";
	}

}
