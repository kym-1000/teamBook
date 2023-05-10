package com.ezen.book.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ezen.book.domain.FaqVO;
import com.ezen.book.domain.PagingVO;

public interface FaqDAO {

	int insertFaq(FaqVO fvo);

	List<FaqVO> faqList(@Param("pvo")PagingVO pvo);

	FaqVO faqDetail(int faq_num);

	int faqModify(FaqVO fvo);

	int faqRemove(int faq_num);

	int totalCount();

	List<FaqVO> getFaqListOnly();

}