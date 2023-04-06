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

	// 앨범 리스트
	public List<AlbumVO> albumList(Criteria criteria) {
		return albumDAO.albumList(criteria);
	}

	// 새로운 사진 번호 불러오기
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
	
	// 사진 업로드
	public int upload(AlbumVO albumVO) {
		int photoNO = getNewAno();
		albumVO.setAno((long) photoNO);
		return albumDAO.addPhoto(albumVO);
	}

	// 앨범 상세 조회
	public AlbumVO findByAno(Long ano) {
		return albumDAO.findByAno(ano);
	}

	// 최근 목록 불러오기
	public List<AlbumVO> recentAlbumList() {
		return albumDAO.recentAlbumList();
	}
	
	// 사진 삭제
	public void removePhoto(Long ano) {
		albumDAO.removePhoto(ano);
	}
	
	// 앨범 수정
	public void modify(AlbumVO albumVO) {
		albumDAO.modifyAlbum(albumVO);
	}

}
