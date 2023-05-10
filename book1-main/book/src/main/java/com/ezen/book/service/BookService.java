package com.ezen.book.service;

import java.util.ArrayList;
import java.util.List;

import com.ezen.book.domain.BoardVO;
import com.ezen.book.domain.BookDTO;
import com.ezen.book.domain.BookVO;
import com.ezen.book.domain.FileVO;
import com.ezen.book.domain.MemberVO;
import com.ezen.book.domain.PagingVO;

public interface BookService {

   ArrayList<BookVO> getSearchList(PagingVO pvo);

   int getTotalCount(PagingVO pvo);

   ArrayList<BookVO> getBookList();

   ArrayList<BookVO> getSelectBookList(int content);
   
   int register(BookDTO bkto);

   BookDTO getDetailBook(int book_num);

   int modify(BookDTO bookDTO);

   FileVO getFile(int book_num);

   int bookRemove(int book_num, MemberVO mem);

   int removeFile(String uuid);

   List<BookVO> getList(PagingVO pvo);

   BookVO detailSelectOne(int book_num);

   BookVO getBookOne();

int getTotalCount2();

}