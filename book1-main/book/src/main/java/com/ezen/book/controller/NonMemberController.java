package com.ezen.book.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.book.domain.MemberVO;
import com.ezen.book.domain.NonMemberVO;
import com.ezen.book.service.NonMemberService;
import com.ezen.book.service.NonMemberServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/nonMem/*")
@Controller
public class NonMemberController {

	@Inject
	private NonMemberService nmsv;

	@GetMapping("/orderNumsearch")
	public String orderNumsearch() {
		return "/member/memberOrderNumSearch";
	}

	@GetMapping("/orderPWsearch")
	public String orderPWsearch() {
		return "/member/memberOrderPwSearch";
	}

	@PostMapping("orderNumsearch") // 주문번호 찾기
	public String orderNumsearch(NonMemberVO umvo, RedirectAttributes reAttr) {
		int mem_num = nmsv.searchNum(umvo);
		log.info("mem_num 확인 : " + mem_num);
		if (mem_num != 0) {
			reAttr.addFlashAttribute("msg", mem_num);
		} else {
			reAttr.addFlashAttribute("msg", "0");
		}
		return "redirect:/nonMem/memberOrderNumSearch";
	}
//	@PostMapping("orderPwsearch") //주문비밀번호 찾기
//	public String orderPwsearch(UnmemberVO umvo,RedirectAttributes reAttr) {
//		int mem_num = nmsv.searchPw(umvo);
//		log.info("mem_num 확인 : "+mem_num);
//		if(mem_num !=0) {
//			reAttr.addFlashAttribute("msg", mem_num);
//		}else {
//			reAttr.addFlashAttribute("msg", "0");
//		}
//		return "redirect:/nonMem/orderPWsearch";
//	}
}
