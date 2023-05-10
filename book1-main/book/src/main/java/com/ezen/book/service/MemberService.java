package com.ezen.book.service;

import java.util.List;

import com.ezen.book.domain.MemberVO;
import com.ezen.book.domain.PagingVO;

public interface MemberService {

	String join(MemberVO mvo);

	MemberVO login(String id, String pw);

	int usermodify(MemberVO mvo);

	String getId(MemberVO mvo);

	String getPw(MemberVO mvo);

	int update(String addressAll);

	int newPwUpdate(MemberVO mvo);

	String idCheck(String mem_id);

	String pwCheck(String mem_pw);

	String cellNumCheck(String mem_cell_num);

	int deleteMember(int mem_num);

	List<MemberVO> getMemList(PagingVO pvo);

	int removeMem(int mem_num, MemberVO member);

	int totalCount(PagingVO pvo);

	String pwCheckRe(String mem_pwRe);

	

	int moneyCharge(String mem_id, int mem_cash);

	int getCharge(String mem_id);


	public MemberVO getMemberInfo(int mem_num);  // 구매페이지에 회원정보를 불러오기 

	public int memberCartNumUP(int mn);	 // 회원정보에 장바구니 숫자를 올리기!

	public int memberCartNumDown(int mem_num);

	MemberVO getIdAll(String mem_id);

	MemberVO getMemNumAll(int mem_num);
	
	/* int putGrade(MemberVO mvo); */

	/* int putGrade(int mem_num,String mem_rating); */

	/* String getRating(int mem_num); */

	int putGrade(MemberVO mvo);

	MemberVO getNumAll(int mem_num);

	MemberVO getmvo(int mem_num);



}
