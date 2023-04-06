package com.toyProject.controller.menu;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.toyProject.domain.AlbumVO;
import com.toyProject.domain.paging.Criteria;
import com.toyProject.service.menu.AlbumService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/album")
@Log4j
public class AlbumController {

	@Autowired
	private AlbumService albumService;

	@GetMapping(value = { "", "/", "/list" })
	public String albumList(Model model, Criteria criteria) {
		List<AlbumVO> albumList = albumService.albumList(criteria);
		model.addAttribute("album_list", albumList);
		return "album/albumList";
	}

	@GetMapping("/upload")
	public String uploadForm() {
		return "album/albumUploadForm";
	}

	// 이미지 파일 업로드
	private void fileUpload(AlbumVO albumVO, RedirectAttributes rttr,
			@RequestParam("attachFile") MultipartFile multipartFile) {
		String imageFileName = multipartFile.getOriginalFilename();
		albumVO.setImageFileName(imageFileName);
		albumService.upload(albumVO); // 데이터베이스에 저장

		// 업로드
		File uploadPath = new File("c:/mou_fileRepo/album/" + albumVO.getAno());
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

	// 앨범 사진 추가
	@PostMapping("/upload")
	public String insert(RedirectAttributes rttr, AlbumVO albumVO,
			@RequestParam("attachFile") MultipartFile multipartFile) {
		if (!multipartFile.isEmpty()) {
			fileUpload(albumVO, rttr, multipartFile);
		} else {
			albumService.upload(albumVO);
		}
		return "redirect:/album";
	}

	// 앨범 상세 조회
	@GetMapping("/detail")
	public String select(Model model, Long ano) {
		model.addAttribute("album", albumService.findByAno(ano));
		return "album/albumDetail";
	}

	// 앨범 사진 삭제
	@PostMapping("/remove")
	public String delete(Long ano,RedirectAttributes rttr)
			throws IOException {
		AlbumVO albumVO = albumService.findByAno(ano);
		if (albumVO.getImageFileName() != null) {
			File file = new File("c:/mou_fileRepo/album/" + ano);
			if (file.exists()) {
				FileUtils.deleteDirectory(file);
			}
		}
		albumService.removePhoto(ano);
		return "redirect:/album";
	}

}
