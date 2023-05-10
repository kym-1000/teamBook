package com.ezen.book.domain;

import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CntDTO {
		
	 public int mem_num;
	 public int book_num;
	 public int book_cnt;
}
