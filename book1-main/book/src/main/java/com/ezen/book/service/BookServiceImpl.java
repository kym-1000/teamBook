package com.ezen.book.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ezen.book.domain.BoardVO;
import com.ezen.book.domain.BookDTO;
import com.ezen.book.domain.BookVO;
import com.ezen.book.domain.FileVO;
import com.ezen.book.domain.MemberVO;
import com.ezen.book.domain.PagingVO;
import com.ezen.book.repository.BookDAO;
import com.ezen.book.repository.FileDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

   @Inject
   private BookDAO bko;
   @Inject
   private FileDAO fao;

   @Override
   public ArrayList<BookVO> getSearchList(PagingVO pvo) {
      log.info(">>> board Paging List check2");

      return bko.selectBookListPaging(pvo);
   }

   @Override
   public int getTotalCount(PagingVO pvo) {
      return bko.searchBookTotalCount(pvo);
   }

   @Override
   public ArrayList<BookVO> getBookList() {
      return bko.getBookList();
   }

   @Override
   public ArrayList<BookVO> getSelectBookList(int content) {
      return bko.getBookList2(content);
   }

   @Override
   public int register(BookDTO bkto) {
      log.info(">> book register 체크2");
      int isOk = bko.insertBook(bkto.getBkvo());
      if (bkto.getFList() == null) {
         isOk *= 1;
      } else if (isOk > 0 && bkto.getFList().size() > 0) {
         int book_num = bko.selectOneBookNum();
         for (FileVO fvo : bkto.getFList()) {
            fvo.setBook_num(book_num);
            log.info(">>insert file: " + fvo.toString());
            isOk *= fao.insertFile(fvo);
         }
      }
      return isOk;
   }

   @Override
   public List<BookVO> getList(PagingVO pvo) {
      log.info(">> book list 체크2");
      return bko.selectBookList(pvo);
   }

   @Override
   public BookDTO getDetailBook(int book_num) {
      BookDTO bkto = new BookDTO(bko.bookDetail(book_num), fao.selectFileList(book_num));
      return bkto;
   }

   @Override
   public int modify(BookDTO bkto) {
      log.info(">>> book modify 체크2");
      int isUp = bko.updateBook(bkto.getBkvo());
      if (bkto.getFList() == null) {
         isUp *= 1;
      } else {
         if (isUp > 0 && bkto.getFList().size() > 0) {
            int book_num = bkto.getBkvo().getBook_num();
            for (FileVO fvo : bkto.getFList()) {
               fvo.setBook_num(book_num);
               isUp *= fao.insertFile(fvo);
            }
         }
      }
      return isUp;
   }

   @Override
   public FileVO getFile(int book_num) {

      return fao.selectFile(book_num);
   }

   @Override
   public int bookRemove(int book_num, MemberVO mem) {
      log.info(">>> book remove 체크2");

      return bko.deleteBook(book_num);
   }

   @Override
   public int removeFile(String uuid) {
      log.info(">> file remove 체크2");
      int isUp = fao.deleteFile(uuid);
      return isUp;
   }

   @Override
   public BookVO detailSelectOne(int book_num) {
      return bko.detailSelectOne(book_num);
   }

   @Override
   public BookVO getBookOne() {
      // TODO Auto-generated method stub
      return bko.getBookOne();
   }

@Override
public int getTotalCount2() {
	return bko.getTotalCount2();
}

}