package com.ezen.book.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ezen.book.domain.NoticeVO;
import com.ezen.book.domain.PagingVO;
import com.ezen.book.repository.NoticeDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NoticeServiceImpl implements NoticeService {

	@Inject
	private NoticeDAO ndao;

	@Override
	public List<NoticeVO> getNoticeList(PagingVO pvo) {
		log.info("getPageStart"+pvo.getPageStart());
		log.info("getQty"+pvo.getQty());
		return ndao.getNoticeList(pvo);
	}

	@Override
	public NoticeVO getDetail(int ntc_num) {
		return ndao.getDetail(ntc_num);
	}

	@Override
	public int noticeRegister(NoticeVO nvo) {
		return ndao.noticeRegister(nvo);
	}

	@Override
	public int getModify(NoticeVO nvo) {
		return ndao.getModify(nvo);
	}

	@Override
	public int getDelete(int ntc_num) {
		return ndao.getDelete(ntc_num);
	}

	@Override
	public int getTotalCount(PagingVO pvo) {
		return ndao.getTotalCount(pvo);
	}

}
