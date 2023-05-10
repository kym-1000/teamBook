package com.ezen.book.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ezen.book.domain.NoticeVO;
import com.ezen.book.domain.OrderVO;
import com.ezen.book.domain.PagingVO;

@Repository
public interface NoticeDAO {

	List<NoticeVO> getNoticeList(@Param("pvo")PagingVO pvo);

	NoticeVO getDetail(int ntc_num);

	int noticeRegister(NoticeVO nvo);

	int getModify(NoticeVO nvo);

	int getDelete(int ntc_num);

	int getTotalCount(PagingVO pvo);

}
