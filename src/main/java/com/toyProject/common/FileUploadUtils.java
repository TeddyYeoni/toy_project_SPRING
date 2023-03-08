package com.toyProject.common;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.toyProject.domain.AttachVO;
import com.toyProject.domain.FileType;

@Component
public class FileUploadUtils {

	private final static String BOARD_UPLOAD_FOLDER = "c:/file_repo/mou_board";

	public List<AttachVO> getAttachVOAndUpload(Long bno, MultipartFile[] multipartFiles) {
		List<AttachVO> attachList = new ArrayList<AttachVO>();
		for (MultipartFile mf : multipartFiles) {
			if (!mf.isEmpty()) { // MultipartFile 객체이 파일정보가 있을 때
				AttachVO attachVO = AttachVO.builder().bno(bno).fileName(mf.getOriginalFilename())
						.filePath(getFilePath(bno, mf.getOriginalFilename())).fileType(getFileType(mf.getContentType()))
						.build();
				attachList.add(attachVO);

				// 파일 업로드
				File folder = new File(BOARD_UPLOAD_FOLDER + "/" + bno);
				File file = new File(attachVO.getFilePath());
				if (!folder.exists()) {
					folder.mkdirs();
				}
				try {
					mf.transferTo(file);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
		}
		return attachList;
	}

	// 업로드 한 파일 경로
	private String getFilePath(Long bno, String originalFilename) {
		String uuid = UUID.randomUUID().toString();

		return BOARD_UPLOAD_FOLDER + "/" + bno + "/" + uuid + "_" + originalFilename;
	}

	// 파일 타입 결정
	private FileType getFileType(String contentType) {
		if (contentType.startsWith("image"))
			return FileType.IMAGE;
		else
			return FileType.OTHER;

	}

	// 모든 파일 삭제
	public void deleteAllFile(Long bno) {
		File delFolder = new File(BOARD_UPLOAD_FOLDER + "/" + bno);

		if (delFolder.exists()) {
			// 대상 폴더에 존재하는 모든 파일의 경로를 파일 객체로 생성
			File[] listFiles = delFolder.listFiles();
			for (File f : listFiles) {
				f.delete(); // 모든 파일 삭제
			}
			delFolder.delete(); // 폴더 삭제
		}

	}
}
