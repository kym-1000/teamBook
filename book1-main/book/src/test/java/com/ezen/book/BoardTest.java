package com.ezen.book;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ezen.book.domain.MemberVO;
import com.ezen.book.repository.MemberDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardTest {

	@Inject
	private MemberDAO mdao;
	
	@Test
	public void insertMember() {
		MemberVO mvo =  new MemberVO();
		log.info("insert test!!");
		mvo.setMem_id("test Title");
		mvo.setMem_pw("Test Content");
		mvo.setMem_cell_num("test writer");
		
		int isOk = mdao.insertMember(mvo);
		log.info("insert test : "+(isOk>0?"ok":"fail"));
	}
	
	@Test
	public void selectMemberTest() {
		MemberVO mvo =  new MemberVO();
		
		mvo= mdao.getMember("tomato");
		
	
		log.info("insert test : "+mvo.toString());
	}
}
