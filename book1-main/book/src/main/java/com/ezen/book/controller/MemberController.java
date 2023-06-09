package com.ezen.book.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.book.domain.DeliveryDTO;
import com.ezen.book.domain.FileVO;
import com.ezen.book.domain.MemberVO;
import com.ezen.book.domain.OrderItemDTO;
import com.ezen.book.domain.OrderVO;
import com.ezen.book.domain.PagingVO;
import com.ezen.book.handler.PagingHandler;
import com.ezen.book.service.MemberService;
import com.ezen.book.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/mem/*")
@Controller
public class MemberController {

   @Inject
   private MemberService msv;
   @Inject
   private OrderService osv;

   @GetMapping("adminPage")
   public String adminPage() {
      return "/member/memberAdmin";
   }

   @GetMapping({ "loginPage", "login-member" })
   public String loginPage() {
      return "/member/memberLogin";
   }

   @GetMapping("login-Non-member")
   public String loginNonPage() {
      return "/member/memberLoginNon";
   }

   @GetMapping("joinPage")
   public String joinPage() {
      return "/member/memberJoin";
   }

   @PostMapping("idCheck") // 회원가입시 id가 null,중복 확인 메서드
   @ResponseBody // 자바 객체를 HTTP 응답 본문의 객체로 변환. 안써주면 ajax가 값을 못받음
   public String idCheck(MemberVO mvo) {
      String isOk = msv.idCheck(mvo.getMem_id());
      return isOk;
   }

   @PostMapping("pwCheck") // 회원가입시 pw가 null,정규화부합 확인 메서드
   @ResponseBody
   public String pwCheck(MemberVO mvo) {
      log.info("컨트롤러 pw 체크 : " + mvo.getMem_pw());
      String isOk = msv.pwCheck(mvo.getMem_pw());
      mvo.setMem_pw(mvo.getMem_pw());
      log.info("pwCheck : " + mvo.getMem_pw());
      return isOk;
   }

   @PostMapping("pwCheckRe") // 회원가입시 pw 재확인 메서드
   @ResponseBody
   public String pwCheckRe(@RequestParam("mem_pwRe") String mem_pwRe) {
      // @RequestParam(value="mem_pw", required=false)String mem_pw,
      // log.info("mem_pw : "+mem_pw);
      log.info("mem_pwRe : " + mem_pwRe);
      String isOk = msv.pwCheckRe(mem_pwRe);
      log.info("비번 체크 Re isok : " + isOk);
      return isOk;
   }

   @PostMapping("cellNumCheck") // 회원가입시 핸드폰번호 중복 확인 메서드
   @ResponseBody
   public String cellNumCheck(MemberVO mvo) {
      String isOk = msv.cellNumCheck(mvo.getMem_cell_num());
      log.info(mvo.getMem_cell_num());
      log.info("폰번호 체크 isok : " + isOk);
      return isOk;
   }

   @PostMapping("/join")
   public String join(MemberVO mvo, RedirectAttributes reAttr, HttpServletRequest req) {
      String isOk = msv.join(mvo);
      if (isOk.equals("join_Fail")) { // fail이면 회원가입페이지로 다시
         return "redirect:/mem/joinPage";
      }
      log.info("우편번호 " + mvo.getMem_postzip());
      // 마지막에 가입한 아이디의 주소 업데이트 하기
      String address = req.getParameter("address");
      String detailAddress = req.getParameter("detailAddress");
      String extraAddress = req.getParameter("extraAddress");

      String mem_ad = address + "/" + detailAddress + "/" + extraAddress;

      log.info("addressAll : " + mem_ad);
      int isOk2 = msv.update(mem_ad);
      log.info(isOk2 > 0 ? "주소 업데이트 성공" : "주소 업데이트 실패");
      log.info(">>> member join 성공");
      return "redirect:/";
   }

   @PostMapping("/login")
   public String login(MemberVO mvo, RedirectAttributes reAttr, HttpServletRequest req) {
      MemberVO mvo2 = msv.login(mvo.getMem_id(), mvo.getMem_pw());
      
    
      
      log.info("login getMem_id : " + mvo.getMem_id());
      log.info("login getMem_pw : " + mvo.getMem_pw());
      if (mvo2 != null){
         HttpSession ses = req.getSession();
         ses.setAttribute("ses", mvo2);
         ses.setMaxInactiveInterval(60 * 10);
         return "redirect:/";
      }else{  	  
         reAttr.addFlashAttribute("msg", "0");
         return "/member/memberLoginRe";
      }

     
       
   }

   @GetMapping("/logOut")
   public String logout(Model model, HttpServletRequest req, RedirectAttributes reAttr) {
      req.getSession().removeAttribute("ses");
      req.getSession().invalidate();

      return "redirect:/";

   }

   @GetMapping("/join-ts")
   public String joinTs() {
      return "/member/memberJoinTs";
   }

   @GetMapping("/MemIdSearch")
   public String MemIdSearch() {
      return "/member/memberIdSearch";
   }

   @GetMapping("/MemPwSearch")
   public String MemPwSearch() {
      return "/member/memberPwSearch";
   }

   @PostMapping("/MemIdSearch")
   public String MemIdSearch(MemberVO mvo, Model model, RedirectAttributes reAttr) {
      log.info("mvo.getMem_name : " + mvo.getMem_name());
      log.info("mvo.getMem_cell_num : " + mvo.getMem_cell_num());
      String id = msv.getId(mvo);
      log.info(id);
      if (id != null) {
         model.addAttribute("msg", id);
      } else {
         model.addAttribute("msg", "0");
      }
      return "/member/memberIdSearchRe";
   }

   @PostMapping("/MemPwSearch")
   public String MemPwSearch(MemberVO mvo, Model model, RedirectAttributes reAttr) {
      log.info("mvo.getMem_id : " + mvo.getMem_id());
      log.info("mvo.getMem_name : " + mvo.getMem_name());
      log.info("mvo.getMem_cell_num : " + mvo.getMem_cell_num());

      String pw = msv.getPw(mvo);

      if (pw != null) {
         // id,name,cellNum이 맞으면 새 비밀번호 입력 요청 페이지로 이동
         // id도 같이 보내기
         model.addAttribute("mvo", mvo);
         log.info("newpw페이지 이동 전 아이디 넘어가는지 확인 : " + mvo.getMem_id());
         return "/member/memberNewPw";
      } else {
			 model.addAttribute("msg", "0"); 
         return "/member/memberPwSearchRe";
      }
   }

   @PostMapping("/newPwUpdate")
   public String memNewPw(MemberVO mvo, HttpServletRequest req) {
      String mem_id = req.getParameter("mem_id");
      String mem_pw = req.getParameter("mem_pw");
      String mem_pwRe = req.getParameter("mem_pwRe");

      if (mem_pw.equals(mem_pwRe)) {
         int isOk = msv.newPwUpdate(mvo);
      }
      return "redirect:/";
   }

   @GetMapping("/mypage")
   public String mypage(Model model) {
      model.addAttribute("content", "main");
      return "/member/memberMypage";
   }

   @GetMapping("/modify")
   public String modify(Model model) {
      model.addAttribute("content", "main");
      return "/member/memberMypage";
   }

   @PostMapping("/modify")
   public String modifyPost(MemberVO mvo, Model model, HttpServletRequest req) {
      log.info("modify>>>" + mvo.toString());
      int isUp = msv.usermodify(mvo);
      String address = req.getParameter("address");
      String detailAddress = req.getParameter("detailAddress");
      String extraAddress = req.getParameter("extraAddress");

      String mem_ad = address + "/" + detailAddress + "/" + extraAddress;

      log.info("addressAll : " + mem_ad);
      int isOk2 = msv.update(mem_ad);
      log.info(">>>modify:" + (isOk2 > 0 ? "ok" : "fail"));
      req.getSession().removeAttribute("ses");
      req.getSession().invalidate();
      return "redirect:/";
   }

   @GetMapping("/orderCheck")
   public String orderList(Model model, PagingVO pvo, @RequestParam("mem_num") int mem_num) {
      log.info(">>>pageNo :" + pvo.getPageNo());
      log.info(">>>num :" + mem_num);
      
      Date date = new Date();
      SimpleDateFormat format1 = new SimpleDateFormat("yy-MM-dd");
      
      DeliveryDTO ddto = new DeliveryDTO();
      
      ddto.setOrder_date(format1.format(date));
      ddto.setMem_num(mem_num);
      
      osv.setDelivery(ddto);
      
      String status = "주문";
      List<OrderVO> list = osv.getList(pvo, status, mem_num);
      model.addAttribute("list", list);
      int totalCount = osv.getOrderTotalCount(mem_num);
      PagingHandler ph = new PagingHandler(pvo, totalCount);
      model.addAttribute("pgh", ph);
      model.addAttribute("content", "orderList");
      return "/member/memberMypage";
   }

   @GetMapping("/buyCheck")
   public String buyList(Model model, PagingVO pvo, @RequestParam("mem_num") int mem_num) {
      log.info(">>>pageNo :" + pvo.getPageNo());
      String status = "구매";
      List<OrderVO> list = osv.getList(pvo, status, mem_num);

      model.addAttribute("list", list);
      int totalCount = osv.getBuyTotalCount(mem_num);

      PagingHandler ph = new PagingHandler(pvo, totalCount);
      model.addAttribute("pgh", ph);
      model.addAttribute("content", "buyList");
      return "/member/memberMypage";
   }

   @GetMapping("/delete")
   public String getDelte(Model model) {
      model.addAttribute("content", "delete");
      return "/member/memberMypage";
   }

   @PostMapping("/delete")
   public String MemberDelete(Model model, HttpServletRequest req, RedirectAttributes reAttr,
         @RequestParam("mem_num") int mem_num) {
      log.info("mem_num" + mem_num);
      int deleteOk = msv.deleteMember(mem_num);
      req.getSession().removeAttribute("ses");
      req.getSession().invalidate();
      return "/home";
      
   }

   @GetMapping("/charge")
   public String boardRegisterGet(Model model) {
      model.addAttribute("content", "charge");
      return "/member/memberMypage";
   }

   /*
    * @PostMapping("/charge") public String moneyCharge(MemberVO mvo,
    * HttpServletRequest req) { log.info(mvo.toString()); int isOk =
    * msv.moneyCharge(mvo); log.info(">>>charge:" + (isOk > 0 ? "ok" : "fail"));
    * req.getSession().removeAttribute("ses"); req.getSession().invalidate();
    * return "redirect:/"; }
    */
   
   
   @PostMapping("/charge2")
   @ResponseBody
   public String moneyCharge(Model model,MemberVO mvo,HttpServletRequest req,
         @RequestParam(value="mem_id", required=false) String mem_id,@RequestParam("mem_cash") int mem_cash) {
      //log.info("charge mvo 출력 : "+mvo.toString());
      log.info("js넘어온 mem_id : "+mem_id);
      log.info("js넘어온 mem_sum : "+mem_cash);
      int isOk = msv.moneyCharge(mem_id,mem_cash);
      log.info("컨트롤러 charge2 sum값 : "+isOk);
      
      int cashNow = msv.getCharge(mem_id);
      String cashNow2 =String.valueOf(cashNow);
      log.info("sum 컨트롤러 : "+cashNow);
      //log.info(">>>charge:" + (isOk > 0 ? "ok" : "fail"));
      
      MemberVO mvo2 = msv.getIdAll(mvo.getMem_id());
      HttpSession ses = req.getSession();
      ses.setAttribute("ses", mvo2);
      /*
       * req.getSession().removeAttribute("ses"); req.getSession().invalidate();
       */
       
      return cashNow2;
   }
   
   @GetMapping("/orderListDetail")
   public String orderListDetail(Model model, @RequestParam("order_num") String order_num) {
      log.info(">>>num :" + order_num);
      List<OrderItemDTO> Olist = osv.orderDetail(order_num);
      
      
      for(int i = 0; i<Olist.size();i++) {
          
          List<FileVO> imageList = osv.selectFileList(Olist.get(i).getBook_num());
          
          Olist.get(i).setImageList(imageList);    // 이미지 임시로 넣기
          
          log.info("이미지리스트이다"+imageList.toString());
          
       } 
      
      
      model.addAttribute("list", Olist);
      model.addAttribute("content", "orderDetail");
      return "/member/memberMypage";
   }

}