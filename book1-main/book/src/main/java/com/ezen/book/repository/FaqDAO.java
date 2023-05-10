package com.ezen.book.repository;

import java.util.List;

import com.ezen.book.domain.FaqVO;
import com.ezen.book.domain.PagingVO;

public interface FaqDAO {

	int insertFaq(FaqVO fvo);

	List<FaqVO> faqList(PagingVO pvo);

	FaqVO faqDetail(int faq_num);

	int faqModify(FaqVO fvo);

	int faqRemove(int faq_num);

	int totalCount(PagingVO pvo);

	List<FaqVO> getFaqListOnly();

}