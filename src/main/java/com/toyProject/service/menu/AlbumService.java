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

	public List<AlbumVO> albumList(Criteria criteria) {
		return albumDAO.albumList(criteria);
	}

	public int getNewAno() {
		int photoNO = 0;
		int lastPhotoNO;

		if (albumDAO.getLastAno() == null) {
			lastPhotoNO = 0;
			return 1;
		}

		lastPhotoNO = Integer.parseInt(albumDAO.getLastAno());
		photoNO = lastPhotoNO + 1;
		return photoNO;
	}

	public int upload(AlbumVO albumVO) {
		int photoNO = getNewAno();
		albumVO.setAno((long) photoNO);
		return albumDAO.addPhoto(albumVO);
	}

	public AlbumVO findByAno(Long ano) {
		return albumDAO.findByAno(ano);
	}

	// 최근 목록 불러오기
	public List<AlbumVO> recentAlbumList() {
		return albumDAO.recentAlbumList();
	}

}
