package com.toyProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyProject.dao.AlbumDAO;
import com.toyProject.domain.AlbumVO;
import com.toyProject.domain.paging.Criteria;

@Service
public class AlbumService {

	@Autowired
	private AlbumDAO albumDAO;
	
	public List<AlbumVO> albumList(Criteria criteria){
		return albumDAO.albumList(criteria);
	}
	
}
