package com.ezen.book.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.POST;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.book.domain.NoticeVO;
import com.ezen.book.domain.PagingVO;
import com.ezen.book.handler.PagingHandler;
import com.ezen.book.service.BoardService;
import com.ezen.book.service.NoticeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/ntc/*")
@Controller
public class NoticeController {

	@Inject
	private NoticeService nsv;

	@GetMapping({ "/noticeList", "/notice" })
	public String notice(Model model, PagingVO pvo) {
		List<NoticeVO> nvo = nsv.getNoticeList(pvo);
		model.addAttribute("notice_list", nvo);
		model.addAttribute("content", "notice_list");
		model.addAttribute("category", "notice");

		int totalCount = nsv.getTotalCount(pvo);

		PagingHandler ph = new PagingHandler(pvo, totalCount);
		model.addAttribute("pgh", ph);
		return "/member/memberAdmin";
	}

	@GetMapping("/noticeDetail")
	public String noticeDetail(Model model, @RequestParam("ntc_num") int ntc_num) {
		NoticeVO nvo = nsv.getDetail(ntc_num);
		model.addAttribute("nvo", nvo);
		model.addAttribute("content", "noticeDetail");
		model.addAttribute("category", "notice");
		return "/member/memberAdmin";
	}

	@GetMapping("/noticeRegister")
	public String noticeRegister(Model model) {
		model.addAttribute("content", "noticeRegister");
		model.addAttribute("category", "notice");
		return "/member/memberAdmin";
	}

	@PostMapping("/noticeRegister")
	public String noticeRegister(Model model, NoticeVO nvo) {
		int isOk = nsv.noticeRegister(nvo);
		return "redirect:/ntc/noticeList";
	}

	@GetMapping("/noticeModify")
	public String noticeModify(Model model, @RequestParam("ntc_num") int ntc_num) {
		NoticeVO nvo = nsv.getDetail(ntc_num);
		model.addAttribute("nvo", nvo);
		model.addAttribute("content", "noticeModify");
		model.addAttribute("category", "notice");
		return "/member/memberAdmin";
	}

	@PostMapping("/noticeModify")
	public String noticeModify(Model model, NoticeVO nvo) {
		int isOk = nsv.getModify(nvo);
		log.info(nvo.toString());
		return "redirect:/ntc/noticeList";
	}

	@GetMapping("/noticeDelete")
	public String noticeDelete(Model model, @RequestParam("ntc_num") int ntc_num) {
		int isOk = nsv.getDelete(ntc_num);

		return "redirect:/ntc/noticeList";
	}

	@GetMapping("/noticeOnly") // footer 공지사항 페이지
	public String noticeOnly(Model model, PagingVO pvo) {
		List<NoticeVO> nvo = nsv.getNoticeListOnly(pvo);
		model.addAttribute("notice_list", nvo);

		int totalCount = nsv.getTotalCount(pvo);

		PagingHandler ph = new PagingHandler(pvo, totalCount);

		model.addAttribute("pgh", ph);
		model.addAttribute("content", "notice_list");
		return "/board/boardNotice";
	}

	@GetMapping("/noticeDetailOnly")// footer 공지사항 상세 페이지
	public String noticeDetailOnly(Model model, @RequestParam("ntc_num") int ntc_num) {
		NoticeVO nvo = nsv.getDetail(ntc_num);
		model.addAttribute("nvo", nvo);
		model.addAttribute("content", "noticeDetail");
		return "/board/boardNotice";
	}

}
