package com.toyProject.service.menu;

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
	
	public int getNewAno() {
		int photoNO = 0;
		int lastPhotoNO = albumDAO.getLastAno();
		photoNO = lastPhotoNO + 1;
		if(photoNO == 0) {
			photoNO = 1;
		} 
		return photoNO;
	}
	
	public int upload(AlbumVO albumVO) {
		int photoNO = getNewAno();
		albumVO.setAno((long) photoNO);
		return albumDAO.addPhoto(albumVO);
	}
	
}
