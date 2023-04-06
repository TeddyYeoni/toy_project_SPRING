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

	// 사진 상세 보기
	AlbumVO findByAno(Long ano);

	// 최근 목록 불러오기
	List<AlbumVO> recentAlbumList();

	// 사진 삭제
	void removePhoto(Long ano);

	// 앨범 수정
	void changePhoto(AlbumVO albumVO);
	
	// 글만 수정
	void modifyAlbumContent(AlbumVO albumVO);

}
