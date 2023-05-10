package com.ezen.book.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.book.domain.BookVO;
import com.ezen.book.domain.FileVO;
import com.ezen.book.domain.MemberVO;
import com.ezen.book.domain.OrderDTO;
import com.ezen.book.domain.OrderItemDTO;
import com.ezen.book.domain.OrderPageItemDTO;
import com.ezen.book.domain.OrderVO;
import com.ezen.book.domain.PagingVO;
import com.ezen.book.repository.BookDAO;
import com.ezen.book.repository.CartDAO;
import com.ezen.book.repository.FileDAO;
import com.ezen.book.repository.MemberDAO;
import com.ezen.book.repository.OrderDAO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

   @Inject
   private CartDAO Cdao;
   
   @Inject
   private OrderDAO Odao;
   
   @Inject
   private MemberDAO Mdao;
   
   @Inject
   private BookDAO Bdao;
   
   @Inject
   private FileDAO Fdao;

   @Override
   public List<OrderVO> getList(PagingVO pvo, String status, int mem_num) {
            log.info(">>> board list check2");
            if(status.equals("주문")) {
               return Odao.selectOrderList(pvo,mem_num);            
            }else {
            return Odao.selectBuyList(pvo,mem_num);
            }
      }

   @Override
   public int getOrderTotalCount( int mem_num) {
      // TODO Auto-generated method stub
      return Odao.orderTotalCount(mem_num);
   }
   
   @Override
   public int getBuyTotalCount(int mem_num) {
      // TODO Auto-generated method stub
      return Odao.buyTotalCount(mem_num);
   }
   
   
   

   @Override
   public List<OrderPageItemDTO> getGoodsInfo(List<OrderPageItemDTO> orders) {
      
      List<OrderPageItemDTO> result = new ArrayList<OrderPageItemDTO>();      
      
      for(OrderPageItemDTO ord : orders) {
         
         System.out.println(ord.getCart_book_num());
         
         OrderPageItemDTO goodsInfo = Odao.getGoodsInfo(ord.getCart_book_num());         
         
         System.out.println("가격이다"+ord.getTotalPoint());
         
         goodsInfo.setCart_book_num(ord.getCart_book_num());
         
         goodsInfo.setBookCount(ord.getBookCount());   
         
         goodsInfo.initSaleTotal();      
         
         List<FileVO> imageList = Fdao.selectFileList(ord.getCart_book_num());
         
         System.out.println("이미지입니다"+imageList.toString());
         
         goodsInfo.setImageList(imageList);         
         
         result.add(goodsInfo);         
      }      
      
      return result;

   }

   @Override
   @Transactional
   public void order(OrderDTO ord) {

      /* 사용할 데이터가져오기 */
         /* 회원 정보 */
         MemberVO member = Mdao.getMemberInfo(ord.getOrder_mem_num());
         /* 주문 정보 */
         List<OrderItemDTO> ords = new ArrayList<OrderItemDTO>();
         for(OrderItemDTO oit : ord.getOrders()) {
            OrderItemDTO orderItem = Odao.getOrderInfo(oit.getBook_num());
            // 수량 셋팅
            orderItem.setBook_name(oit.getBook_name());
            orderItem.setBookCount(oit.getBookCount());
            // 기본정보 셋팅
            orderItem.initSaleTotal();
            //List객체 추가
            ords.add(orderItem);
         }
         /* OrderDTO 셋팅 */
         ord.setOrders(ords);
         ord.getOrderPriceInfo();
         
      // db에 넣기
         
         /* orderId만들기 및 OrderDTO객체 orderId에 저장 */
         Date date = new Date();
         SimpleDateFormat format = new SimpleDateFormat("_yyyy-MM-dd-mm");
         ord.setOrder_date(format.format(date));
         String orderId =  ord.getOrder_mem_num() + format.format(date);
         ord.setOrder_num(orderId);
         
         System.out.println("오더 넘버 입니다"+orderId);
         
         // db에 넣기
         Odao.enrollOrder(ord);   //order 등록
         for(OrderItemDTO oit : ord.getOrders()) {   //orderItem 등록
            oit.setOrder_num(orderId);
            Odao.enrollOrderItem(oit);         
         }

      /* 비용 포인트 변동 적용 */
         
         /* 비용 차감 & 변동 돈(돈) Member객체 적용 */
         int calMoney = member.getMem_cash();       // 기존 돈을 가져와서 저장
         System.out.println("있던 돈"+calMoney);  // 문제 없음
         System.out.println("빠지는 돈이다"+ord.getOrderFinalSalePrice()); // 문제 있음
         calMoney -= ord.getOrderFinalSalePrice();      
         member.setMem_cash(calMoney);
         
         /* 포인트 차감, 포인트 증가 & 변동 포인트(point) Member객체 적용 */
         int calPoint = member.getMem_point();
         String rating = member.getMem_rating();
         System.out.println(rating);
         if(rating.equals("A")) {
         calPoint = calPoint - ord.getUsePoint() + (ord.getOrderSavePoint()*4);   // 기존 포인트 - 사용 포인트 + 획득 포인트
         member.setMem_point(calPoint);
         } else if (rating.equals("B")) {
            calPoint = calPoint - ord.getUsePoint() + (ord.getOrderSavePoint()*3);   // 기존 포인트 - 사용 포인트 + 획득 포인트
            member.setMem_point(calPoint);
         } else if (rating.equals("C")) {
            calPoint = calPoint - ord.getUsePoint() + (ord.getOrderSavePoint()*2);   // 기존 포인트 - 사용 포인트 + 획득 포인트
            member.setMem_point(calPoint);
         } else if (rating.equals("D")) {
            calPoint = calPoint - ord.getUsePoint() + ord.getOrderSavePoint();   // 기존 포인트 - 사용 포인트 + 획득 포인트
            member.setMem_point(calPoint);
         }
         
            
         /* 변동 돈, 포인트 DB 적용 */
         Odao.deductMoney(member);
         
      /* 재고 변동 적용 */
         for(OrderItemDTO oit : ord.getOrders()) {
            /* 변동 재고 값 구하기 */
            BookVO book = Bdao.getGoodsInfo(oit.getBook_num());
            book.setBook_count(book.getBook_count() - oit.getBookCount());
            book.setBook_sales(book.getBook_sales() + oit.getBookCount());
            /* 변동 값 DB 적용 */
            Odao.deductStock(book);
         }         
         
         // 장바구니 제거
         
         Cdao.deleteCart(ord.getOrder_mem_num());   // 고쳐야함   
         
         // 회원 장바구니 숫자 내려야한다!
         
         Mdao.deletememberCartNum(ord.getOrder_mem_num());
   
   }

   @Override
   public List<OrderDTO> getOrderList(int order_mem_num) {
      // 장바구니 정보 불러오기 
      return Odao.getOrderList(order_mem_num);
   }

   @Override
   public List<OrderItemDTO> orderDetail(String order_num) {
      // 구매 상세 페이지 불러오기
      return Odao.orderDetail(order_num);
   }

   @Override
   public List<FileVO> selectFileList(int book_num) {
      // 카트에 이미지 넣기
      return Fdao.selectFileList(book_num);
   }

   
}