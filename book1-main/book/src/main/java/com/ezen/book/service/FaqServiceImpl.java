package com.ezen.book.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ezen.book.domain.FaqVO;
import com.ezen.book.domain.MemberVO;
import com.ezen.book.domain.PagingVO;
import com.ezen.book.repository.FaqDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FaqServiceImpl implements FaqService {
	@Inject
	private FaqDAO fao;

	@Override
	public int register(FaqVO fvo) {
		return fao.insertFaq(fvo);
	}

	@Override
	public List<FaqVO> getFaqList(PagingVO pvo) {
		log.info("FAQ 목록 체크1");
		return fao.faqList(pvo);
	}

	@Override
	public FaqVO getDetail(int faq_num) {
		log.info("FAQ 디테일 체크2");
		return fao.faqDetail(faq_num);
	}

	@Override
	public int modifyFaq(FaqVO fvo) {
		log.info("FAQ 모디파이 체크2");
		return fao.faqModify(fvo);
	}

	@Override
	public int removeFaq(int faq_num, MemberVO mem) {
		log.info("FAQ 삭제 체크2");
		return fao.faqRemove(faq_num);
	}

	@Override
	public int totalCount(PagingVO pvo) {
		return fao.totalCount(pvo);
	}

	@Override
	public List<FaqVO> getFaqList() {
		// TODO Auto-generated method stub
		return fao.getFaqListOnly();
	}


}