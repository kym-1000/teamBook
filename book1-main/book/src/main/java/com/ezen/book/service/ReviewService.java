package com.ezen.book.service;

import java.util.List;

import com.ezen.book.domain.ReviewVO;

public interface ReviewService {

	int register(ReviewVO rvo);

	List<ReviewVO> getList(int book_num);

}
