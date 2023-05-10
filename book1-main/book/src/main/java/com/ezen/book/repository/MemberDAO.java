package com.ezen.book.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ezen.book.domain.MemberVO;
import com.ezen.book.domain.PagingVO;

@Repository
public interface MemberDAO {

   MemberVO getId(String mem_id);

   int insertMember(MemberVO mvo);

   int login(MemberVO mvo);

   int usermodify(MemberVO mvo);

   String getIdSearch(MemberVO mvo);

   String getPwSearch(MemberVO mvo);

   int updateAdderess(String addressAll);

   int newPwUpdate(MemberVO mvo);

   String getCellNum(String mem_cell_num);

   int memberDelete(int mem_num);

   MemberVO getMember(String brd_writer);

   List<MemberVO> memberList(PagingVO pvo);

   int memRemove(int mem_num);

   MemberVO getUser(MemberVO attribute);

   int totalCount(PagingVO pvo);

   int insertGrade(MemberVO mvo);

   int moneyCharge(@Param("mem_id") String mem_id, @Param("mem_cash") int mem_cash);

   int getCharge(String mem_id);

   MemberVO getMemberInfo(int mem_num); // 멤버 정보 결제페이지로 불러오기

   int memberCartNumUP(int mem_num); // 회원정보에서 장바구니 갯수 표시

   int memberCartNumDown(int mem_num);   // 장바구니에서 삭제하면 -1

   void deletememberCartNum(int order_mem_num);  // 구매시 회원의 장바구니 넘버를 0으로 만듬

   MemberVO getIdAll(String mem_id);

   MemberVO getMemNumAll(int mem_num);

MemberVO getMvo(int mem_num);

   /*
    * String putGrade(@Param("mem_num")int mem_num,@Param("mem_rating") String
    * mem_rating);
    */

   /*
    * int insertGrade(@Param("mem_num")int mem_num,@Param("mem_rating") String
    * mem_rating);
    */

   /* String getRating(int mem_num); */
   
}