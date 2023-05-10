package com.ezen.book.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ezen.book.domain.CartVO;
import com.ezen.book.domain.MemberVO;
import com.ezen.book.domain.OrderDTO;
import com.ezen.book.domain.BookVO;
import com.ezen.book.domain.CartDTO;
import com.ezen.book.repository.CartDAO;
import com.ezen.book.repository.MemberDAO;

@Service
public class CartServiceImpl implements CartService {
	
	
	@Inject
	private CartDAO cdao;
	
	@Inject
	private MemberDAO Mdao;

	@Override
	public MemberVO getDetailmember(int mem_num) {
		// TODO Auto-generated method stub
		return cdao.selectmemberONE(mem_num);
	}

	@Override
	public BookVO getCartBook(int book_num) {
		// 해당하는 책을 가져옴
		return cdao.getBook(book_num);
	}

	@Override
	public List<CartVO> getCartList(int mem_num) {
		// 회원넘버에 해당하는 장바구니 리스트를 불러옴
		return cdao.CartList(mem_num);
	}

	@Override
	public int addCart(CartDTO cdo) {
		// TODO Auto-generated method stub
		return cdao.addCartBook(cdo);
	}

	@Override
	public int updateCart(CartDTO cdo) {
		// TODO Auto-generated method stub
		return cdao.updateCart(cdo);
	}

	@Override
	public CartVO getCart(CartDTO cdo) {
		// TODO Auto-generated method stub
		return cdao.selectCart(cdo);
	}


	@Override
	public int deleteCart(int mem_num) {
		// TODO Auto-generated method stub
		return cdao.deleteCart(mem_num);
	}


	@Override
	public void deleteSelectCart(int cart_num) {
		// 장바구니에서 특정 물건을 삭제
		cdao.deleteSelectCart(cart_num);
	}

	@Override
	public int modifyCount(CartDTO cdto) {
		// 장바구니에서 수량을 조절
		return cdao.modifyCount(cdto);
	}



	
	

	

	

	

	
	

}
