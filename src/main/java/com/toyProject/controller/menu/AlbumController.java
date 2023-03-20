package com.toyProject.controller.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.toyProject.domain.AlbumVO;
import com.toyProject.domain.paging.Criteria;
import com.toyProject.service.menu.AlbumService;

@Controller
@RequestMapping("/album")
public class AlbumController {

	@Autowired
	private AlbumService albumService;

	@GetMapping(value = { "", "/", "/list" })
	public String albumList(Model model, Criteria criteria) {
		List<AlbumVO> albumList = albumService.albumList(criteria);
		model.addAttribute("album_list",albumList);
		return "album/albumList";
	}
	
	@GetMapping("/upload")
	public String uploadForm() {
		return "album/albumUploadForm";
	}

}
