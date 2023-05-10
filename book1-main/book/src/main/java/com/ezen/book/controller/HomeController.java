package com.ezen.book.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.book.domain.BookVO;
import com.ezen.book.domain.CommentVO;
import com.ezen.book.domain.FileDTO;
import com.ezen.book.domain.FileVO;
import com.ezen.book.domain.MemberVO;
import com.ezen.book.domain.PagingVO;
import com.ezen.book.handler.PagingHandler;
import com.ezen.book.repository.MemberDAO;
import com.ezen.book.service.BookService;
import com.ezen.book.service.MemberService;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */

@Slf4j
@Controller
public class HomeController {

   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

   @Inject
   private BookService bks;

   @Inject
   private MemberDAO mdao;
   
   @Inject
   private MemberService msv;
  
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String home(Locale locale, Model model) {

      Date date = new Date();
      DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

      String formattedDate = dateFormat.format(date);

      model.addAttribute("serverTime", formattedDate);

      ArrayList<BookVO> list = bks.getBookList();
      
      FileVO fvo = new FileVO(); 
      List<FileDTO> list2 = new ArrayList<FileDTO>();
      for(BookVO b : list) {
         int book_num = b.getBook_num();
         fvo = bks.getFile(book_num);
         if(fvo != null) {
            FileDTO fdto = new FileDTO(b, fvo.getSave_dir(), fvo.getUuid(), fvo.getFile_name());
            list2.add(fdto);
      
         }else {
            FileDTO fdto = new FileDTO(b, "", "", "");
            list2.add(fdto);
         }
      }
      model.addAttribute("book_list", list2);
         model.addAttribute("content", "main");
         
      
      BookVO bvo=bks.getBookOne();   
      log.info("bvo"+bvo.getBook_cno());
      
      FileVO fvo2 = new FileVO(); 
      List<FileDTO> list3 = new ArrayList<FileDTO>();
      
         int book_num = bvo.getBook_num();
         fvo2 = bks.getFile(book_num);
         if(fvo2 != null) {
            FileDTO fdto = new FileDTO(bvo, fvo2.getSave_dir(), fvo2.getUuid(), fvo2.getFile_name());
            list3.add(fdto);
      
         }else {
            FileDTO fdto = new FileDTO(bvo, "", "", "");
            list3.add(fdto);
         }   
      
 
      model.addAttribute("randombook", list3);
      return "home";
      
   }
   
 
   
   
   
   
   
   @GetMapping("/introduce")
   public String getIntroduce(Model model) {
      String okay="main";
      model.addAttribute("content", okay);
      return "/board/boardIntroduce";
   }
   @GetMapping("/content")
   public String detailList(Model model, @RequestParam("content")String content) {
      String okay=content;
      model.addAttribute("content", okay);
      return "/board/boardIntroduce";   
   }
   @GetMapping("/tos")
   public String getTos(Model model) {
      String okay="tos";
      model.addAttribute("content", okay);
      return "/board/boardTos";
   }
   @GetMapping("/pp")
   public String getPp(Model model) {
      String okay="pp";
      model.addAttribute("content", okay);
      return "/board/boardTos";
   }
   
  
   @GetMapping("/interest")
   public String interest(Model model,@RequestParam("mem_cno") int mem_cno) {
      String content="";
      switch (mem_cno) {
   case 1: 
      content="novel";
      break;
   case 2: 
      content="essay";
      break;
   case 3: 
      content="life";
      break;
   case 4: 
      content="computer";
      break;
   default:
      content="problem";
      break;
   }
         model.addAttribute("content", content);
         ArrayList<BookVO> list = bks.getSelectBookList(mem_cno); // 
         FileVO fvo = new FileVO(); 
         List<FileDTO> list2 = new ArrayList<FileDTO>();
         for(BookVO b : list) {
            int book_num = b.getBook_num();
            fvo = bks.getFile(book_num);
            if(fvo != null) {
               FileDTO fdto = new FileDTO(b, fvo.getSave_dir(), fvo.getUuid(), fvo.getFile_name());
               list2.add(fdto);
         
            }else {
               FileDTO fdto = new FileDTO(b, "", "", "");
               list2.add(fdto);
            }
         }      
         BookVO bvo=bks.getBookOne();   
         log.info("bvo"+bvo.getBook_cno());
         
         FileVO fvo2 = new FileVO(); 
         List<FileDTO> list3 = new ArrayList<FileDTO>();
         
            int book_num = bvo.getBook_num();
            fvo2 = bks.getFile(book_num);
            if(fvo2 != null) {
               FileDTO fdto = new FileDTO(bvo, fvo2.getSave_dir(), fvo2.getUuid(), fvo2.getFile_name());
               list3.add(fdto);
         
            }else {
               FileDTO fdto = new FileDTO(bvo, "", "", "");
               list3.add(fdto);
            }   
         
    
         model.addAttribute("randombook", list3);
         log.info("randombook"+list3.size());
         model.addAttribute("book_list", list2);   
         return "home";      
      }
   
   
   
   
   @GetMapping("/event")
   public String getRating() {
      
      return "/event";
   }
   
   @PostMapping(value="/event", consumes="application/json", produces= {MediaType.TEXT_PLAIN_VALUE})
   public ResponseEntity<String> post(@RequestBody MemberVO mvo,HttpServletRequest req){
      int isUp = msv.putGrade(mvo);
      log.info("이벤트 mvo"+mvo.toString());
      log.info(">>> register isUp : "+(isUp>0? "ok" : "fail"));
      
      MemberVO mvo2 = mdao.getMemNumAll(mvo.getMem_num());
      log.info("이벤트 mvo2"+mvo2.toString());
        HttpSession ses = req.getSession(); 
        ses.setAttribute("ses", mvo2);
        ses.setMaxInactiveInterval(60 * 10);
      
        return isUp>0? new ResponseEntity<String>("1",HttpStatus.OK)
                  : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);

   }
   

   
 
   
   
   
   
}