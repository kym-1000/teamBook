package com.ezen.book.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.book.domain.FaqVO;
import com.ezen.book.domain.MemberVO;
import com.ezen.book.domain.PagingVO;
import com.ezen.book.handler.PagingHandler;
import com.ezen.book.repository.MemberDAO;
import com.ezen.book.service.FaqService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/faq/*")
@Controller
public class FaqController {
   @Inject
   private FaqService fs;
   @Inject
   private MemberDAO mao;
   
   @GetMapping("/faqReg")
   public String boardRegisterGet(Model model) {
	   model.addAttribute("category", "faq");
	      model.addAttribute("content", "faqRegister");
      return "/member/memberAdmin";
   }
   
   @PostMapping("/faqReg")
   public String register(FaqVO fvo, RedirectAttributes reAttr) {
      log.info(fvo.toString());
      int isOk = fs.register(fvo);
      reAttr.addFlashAttribute("isOk", isOk>0 ? "1":"0");
      log.info("FAQ 글쓰기 체크1 >> " + (isOk>0 ? "Ok":"Fail"));
     
      
      return "redirect:/faq/faqList";
   }
   
   @GetMapping("/faqList") //관리자 faq리스트
   public String faqList(Model model,PagingVO pvo) {
      List<FaqVO> list = fs.getFaqList(pvo);
      int totalCount=fs.totalCount(pvo);
      PagingHandler ph  =  new PagingHandler(pvo, totalCount);
      model.addAttribute("li", list);
      log.info("FAQ 목록 체크2");
      model.addAttribute("pgh",ph);
      model.addAttribute("category", "faq");
      model.addAttribute("content", "faqList");
      return "/member/memberAdmin";
   }
   @GetMapping("/faqListOnly") //유저 faq페이지
   public String faqListOnly(Model model) {
      List<FaqVO> list = fs.getFaqList();
      model.addAttribute("li", list);
      return "/board/boardFaq";
   }
   @GetMapping("faqDetail")
   public String faqDetail(Model model, @RequestParam("faq_num")int faq_num) {
      log.info("FAQ 디테일 체크1");
      FaqVO fd = fs.getDetail(faq_num);
      model.addAttribute("fo", fd);
      model.addAttribute("category", "faq");
      model.addAttribute("content", "faqDetail");
      return "/member/memberAdmin";
      
   }
   @GetMapping("/faqModify")
   public String faqModify(Model model, @RequestParam("faq_num")int faq_num) {
      log.info("FAQ 디테일 체크1");
      FaqVO fd = fs.getDetail(faq_num);
      model.addAttribute("fo", fd);
      model.addAttribute("category", "faq");
      model.addAttribute("content", "faqModify");
      return "/member/memberAdmin";
      
   }
   
   @PostMapping("/faqModify")
   public String faqModify(RedirectAttributes reAttr, FaqVO fvo) {
      log.info("FAQ 모디파이 체크1");
      log.info(fvo.toString());
      int isUp = fs.modifyFaq(fvo);
      reAttr.addFlashAttribute(isUp>0 ? "1":"0");
      return "redirect:/faq/faqList";
   }
   @GetMapping("/faqRemove")
	public String faqRemove(RedirectAttributes reAttr, @RequestParam("faq_num")int faq_num, HttpServletRequest req) {
		log.info("FAQ 삭제 체크1");
		MemberVO mem = mao.getUser((MemberVO)req.getSession().getAttribute("ses"));
		int isUp = fs.removeFaq(faq_num, mem);
		log.info(">> FAQ 삭제 : "+(isUp > 0?"OK":"Fail"));
		return "redirect:/faq/faqList";
	}
}