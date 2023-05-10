package com.ezen.book.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDTO {
	
	private String order_num; // 주문번호
	
	private String addressee;	// 배송 받는이 
	
	private int order_mem_num;	// 주문 회원 숫자
	
	private String order_add1;	//  우편번호
	
	private String order_add2;   //  회원 주소
		
	private String order_sta; //  주문상태
	
	private List<OrderItemDTO> orders;	// 주문 상품
	
	private int deliveryCost; // 배송비
	
	private int usePoint;	// 사용포인트
	
	private String order_date;	//  주문 날짜
	
	//
	
	private int orderSalePrice;  // 판매가
	
	private int orderSavePoint;  // 적립 포인트
	
	private int orderFinalSalePrice;   // 최종 판매 비용

	public void getOrderPriceInfo() {
		/* 상품 비용 & 적립포인트 */
			for(OrderItemDTO order : orders) {
				orderSalePrice += order.getTotalPrice();
				orderSavePoint += order.getTotalSavePoint();
			}
		/* 배송비용 */
			if(orderSalePrice >= 30000) {
				deliveryCost = 0;
			} else {
				deliveryCost = 3000;
			}
		/* 최종 비용(상품 비용 + 배송비 - 사용 포인트) */
			
			orderFinalSalePrice = orderSalePrice + deliveryCost - usePoint;
	}		

}
