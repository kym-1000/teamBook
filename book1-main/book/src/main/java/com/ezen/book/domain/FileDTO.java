package com.ezen.book.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class FileDTO {
	private BookVO bvo;
	private String save_dir;
	private String uuid;
	private String file_name;
}
