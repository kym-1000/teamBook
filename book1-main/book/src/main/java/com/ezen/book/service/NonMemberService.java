package com.ezen.book.service;

import com.ezen.book.domain.NonMemberVO;

public interface NonMemberService {

	NonMemberVO login(NonMemberVO umvo);

	int searchNum(NonMemberVO umvo);

//	int searchPw(UnmemberVO umvo);



}
