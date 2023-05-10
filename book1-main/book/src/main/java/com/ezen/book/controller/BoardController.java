package com.ezen.book.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.book.domain.BoardVO;
import com.ezen.book.domain.MemberVO;
import com.ezen.book.domain.NoticeVO;
import com.ezen.book.domain.PagingVO;
import com.ezen.book.handler.PagingHandler;
import com.ezen.book.repository.BoardDAO;
import com.ezen.book.repository.CommentDAO;
import com.ezen.book.repository.MemberDAO;
import com.ezen.book.service.BoardService;
import com.ezen.book.service.MemberServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/board/*")
@Controller
public class BoardController {

	@Inject
	private BoardService bsv;
	@Inject
	private MemberDAO mdao;
	@Inject
	private MemberServiceImpl msv;
	@Inject
	private BoardDAO bdao;
	@Inject
	private CommentDAO cdao;

	@GetMapping("/tos") // 이용약관 페이지 이동
	public String tos() {
		return "/board/boardTos";
	}

	@GetMapping("/pp") // 개인정보방침 페이지 이동
	public String pp() {
		return "/board/boardPrivacyPolicy";
	}

	@GetMapping("/introduce") // 개인정보방침 페이지 이동
	public String introduce() {
		return "/board/boardIntroduce";
	}
	
	@GetMapping("/list")
	public String list(Model model,PagingVO pvo){
		log.info(">>>pageNo :"+pvo.getPageNo());
		List<BoardVO> list=bsv.getList(pvo);	
		model.addAttribute("list", list);
		int totalCount=bsv.getTotalCount(pvo);
		PagingHandler ph = new PagingHandler(pvo,totalCount);
		model.addAttribute("pgh",ph);
		
		model.addAttribute("content", "boardList");
		return "/member/memberMypage";
	}

	@GetMapping("/register")
	public String boardRegisterGet(Model model) {
		model.addAttribute("content", "boardRegister");
		return "/member/memberMypage";
	}

	@PostMapping("/register")
	public String register(BoardVO bvo) {
		bdao.register(bvo);
		return "redirect:/board/list";
	}

	@GetMapping("/boardDetail")
	public String boardDetail(Model model, @RequestParam("brd_num") int brd_num) {
		BoardVO board = bsv.getDetail(brd_num);
		bdao.countup(brd_num);
		model.addAttribute("board", board);
		model.addAttribute("content", "boardDetail");
		return "/member/memberMypage";
	}

	@GetMapping("/boardModify")
	public String boardModify(Model model, @RequestParam("brd_num") int brd_num) {
		BoardVO board = bsv.getDetail(brd_num);
		bdao.countup(brd_num);
		model.addAttribute("board", board);
		model.addAttribute("content", "boardModify");
		return "/member/memberMypage";
	}

	@PostMapping("/modify")
	public String modify(RedirectAttributes reAttr, BoardVO bvo) {
		log.info("modify>>>" + bvo.toString());
		MemberVO member = mdao.getMember(bvo.getBrd_writer());
		int isUp = bsv.modify(bvo, member);
		log.info(">>>modify:" + (isUp > 0 ? "ok" : "fail"));
		reAttr.addFlashAttribute(isUp > 0 ? "1" : "0");
		bdao.countdown(bvo.getBrd_num());
		return "redirect:/board/list";
	}

	@GetMapping("/remove")
	public String remove(@RequestParam("brd_num") int brd_num) {
		bdao.removerBoard(brd_num);
		cdao.removeComment(brd_num);
		return "redirect:/board/list";
	}
}
