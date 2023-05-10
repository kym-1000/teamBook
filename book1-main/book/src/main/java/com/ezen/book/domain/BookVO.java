package com.ezen.book.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookVO {
   
   private int book_num;
   private String book_title;
   private String book_writer;
   private int book_price;
   private int book_saleprice;
   private int book_sales;
   private String book_publisher;
   private String book_date;
   private int book_count;
   private String book_image;
   private String book_content;
   private int book_cno;
   
}