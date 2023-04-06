package com.toyProject.controller.menu;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.log.UserDataHelper.Mode;
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

import com.toyProject.controller.FileController;
import com.toyProject.domain.BoardVO;
import com.toyProject.domain.paging.Criteria;
import com.toyProject.domain.paging.Pagination;
import com.toyProject.service.menu.BoardService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	private String boardFilePath = FileController.BOARD_FILE_PATH;
	
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
		return "board/boardDetail";
	}

	// 게시믈 작성 폼
	@GetMapping("/write")
	public String writeForm() {
		return "board/boardWriteForm";
	}

	private void fileUpload(BoardVO boardVO, @RequestParam("attachFile") MultipartFile multipartFile,
			RedirectAttributes rttr) {
		String imageFileName = multipartFile.getOriginalFilename();
		boardVO.setImageFileName(imageFileName);
		boardService.write(boardVO); // 데이터베이스에 저장

		// 업로드
		File uploadPath = new File(boardFilePath + boardVO.getBno());
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
	public String insert(BoardVO boardVO, @RequestParam("attachFile") MultipartFile multipartFile,
			RedirectAttributes rttr) {
		if (!multipartFile.isEmpty()) {
			fileUpload(boardVO, multipartFile, rttr);
		} else {
			boardService.write(boardVO);
		}
		return "redirect:/board";
	}

	@GetMapping("/modify")
	public void modifyForm(Long bno, Model model) {
		BoardVO vo = boardService.findByBno(bno);
		model.addAttribute("mod_board", vo);
	}

	@PostMapping("/modify")
	public String update(BoardVO boardVO, @RequestParam("attachFile") MultipartFile multipartFile, Model model,
			RedirectAttributes rttr, @RequestParam(defaultValue = "false") Boolean delCheck) {
		BoardVO boardDetail = boardService.findByBno(boardVO.getBno());
		model.addAttribute("board",boardDetail);
		if (delCheck) {
			// 파일 삭제 및 내용 변경
			// 파일 삭제
			File file = new File(boardFilePath + boardDetail.getBno() + "/" + boardDetail.getImageFileName());
			File folder = new File(boardFilePath + boardDetail.getBno());
			file.delete();
			folder.delete();
			boardDetail.setImageFileName("");
			// modify 호출
			boardService.modifyContent(boardDetail);
		} else {
			if (boardDetail.getImageFileName() != null) { // 이미지 및 내용 변경
				// 원본파일 삭제 새로운 파일 업로드
				File file = new File("c:/mou_fileRepo/board/" + boardDetail.getBno() + "/" + boardDetail.getImageFileName());
				file.delete();

				// 새로운 파일 업로드
				String imageFileName = multipartFile.getOriginalFilename();
				boardDetail.setImageFileName(imageFileName);
				File uploadPath = new File(boardFilePath + boardDetail.getBno());
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
				boardService.modifyContent(boardDetail);
			} else {
				boardService.modifyOnlyContent(boardDetail);
			}
		}

		return "redirect:/board";
	}
	
	// 게시글 삭제
	@PostMapping("/remove")
	public String delete(Long bno, RedirectAttributes rttr) throws IOException {
		BoardVO boardVO = boardService.findByBno(bno);
		if (boardVO.getImageFileName() != null) {
			File file = new File("c:/mou_fileRepo/board/" + bno);
			if (file.exists()) {
				FileUtils.deleteDirectory(file);
			}
		}
		boardService.removeContent(bno);
		return "redirect:/board";
	}

}
