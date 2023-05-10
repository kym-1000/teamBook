package com.ezen.book.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.book.domain.CartVO;
import com.ezen.book.domain.MemberVO;
import com.ezen.book.domain.OrderDTO;
import com.ezen.book.domain.OrderItemDTO;
import com.ezen.book.domain.OrderPageDTO;
import com.ezen.book.domain.OrderVO;
import com.ezen.book.domain.PagingVO;
import com.ezen.book.handler.PagingHandler;
import com.ezen.book.service.CartService;
import com.ezen.book.service.MemberService;
import com.ezen.book.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/order/*")
@Controller
public class OrderController {
   
   @Autowired
   private OrderService odsv;
   
   @Autowired
   private MemberService memberService;
   
   @GetMapping("/order1/{mem_num}")
   public String order(Model model,OrderPageDTO opd,@PathVariable("mem_num") int mem_num) {
      System.out.println(mem_num);
      System.out.println(opd.getOrders());
      
      model.addAttribute("orderList", odsv.getGoodsInfo(opd.getOrders()));
      model.addAttribute("member", memberService.getMemberInfo(mem_num));
      model.addAttribute("msg", 3);
      
      return "/cart/cartOrder";
      
   }
   
   @PostMapping("/ordercheck")
   public String orderPagePost(OrderDTO od ,RedirectAttributes ra,Model model,HttpServletRequest req) {
      
      System.out.println(od);      
      
      odsv.order(od);  // 주문 로직
      
      /* MemberVO member = new MemberVO(); */
      
      int mem_num = od.getOrder_mem_num();
      
//      System.out.println(mem_num);   
//      ra.addAttribute("mem_num", mem_num);
   
      MemberVO mvo=memberService.getmvo(mem_num);
      
      model.addAttribute("content", "main");
      
      HttpSession ses = req.getSession();
      
      ses.setAttribute("ses", mvo);
      
      return "/member/memberMypage";
   }   
   
   
   @RequestMapping("/Completion")
   public String orderPage(Model model, @RequestParam int mem_num) {
      
      List<OrderDTO> Plist = odsv.getOrderList(mem_num);
      
      model.addAttribute("Plist", Plist);
      
      return "/cart/CartCompletion";
      
   }
   
   
   @GetMapping("/Detail")
   public String orderDetail(Model model,@RequestParam("order_num")String order_num) {
      
      List<OrderItemDTO> Plist = odsv.orderDetail(order_num);
      
//      if(isUp > 0) {
//         log.info("구매 상세페이지 불러오기 성공");
//      }else {
//         log.info("구매 상세페이지 불러오기 실패");
//      }
      
      model.addAttribute("orderDetail", Plist);
      
      
      return "/cart/CartCompletionDetail";
   }
   
   
   @GetMapping("/Confirmed")
   public String Confirmed(Model model,@RequestParam("order_num")String order_num,@RequestParam("order_mem_num")int order_mem_num,RedirectAttributes ra) {
      
      odsv.Confirmed(order_num);
      
      ra.addAttribute("mem_num", order_mem_num);
      return "redirect:/mem/orderCheck";
      
   }
   
   
   
}