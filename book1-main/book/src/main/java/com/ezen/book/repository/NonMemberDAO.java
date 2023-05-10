package com.ezen.book.repository;

import org.springframework.stereotype.Repository;

import com.ezen.book.domain.NonMemberVO;

@Repository
public interface NonMemberDAO {


	NonMemberVO getNum(NonMemberVO umvo);

	int searchNum(NonMemberVO umvo);

}
