package com.ezen.book.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
	
	private int Mem_num;
	private String Book_title;
	private String Book_writer;
	private int Book_amount;
	private int Book_price;
	private int cartId;
	private int bookId;

	
}
