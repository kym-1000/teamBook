package com.ezen.book.repository;

import java.util.List;

import com.ezen.book.domain.ReviewVO;

public interface ReviewDAO {

   int insertReview(ReviewVO rvo);

   List<ReviewVO> reviewList(int book_num);

}