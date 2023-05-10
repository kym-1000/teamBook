package com.ezen.book.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.book.domain.ReviewVO;
import com.ezen.book.service.ReviewService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/review/*")
@Controller
public class ReviewController {
   
   @Inject
   private ReviewService rsv;
   
   @PostMapping(value = "/post", consumes = "application/json",
         produces = {MediaType.TEXT_PLAIN_VALUE})
   public ResponseEntity<String> post(@RequestBody ReviewVO rvo){
      log.info(">>> review post : "+rvo.toString());
      int isUp = rsv.register(rvo);
      log.info(">>> register isUp : "+ (isUp>0? "ok": "fail"));
      
      return isUp >0? new ResponseEntity<String>("1", HttpStatus.OK) 
            : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
   }
   
   @GetMapping(value="/{book_num}", produces = {MediaType.APPLICATION_JSON_VALUE})
   public ResponseEntity<List<ReviewVO>> spread(@PathVariable("book_num")int book_num){
      log.info(" >>>> review List book_num: " +book_num);
      List<ReviewVO> list = rsv.getList(book_num);
      return new ResponseEntity<List<ReviewVO>>(list, HttpStatus.OK);
   }
}