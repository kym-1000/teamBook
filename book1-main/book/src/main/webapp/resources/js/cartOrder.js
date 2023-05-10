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
      
      totalPrice += parseInt($(element).find(".totalPrice_input").val());
      
      totalCount += parseInt($(element).find(".bookCount_input").val());
      
      totalKind += 1;
      
      totalPoint += parseInt($(element).find(".totalPoint_input").val());
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
   
   usePoint = $(".order_point").val();
   
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
$(".order_point").on("propertychange change keyup paste input", function(){

   let totalPrice = 0;
   let deliveryPrice = 0;
   let point = parseInt('${memberInfo.mem_point}');
   let finalprice = 0;
   
   $(".goods_table_price_td").each(function(index, element){
      
   totalPrice += parseInt($(element).find(".totalPrice_input").val());
      
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
      
   totalPrice += parseInt($(element).find(".totalPrice_input").val());
      
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
   
   let state = $(this).data("state");   
   
   if(state == 'N'){
      console.log("n동작");
      $(".order_point").val(maxPoint);
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
            
            $("input[name='usePoint']").val($(".order_point").val());   
            
            let form_contents = '';  
            $(".goods_table_price_td").each(function(index, element){
               let book_num = $(element).find(".book_num_input").val();
               let bookCount = $(element).find(".bookCount_input").val();
               let book_name = $(element).find(".book_name_input").val();
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