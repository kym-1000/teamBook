package com.ezen.book.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.book.domain.CartVO;
import com.ezen.book.domain.MemberVO;
import com.ezen.book.domain.OrderDTO;
import com.ezen.book.domain.OrderPageItemDTO;
import com.ezen.book.domain.CntDTO;
import com.ezen.book.domain.FileVO;
import com.ezen.book.domain.BookVO;
import com.ezen.book.domain.CartDTO;
import com.ezen.book.service.CartService;
import com.ezen.book.service.MemberService;
import com.ezen.book.service.OrderService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequestMapping("/cart/*")
@Controller
public class CartController {
   
   @Inject
   private CartService casv;
   
   
   @Inject
   private MemberService mesv;
   
   @Inject
   private OrderService orsv;
   
   // 장바구니에 물건을 추가 
   @PutMapping(value = "/cartadd", consumes = "application/json",produces = {MediaType.APPLICATION_JSON_VALUE}) 
   public ResponseEntity<String> Cartadd(Model model,@RequestBody CntDTO cdto ,RedirectAttributes ra) {
      int isUp;
      int isUPUP = 0;
      MemberVO mvo = casv.getDetailmember(cdto.mem_num); // 해당 멤버를 가져온다!
      BookVO bvo = casv.getCartBook(cdto.book_num); // 장바구니 버튼을 누르면 해당 상품만 가져온다
      
      log.info(bvo.toString());
      
      CartDTO cdo = new CartDTO();
            
      cdo.setMem_num(mvo.getMem_num());
      cdo.setBook_title(bvo.getBook_title());
      cdo.setBook_writer(bvo.getBook_writer());
      cdo.setBook_amount(cdto.book_cnt);
      cdo.setBook_price(bvo.getBook_price());
      cdo.setBookId(cdto.book_num);
      
      CartVO cvo = casv.getCart(cdo);   //  mn에 해당하는 카트를 가져옴
      
      
      if(cvo == null) {      // 장바구니가 비었을경우!
         isUp = casv.addCart(cdo);   // 가져온 객체를 장바구니에 넣어준다! 
         isUPUP = mesv.memberCartNumUP(cdto.mem_num);
      }else {
         isUp = casv.updateCart(cdo);   // 회원번호가 같고 책 이름이 같은 경우 기존 장바구니 수량을 더한다!
//         isUPUP = mesv.memberCartNumUP(mem_num);
      }
      
      //  sql 성공유무
      
      if(isUPUP > 0) {
         log.info("카트에 장바구니 숫자 올리기 성공!");
      }else {
         log.info("카트에 장바구니 숫자 올리기 실패!");
      }
      
      if(isUp > 0) {               
         log.info("카트담기 성공!");
      }else {
         log.info("카트담기 실패!");
      }
      
      ra.addAttribute("book_num", cdto.book_num);
      
      /* return "redirect:/book/bkDetailView"; */
      
      return isUp > 0 ? new ResponseEntity<String>("1",HttpStatus.OK)
            : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            
   }
   
   // 바로구매
   @PutMapping(value = "/directCartadd", consumes = "application/json",produces = {MediaType.APPLICATION_JSON_VALUE}) 
   public ResponseEntity<String> directCartadd(Model model,@RequestBody CntDTO cdto ,RedirectAttributes ra) {
      
      int isUp;
      int isUPUP = 0;
      MemberVO mvo = casv.getDetailmember(cdto.mem_num); // 해당 멤버를 가져온다!
      BookVO bvo = casv.getCartBook(cdto.book_num); // 장바구니 버튼을 누르면 해당 상품만 가져온다
      
      log.info(bvo.toString());
      
      CartDTO cdo = new CartDTO();
      
      cdo.setMem_num(mvo.getMem_num());
      cdo.setBook_title(bvo.getBook_title());
      cdo.setBook_writer(bvo.getBook_writer());
      cdo.setBook_amount(cdto.book_cnt);
      cdo.setBook_price(bvo.getBook_price());
      cdo.setBookId(cdto.book_num);
      
      CartVO cvo = casv.getCart(cdo);   //  mn에 해당하는 카트를 가져옴
            
      if(cvo == null) {      // 장바구니가 비었을경우!
         isUp = casv.addCart(cdo);   // 가져온 객체를 장바구니에 넣어준다! 
         isUPUP = mesv.memberCartNumUP(cdto.mem_num);
      }else {
         isUp = casv.updateCart(cdo);   // 회원번호가 같고 책 이름이 같은 경우 기존 장바구니 수량을 더한다!
      }
      
      //  sql 성공유무
      
      if(isUPUP > 0) {
         log.info("카트에 장바구니 숫자 올리기 성공!");
      }else {
         log.info("카트에 장바구니 숫자 올리기 실패!");
      }
      
      if(isUp > 0) {               
         log.info("카트담기 성공!");
      }else {
         log.info("카트담기 실패!");
      }
      
      ra.addAttribute("mem_num", cdto.mem_num);
//      return "redirect:/cart/cartdetail";
      
      return isUp > 0 ? new ResponseEntity<String>("1",HttpStatus.OK)
            : new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            
   }
   
   
   // 장바구니로 가는 메서드
   @GetMapping("/cartdetail")
   public String Cart(Model model,@RequestParam("mem_num") int mem_num) {
   List<CartVO> Clist = casv.getCartList(mem_num); // 전체 장바구니 목록을 가져온다! mn넣어서 해당하는것만 가져와!
   
   for(int i = 0; i<Clist.size();i++) {
      
      List<FileVO> imageList = orsv.selectFileList(Clist.get(i).getCart_book_num());
      
      Clist.get(i).setImageList(imageList);    // 이미지 임시로 넣기
      
      log.info("이미지리스트이다"+imageList.toString());
      
   } 
   
   MemberVO mvo = casv.getDetailmember(mem_num);
   
   // 로그인을 하고 장바구니를 추가하면 회원정보에 장바구니 갯수가 늘어남 0이면 장바구니가 비었다는 의미 
   model.addAttribute("mvo", mvo);
   model.addAttribute("Clist",Clist);
   model.addAttribute("msg",1);          
   return "/cart/cartMycart";
   }
   
   // 장바구니에서 카트 삭제 
   @PostMapping("/cart/delete")
   public String deleteCart(RedirectAttributes ra, @RequestParam("cartnum")int cartnum,@RequestParam("mem_num")int mem_num) {
      log.info(""+cartnum);
      log.info(""+mem_num);
      
      int isUp = mesv.memberCartNumDown(mem_num);  // 장바구니에서 삭제되면 회원정보에 장바구니 num 가 -1 된다 0이 되면 장바구니 숫자0
      
      if(isUp > 0 ) {
         log.info("회원 장바구니 숫자 수정완료");
      }else {
         log.info("회원 장바구니 숫자 수정실패");
      }
      
      casv.deleteSelectCart(cartnum);
      log.info("삭제완료");
      ra.addAttribute("mem_num", mem_num);
      return "redirect:/cart/cartdetail";
      
   }
   
   
   // 장바구니에서 수량 수정 
   @PostMapping("/cart/update")
   public String updateCartPOST(RedirectAttributes ra, @RequestParam("cartnum")int cartnum,@RequestParam("cart_amount")int cart_amount,@RequestParam("mem_num")int mem_num) {
      log.info("카트넘버"+cartnum);
      log.info("수량"+cart_amount);
      
      CartDTO cdto = new CartDTO();
      
      cdto.setCartId(cartnum);
      cdto.setBook_amount(cart_amount);
      
      log.info("Book_amount "+cdto.getBook_amount());
      log.info("CartId "+cdto.getCartId());
      
      int isUp = casv.modifyCount(cdto);
      
      if(isUp > 0 ) {
         log.info("수량 수정완료");
      }else {
         log.info("수량 수정실패");
      }
      
      ra.addAttribute("mem_num", mem_num);
      return "redirect:/cart/cartdetail";
      
   }   
   
   
   
   

   
   
   
}