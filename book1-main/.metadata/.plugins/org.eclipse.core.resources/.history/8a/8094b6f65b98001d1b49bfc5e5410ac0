<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>         
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome BookMall</title>
<link rel="stylesheet" href="/resources/css/order.css">
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
  <!-- 다음주소 -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> 
<style type="text/css">
   @charset "UTF-8";
*{
   margin: 0;
   padding:0;
}
a{
   text-decoration: none;
}
/* 화면 전체 렙 */
.wrapper{
   width: 100%;
}
/* content 랩 */
.wrap{
   width : 1080px;
   margin: auto;
}


/* 홈페이지 메인 제품 목록  */
.content_area{
   width: 100%;
    min-height: 1000px;
}
    table{
       border-collapse: collapse;
       width: 100%;
    }
    .table_text_align_center{
            text-align: center;
    }   
    caption{
       visibility: hidden;
       width: 0;
       height: 0;
       font-size: 0;
       line-height: 0;
       overflow: hidden; 
    }     

    .content_subject{
      height: 110px;
       line-height: 110px;
       background-color: #5080bd;
       margin-bottom: 60px; 
    
    }
       .content_subject span{ 
          padding-left: 30 px;
          display: inline-block;
          color: white;
          font-size: 50px;
          font-weight: bolder; 
       }
    
/* content_main */
 .content_main{
    min-height: 700px;
    padding-right: 350px;
    position: relative;
 }
 table{
    border-collapse: collapse;
 }
 
 /* 사용자 정보  */
 .memberInfo_table{
    width: 100%;
    border-spacing: 0;
    border-top: 2px solid #363636;
    border-bottom: 1px solid #b6b6b6; 
 }
 .member_info_div td{
    padding : 12px;
    text-align: left;
 }

/* 주문상품 정보 */
.orderGoods_div{
   margin-top:30px;
}
.goods_kind_div{
   font-size: 25px;
    line-height: 35px;
    font-weight: bold;
}
.goods_subject_table{
   font-size: 14px;
    line-height: 20px;
    width: 100%;
    text-align: center; 
}
.goods_subject_table th{
   text-align: center;
    color: #333;
    border-bottom: 1px solid #e7e7e7;
    border-top: 2px solid #3084d9;
    background: #f4f9fd;
    padding: 2px 0;    
}
.goods_table{
   font-size: 14px;
   line-height: 20px;
   border-bottom: 1px solid #e7e7e7;
}

.goods_table tr{
height: 110px;
}
.goods_table_price_td{
   text-align: center;
}


/* 포인트 영역 */
.point_div{
   margin-top: 30px;
   margin-bottom: 50px;   
}
.point_div_subject{
   font-size: 25px;
    line-height: 35px;
    font-weight: bold;
}
.point_table{
   border-color: #ddd;
    border-spacing: 0;
    border-top: 1px solid #363636;
    border-bottom: 1px solid #b6b6b6;
}
.point_table th{
   border-color: #ddd;
    vertical-align: top;
    text-align: center;
    color: #333333;
    background: #fbfbfb;
    text-indent: 0;
    padding: 12px 5px 12px 20px;
    font-size: 15px;
    line-height: 20px;
}
.point_table_td{
   border-color: #ddd;
    text-align: left;
    color: #333333;
    padding: 8px 15px;
}
.order_point_input_btn{
   vertical-align: middle;
    display: inline-block;
    border: 1px solid #aaa;
    width: 60px;
    text-align: center;
    height: 20px;
    line-height: 20px;
    color: #555;
    cursor: pointer;
    font-size: 12px;
}

/* 주문 종합 정보 */
.total_info_div{
   position:absolute;
   top: 0;
   right : 0;
   width : 300px;
   border : 1px solid #333;
   border-top-width:2px;   
   
}
.total_info_price_div{
   width: 90%;
    margin: auto;
   position: relative;
}
.total_info_div ul{
   list-style: none;
}
.total_info_div li{
   text-align: right;
   margin-top:10px;
}
.price_span_label{
   float: left;
}
.price_total_li{
   border-top: 1px solid #ddd;
   padding-top: 20px;
}
.strong_red{
   color: red;
}
.total_price_red{
   font-size: 25px;
}
.total_price_label{
   margin-top: 5px;
}
.point_li{
    padding: 15px;
    border-top: 1px solid #ddd;
    margin: 10px -15px 0;
}
.total_info_btn_div{
   border-top: 1px solid #ddd;
    text-align: center;
    padding: 15px 20px;
}
.order_btn{
    display: inline-block;
    font-size: 21px;
    line-height: 50px;
    width: 200px;
    height: 50px;
    background-color: #f7f2a6;
    color: white;
    font-weight: bold;
}



/* float 속성 해제 */
.clearfix{
   clear: both;
}


</style>
</head>
<body>

   <jsp:include page="../layout/header.jsp"></jsp:include>

<div class="wrapper">
   <div class="wrap">

      <div class="content_area">
         
         
         <jsp:include page="../cart/cartHeader.jsp"></jsp:include>
         <div class="content_main">
            <!-- 회원 정보 -->
            <div class="member_info_div">
               <table class="table_text_align_center memberInfo_table">
                  <tbody>
                     <tr>
                        <th style="width: 25%;">주문자</th>
                        <td style="width: *">${memberInfo.mem_name} | ${memberInfo.mem_id}</td>
                     </tr>
                  </tbody>
               </table>
            </div>            
            
            <!-- 배송지 정보 -->
            <div class="addressInfo_div">
               
               <div class="addressInfo_input_div_wrap">
                  <div class="addressInfo_input_div addressInfo_input_div_1" style="display: block">
                     <table>
                        <colgroup>
                           <col width="25%">
                           <col width="*">
                        </colgroup>
                        <tbody>
                           <tr>
                              <th>이름</th>
                              <td>
                                 ${memberInfo.mem_name}
                              </td>
                           </tr>
                           <tr>
                              <th>주소</th>
                              <td>
                                 ${memberInfo.mem_ad} 
                                 <input class="selectAddress" value="T" type="hidden">
                                 <input class="addressee_input" value="${memberInfo.mem_name}" type="hidden">
                                 <input class="address1_input" type="hidden" value="${memberInfo.mem_ad}">
                        <%--          <input class="address2_input" type="hidden" value="${memberInfo.memberAddr2}">
                                 <input class="address3_input" type="hidden" value="${memberInfo.memberAddr3}">    --%>                                                            
                              </td>
                           </tr>
                        </tbody>
                     </table>
                  </div>
            
               </div>
            </div>            
            <!-- 상품 정보 -->
            <div class="orderGoods_div">
               <!-- 상품 종류 -->
               <div class="goods_kind_div">
                  주문상품 <span class="goods_kind_div_kind"></span>종 <span class="goods_kind_div_count"></span>권
               </div>
               <!-- 상품 테이블 -->
               <table class="goods_subject_table">
                  <colgroup>
                     <col width="15%">
                     <col width="45%">
                     <col width="40%">
                  </colgroup>
                  <tbody>
                     <tr>
                        <th>이미지</th>
                        <th>상품 정보</th>
                        <th>판매가</th>
                     </tr>
                  </tbody>
               </table>
               <table class="goods_table">
                  <colgroup>
                     <col width="15%">
                     <col width="45%">
                     <col width="40%">
                  </colgroup>               
                  <tbody>
                     <c:forEach items="${orderList}" var="cvo">
                        <tr>
                           <td>
                           <div class="img_box">
                              <a href="/book/bkDetailView?book_num=${cvo.cart_book_num}"> 
                                 <img class="book_img" src="/upload/${fn:replace(cvo.imageList[0].save_dir,'\\','/')}/${cvo.imageList[0].uuid}_${cvo.imageList[0].file_name}" style="width: 50px; height: 50px" alt="bookThumbnail">
                              </a>
                           </div>
                           </td>
                           <td>${cvo.book_title}${cvo.cart_book_num}</td>
                           <td class="goods_table_price_td">
                              <fmt:formatNumber value="${cvo.salePrice}" pattern="#,### 원" /> | 수량 ${cvo.bookCount}권
                              <br><fmt:formatNumber value="${cvo.salePrice * cvo.bookCount}" pattern="#,### 원" />
                              <input type="hidden" class="individual_salePrice_input" value="${cvo.salePrice}">
                              <input type="hidden" class="individual_bookPrice_input" value="${cvo.book_price}">
                              
                           <input type="hidden" class="individual_book_name_input" value="${cvo.book_title}">
                           <input type="hidden" class="individual_bookCount_input" value="${cvo.bookCount}">
                           <input type="hidden" class="individual_totalPrice_input" value="${cvo.salePrice * cvo.bookCount}">
                           <input type="hidden" class="individual_point_input" value="${cvo.point}">
                           <input type="hidden" class="individual_totalPoint_input" value="${cvo.totalPoint}">
                           <input type="hidden" class="individual_book_num_input" value="${cvo.cart_book_num}">    
                           </td>
                        </tr>                     
                     </c:forEach>

                  </tbody>
               </table>
            </div>      
                  
            <!-- 포인트 정보 -->
            <div class="point_div">
               <div class="point_div_subject">포인트 사용</div>
               <table class="point_table">
                  <colgroup>
                     <col width="25%">
                     <col width="*">
                  </colgroup>
                  <tbody>
                     <tr>
                        <th>포인트 사용</th>
                        <td>
                           ${memberInfo.mem_point} | <input class="order_point_input" value="0">포인트
                           <a class="order_point_input_btn order_point_input_btn_N" data-state="N">모두사용</a>
                           <a class="order_point_input_btn order_point_input_btn_Y" data-state="Y" style="display: none;">사용취소</a>
                           
                        </td>
                     </tr>
                  </tbody>
               </table>
            </div>            
            <!-- 주문 종합 정보 -->
            <div class="total_info_div">
               <!-- 가격 종합 정보 -->
               <div class="total_info_price_div">
                  <ul>
                     <li>
                        <span class="price_span_label">지갑</span>
                        <span class="mem_cash">${memberInfo.mem_cash}</span>원
                     </li>
                     <li>
                        <span class="price_span_label">상품 금액</span>
                        <span class="totalPrice_span">100000</span>원
                     </li>
                     <li>
                        <span class="price_span_label">배송비</span>
                        <span class="delivery_price_span">100000</span>원
                     </li>
                                                               <li>
                        <span class="price_span_label">할인금액</span>
                        <span class="usePoint_span">100000</span>원
                     </li>
                     <li class="price_total_li">
                        <strong class="price_span_label total_price_label">최종 결제 금액</strong>
                        <strong class="strong_red">
                           <span class="total_price_red finalTotalPrice_span" id="finalTotalPrice">
                              1500000
                           </span>원
                        </strong>
                     </li>
                      
                     <!-- A등급 20퍼센트 B등급 15퍼센트 C등급 10퍼센트 D(기본)5퍼센트 -->
                     <li class="point_li">
                        <c:if test="${memberInfo.mem_rating eq 'A'}">
                        <span class="price_span_label">적립포인트(등급A)</span>
                        <span class="totalPoint_span">7960원</span>(+
                        <span class="addPointA"></span>)
                        </c:if>
                        <c:if test="${memberInfo.mem_rating eq 'B'}">
                        <span class="price_span_label">적립포인트(등급B)</span>
                        <span class="totalPoint_span">7960원</span>(+
                        <span class="addPointB"></span>)
                        </c:if> 
                        <c:if test="${memberInfo.mem_rating eq 'C'}">
                        <span class="price_span_label">적립포인트(등급C)</span>
                        <span class="totalPoint_span">7960원</span>(+
                        <span class="addPointC"></span>)
                        </c:if>
                        <c:if test="${memberInfo.mem_rating eq 'D'}">
                        <span class="price_span_label">적립포인트(등급D)</span>
                        <span class="totalPoint_span">7960원</span>
                        </c:if>
                     </li>
                  </ul>
               </div>
               <!-- 버튼 영역 -->
               <div class="total_info_btn_div">
                  <a class="order_btn">결제하기</a>
               </div>
            </div>            
            
         </div>         

         <!-- 주문 요청 form -->
         <form class="order_form" action="/order/ordercheck" method="post">  <!-- 이쪽으로 간다  -->
            <!-- 주문자 회원번호 -->
            <input name="order_mem_num" value="${memberInfo.mem_num}" type="hidden">
            <!-- 주소록 & 받는이-->
            <input name="addressee" type="hidden">
            <input name="memberAddr1" type="hidden">
            <input name="order_add2" type="hidden" value="${memberInfo.mem_ad}">
            <!-- 사용 포인트 -->
            <input name="usePoint" type="hidden">
            <!-- 상품 정보 -->
         </form>
         
      </div>
      
   
      
   </div>   <!-- class="wrap" -->
</div>   <!-- class="wrapper" -->

<jsp:include page="../layout/footer.jsp"></jsp:include>

<script>

$(document).ready(function(){
   
   
   setTotalInfo();
   
   let finalTotalPrice;
   
});


function setTotalInfo(){

   let totalPrice = 0;            // 총 가격
   let totalCount = 0;            // 총 갯수
   let totalKind = 0;            // 총 종류
   let totalPoint = 0;            // 총 마일리지
   let deliveryPrice = 0;         // 배송비
   let usePoint = 0;            // 사용 포인트(할인가격)
   finalTotalPrice = 0;       // 최종 가격(총 가격 + 배송비)
   let memberRank = "";         // 멤버 랭크
   let AmemberRanK = 0;
   let BmemberRanK = 0;
   let CmemberRanK = 0;
   
   $(".goods_table_price_td").each(function(index, element){
      
      totalPrice += parseInt($(element).find(".individual_totalPrice_input").val());
      
      totalCount += parseInt($(element).find(".individual_bookCount_input").val());
      
      totalKind += 1;
      
      totalPoint += parseInt($(element).find(".individual_totalPoint_input").val());
   });   
   
   memberRank = '${memberInfo.mem_rating}';
   
   
   console.log(memberRank);
   
   <!-- A등급 20퍼센트 B등급 15퍼센트 C등급 10퍼센트 D(기본)5퍼센트 -->
   
   if(memberRank == "A"){         
      AmemberRanK = totalPoint*3;  
      totalPoint = totalPoint*4;    
   }else if(memberRank == "B"){      
      BmemberRanK = totalPoint*2;                  
      totalPoint = totalPoint*3;                  
   }else if(memberRank == "C"){
      CmemberRanK = totalPoint;                  
      totalPoint = totalPoint*2;                  
   }

   if(totalPrice >= 30000){
      deliveryPrice = 0;
   } else if(totalPrice == 0){
      deliveryPrice = 0;
   } else {
      deliveryPrice = 3000;   
   }
   
   finalTotalPrice = totalPrice + deliveryPrice;   
   
   usePoint = $(".order_point_input").val();
   
   finalTotalPrice = finalTotalPrice - usePoint;   
   
   
   $(".totalPrice_span").text(totalPrice.toLocaleString());

   $(".goods_kind_div_count").text(totalCount);

   $(".goods_kind_div_kind").text(totalKind);
   
   $(".totalPoint_span").text(totalPoint.toLocaleString());
   
   $(".addPointA").text(AmemberRanK.toLocaleString());
   
   $(".addPointB").text(BmemberRanK.toLocaleString());
   
   $(".addPointC").text(CmemberRanK.toLocaleString());
   
   $(".delivery_price_span").text(deliveryPrice.toLocaleString());   

   $(".finalTotalPrice_span").text(finalTotalPrice.toLocaleString());      

   $(".usePoint_span").text(usePoint.toLocaleString());   
   
}

//0 이상 & 최대 포인트 수 이하
$(".order_point_input").on("propertychange change keyup paste input", function(){

   let totalPrice = 0;
   let deliveryPrice = 0;
   let point = parseInt('${memberInfo.mem_point}');
   let finalprice = 0;
   
   $(".goods_table_price_td").each(function(index, element){
      
   totalPrice += parseInt($(element).find(".individual_totalPrice_input").val());
      
   });
   
   if(totalPrice >= 30000){
      deliveryPrice = 0;
   } else if(totalPrice == 0){
      deliveryPrice = 0;
   } else {
      deliveryPrice = 3000;   
   }
   
   finalprice = totalPrice + deliveryPrice;
   
   console.log(point);
   console.log(totalPrice);
   console.log(finalprice);
   
   if(point > finalprice){
       maxPoint = parseInt((finalprice - point) + point);   
   }else{
       maxPoint = parseInt('${memberInfo.mem_point}');   
   }
   
   console.log(maxPoint);
   
   let inputValue = parseInt($(this).val());   
   
   if(inputValue < 0){
      $(this).val(0);
   } else if(inputValue > maxPoint){
      $(this).val(maxPoint);
   }   
   
   setTotalInfo();   
   
});


/* 포인트 모두사용 취소 버튼 
 * Y: 모두사용 상태 / N : 모두 취소 상태
 */
$(".order_point_input_btn").on("click", function(){
   
   
   let totalPrice = 0;
   let deliveryPrice = 0;
   let point = parseInt('${memberInfo.mem_point}');
   let finalprice = 0;
   
   $(".goods_table_price_td").each(function(index, element){
      
   totalPrice += parseInt($(element).find(".individual_totalPrice_input").val());
      
   });
   
   if(totalPrice >= 30000){
      deliveryPrice = 0;
   } else if(totalPrice == 0){
      deliveryPrice = 0;
   } else {
      deliveryPrice = 3000;   
   }
   
   finalprice = totalPrice + deliveryPrice;
   
   console.log(point);
   console.log(totalPrice);
   console.log(finalprice);
   
   if(point > finalprice){
       maxPoint = parseInt((finalprice - point) + point);   
   }else{
       maxPoint = parseInt('${memberInfo.mem_point}');   
   }
   
   /* const maxPoint = parseInt(4000); */ 
   
   console.log(maxPoint);
   
   let state = $(this).data("state");   
   
   if(state == 'N'){
      console.log("n동작");
      $(".order_point_input").val(maxPoint);
      $(".order_point_input_btn_Y").css("display", "inline-block");
      $(".order_point_input_btn_N").css("display", "none");
   } else if(state == 'Y'){
      console.log("y동작");
      $(".order_point_input").val(0);
      $(".order_point_input_btn_Y").css("display", "none");
      $(".order_point_input_btn_N").css("display", "inline-block");      
   }   
   
   setTotalInfo();   
   
});

$(".order_btn").on("click", function(){
   
   console.log(finalTotalPrice);
   
   let input = confirm('주문하시겠습니까?');
      
      if(input){
      
       if('${memberInfo.mem_cash}' < finalTotalPrice){ 
         alert("지갑금액이 부족합니다!");
         event.preventDefault();
          }else{
                
            $(".addressInfo_input_div").each(function(i, obj){
               if($(obj).find(".selectAddress").val() === 'T'){
                  $("input[name='addressee']").val($(obj).find(".addressee_input").val());
                  $("input[name='memberAddr1']").val($(obj).find(".address1_input").val());
               }
            });   
            
            $("input[name='usePoint']").val($(".order_point_input").val());   
            
            let form_contents = '';  
            $(".goods_table_price_td").each(function(index, element){
               let book_num = $(element).find(".individual_book_num_input").val();
               let bookCount = $(element).find(".individual_bookCount_input").val();
               let book_name = $(element).find(".individual_book_name_input").val();
               let book_num_input = "<input name='orders[" + index + "].book_num' type='hidden' value='" + book_num + "'>";
               form_contents += book_num_input;
               let bookCount_input = "<input name='orders[" + index + "].bookCount' type='hidden' value='" + bookCount + "'>";
               form_contents += bookCount_input;
               let book_name_input = "<input name='orders[" + index + "].book_name' type='hidden' value='" + book_name + "'>";
               form_contents += book_name_input;
               
            });   
            $(".order_form").append(form_contents);    // 선택된 요소의 마지막에 새로운 요소나 콘텐츠를 추가한다
            
            $(".order_form").submit();   
                
       }  /* else문 끝  */

      } /* 주문확인 */

   
});   


</script>

</body>
</html>