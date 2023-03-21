package com.toyProject.dao;

import java.util.List;

import com.toyProject.domain.AlbumVO;
import com.toyProject.domain.BoardVO;
import com.toyProject.domain.paging.Criteria;

public interface AlbumDAO {

	// 앨범 목록
	List<AlbumVO> albumList(Criteria criteria);

	// 마지막 게시물 번호 조회
	String getLastAno();

	// 사진 추가
	int addPhoto(AlbumVO albumVO);
}
