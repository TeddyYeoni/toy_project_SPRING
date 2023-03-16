package com.toyProject.dao;

import java.util.List;

import com.toyProject.domain.AlbumVO;
import com.toyProject.domain.paging.Criteria;

public interface AlbumDAO {

	// 앨범 목록
	List<AlbumVO> albumList(Criteria criteria);
	
}
