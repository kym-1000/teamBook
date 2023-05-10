package com.ezen.book.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReviewVO {
   private int review_book_num;
   private int review_rating;
   private String review_mem_id;
   private String review_content;
   private String review_regdate;
}