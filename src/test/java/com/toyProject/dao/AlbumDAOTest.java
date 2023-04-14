package com.toyProject.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.toyProject.AppTest;
import com.toyProject.dao.album.AlbumDAO;

import lombok.extern.log4j.Log4j;

@Log4j
public class AlbumDAOTest extends AppTest {

	@Autowired
	AlbumDAO albumDAO;

	@Test
	public void getLastNOTest() {
		String lastAno = albumDAO.getLastAno();
		log.info(lastAno);
	}

}
