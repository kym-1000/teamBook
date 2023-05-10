package com.ezen.book.repository;

import java.util.List;

import com.ezen.book.domain.FileVO;

public interface FileDAO {

	int insertFile(FileVO fvo);

	List<FileVO> selectFileList(int book_num);

	FileVO selectFile(int book_num);

	int deleteFile(String uuid);

}
