package com.ezen.book.service;

import java.util.List;

import com.ezen.book.domain.CartVO;
import com.ezen.book.domain.MemberVO;
import com.ezen.book.domain.OrderDTO;
import com.ezen.book.domain.BookVO;
import com.ezen.book.domain.CartDTO;

public interface CartService {

	MemberVO getDetailmember(int mem_num); // 해당

	BookVO getCartBook(int book_num);

	List<CartVO> getCartList(int mem_num);

	int addCart(CartDTO cdo);

	int updateCart(CartDTO cdo); //

	CartVO getCart(CartDTO cdo); //

	int deleteCart(int mem_num); // 구매 후 장바구니를 삭제하는 메서드

	void deleteSelectCart(int cart_num); // 장바구니 내에서 해당 장바구니 삭제!

	int modifyCount(CartDTO cdto); // 장바구니 내에서 수량 설정

}
