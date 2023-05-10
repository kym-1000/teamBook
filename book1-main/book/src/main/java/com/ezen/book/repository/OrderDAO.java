package com.ezen.book.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ezen.book.domain.BookVO;
import com.ezen.book.domain.CartVO;
import com.ezen.book.domain.DeliveryDTO;
import com.ezen.book.domain.MemberVO;
import com.ezen.book.domain.OrderDTO;
import com.ezen.book.domain.OrderItemDTO;
import com.ezen.book.domain.OrderPageItemDTO;
import com.ezen.book.domain.OrderVO;
import com.ezen.book.domain.PagingVO;

@Repository
public interface OrderDAO {



   List<OrderVO> selectBuyList(@Param("pvo")PagingVO pvo , @Param("mem_num")int mem_num);

   List<OrderVO> selectOrderList(@Param("pvo")PagingVO pvo , @Param("mem_num")int mem_num);


   int orderTotalCount(int mem_num);


   int buyTotalCount(int mem_num);
   
   public OrderPageItemDTO getGoodsInfo(int cart_book_num); // 주문 책 정보 

     public OrderItemDTO getOrderInfo(int book_num); // 주문 상품 정보(주문처리)

     public void enrollOrder(OrderDTO ord);         // 주문 테이블 등록

     public void enrollOrderItem(OrderItemDTO oit);   // 주문 아이템 테이블 등록

     public void deductMoney(MemberVO member);      // 주문 금액 차감

     public void deductStock(BookVO book);         // 주문 재고 차감

     public void deleteOrderCart(CartVO dto);      // 장바구니 삭제

     public List<OrderDTO> getOrderList(int order_mem_num);   // 장바구니 정보 불러오기

     public List<OrderItemDTO> orderDetail(String order_num);         // 주문 상세 페이지

   void Confirmed(String order_num);

   void setDelivery(DeliveryDTO ddto);

}