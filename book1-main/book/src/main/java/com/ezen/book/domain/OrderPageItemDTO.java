package com.ezen.book.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderPageItemDTO {

	/* 뷰로부터 전달받을 값 */
	private int cart_book_num;

	private int bookCount;

	private int totalPrice;

	/* DB로부터 꺼내올 값 */
	private String book_title;

	private int book_price;

	/* 만들어 낼 값 */
	private int salePrice;

	/* private int totalPrice; */

	private int point;

	private int totalPoint;
	private List<FileVO> imageList;

	public void initSaleTotal() {
		this.salePrice = (int) (this.book_price);
		/* this.totalPrice = this.salePrice*this.bookCount; */
		this.point = (int) (Math.floor(this.salePrice * 0.05));
		this.totalPoint = this.point * this.bookCount;

	}

//	private List<AttachImageVO> imageList;	// 이미지 만들 예정 

}
