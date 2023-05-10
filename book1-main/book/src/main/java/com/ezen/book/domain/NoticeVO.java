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
public class NoticeVO {

	private int ntc_num;
	private int ntc_mem_num;
	private String ntc_category;
	private String ntc_title;
	private String ntc_writer;
	private String ntc_content;
	private String ntc_regdate;
	private int ntc_views;
}
