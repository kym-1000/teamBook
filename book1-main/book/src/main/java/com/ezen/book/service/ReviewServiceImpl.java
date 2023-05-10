package com.ezen.book.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ezen.book.domain.ReviewVO;
import com.ezen.book.repository.ReviewDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReviewServiceImpl implements ReviewService {

   @Inject
   private ReviewDAO rao;
   
   @Override
   public int register(ReviewVO rvo) {
      log.info("review 등록 체크2");
      return rao.insertReview(rvo);
   }

   @Override
   public List<ReviewVO> getList(int book_num) {
      log.info("review 리스트 체크2");
      return rao.reviewList(book_num);
   }

}