package com.ezen.book.domain;

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
public class OrderItemDTO {
   
   private String order_num;  // 주문번호
   
    private int book_num;   // 책 번호
    
    private int bookCount;  // 주문 수량
    
    private int book_price;      // 상품 가격
    
    private double book_saleprice;   // 상품 할인율
    
    private int savePoint;         // 상품 구매당 포인트
    
    private String book_name;      // 책 이름
    
    private List<FileVO> imageList;
    
   //
    
    private int salePrice;   // 할인 적용된 가격
    
    private int totalPrice;   // 총 가격 배송비 포함
    
    private int totalSavePoint;   // 총 얻는 포인트

      public void initSaleTotal() {
         this.salePrice = (int) (this.book_price);
         this.totalPrice = this.salePrice*this.bookCount;
         this.savePoint = (int)(Math.floor(this.salePrice*0.05));
         this.totalSavePoint = this.savePoint * this.bookCount;
      }      
      
   
   
}