package com.ezen.book.service;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ezen.book.domain.MemberVO;
import com.ezen.book.domain.NonMemberVO;
import com.ezen.book.repository.NonMemberDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NonMemberServiceImpl implements NonMemberService {

	@Inject
	private NonMemberDAO nmDAO;
	
	@Inject
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public NonMemberVO login(NonMemberVO umvo) {
		NonMemberVO unmember = nmDAO.getNum(umvo);
		if (unmember == null) {
			return null;
		} else {
			return unmember;
		}
	}
		/* ★★ 지우지말기 ★ 입력한 비번과 주문시 주문비밀번호 암호화 비교하고 로그인해야함
		 * //암호화된 비밀번호 맞는지 비교 if (passwordEncoder.matches(umvo.getMem_pw(),
		 * unmember.getMem_pw())) { return unmember; } else {
		 * 
		 * return null; }
		 */

	@Override
	public int searchNum(NonMemberVO umvo) {

		int mem_num = nmDAO.searchNum(umvo);
		if (mem_num > 0) {
			return mem_num;
		} else {

			return 0;
		}
	}
//	@Override
//	public int searchPw(UnmemberVO umvo) {
//
//		int mem_num = nmDAO.searchNum(umvo);
//		if (mem_num > 0) {
//			return mem_num;
//		} else {
//
//			return 0;
//		}
//	}
}
