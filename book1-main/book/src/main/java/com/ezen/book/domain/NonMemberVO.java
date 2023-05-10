package com.ezen.book.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NonMemberVO {

	private int mem_num;
	private String mem_pw;
	private String mem_ad;
	private String mem_cell_num;
	private String mem_auth;
	private String mem_name;

}
