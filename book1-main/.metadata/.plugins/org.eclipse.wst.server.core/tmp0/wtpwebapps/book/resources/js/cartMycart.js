$(document).ready(function(){
   
   setTotalInfo();   
   
});   

/* 체크여부에따른 종합 정보 변화 */
$(".individual_cart_checkbox").on("change", function(){
   /* 총 주문 정보 세팅(배송비, 총 가격, 마일리지, 물품 수, 종류) */
   setTotalInfo($(".cart_info_td"));
});

/* 체크박스 전체 선택 */
$(".all_check_input").on("click", function(){

   /* 체크박스 체크/해제 */
   if($(".all_check_input").prop("checked")){
      $(".individual_cart_checkbox").attr("checked", true);
   } else{
      $(".individual_cart_checkbox").attr("checked", false);
   }
   
   /* 총 주문 정보 세팅(배송비, 총 가격, 마일리지, 물품 수, 종류) */
   setTotalInfo($(".cart_info_td"));   
   
});


/* 총 주문 정보 세팅(배송비, 총 가격, 마일리지, 물품 수, 종류) */
function setTotalInfo(){
   
   let totalPrice = 0;            // 총 가격
   let totalCount = 0;            // 총 갯수
   let totalKind = 0;            // 총 종류
   let totalPoint = 0;            // 총 마일리지               
   let deliveryPrice = 0;         // 배송비
   let finalTotalPrice = 0;       // 최종 가격(총 가격 + 배송비)  1

   $(".cart_info_td").each(function(index, element){
      
      if($(element).find(".individual_cart_checkbox").is(":checked") === true){   
      
         totalPrice += parseInt($(element).find(".totalPrice_input").val());
                  
         totalCount += parseInt($(element).find(".bookCount_input").val());
         
         totalKind += 1;
         
         totalPoint += parseInt($(element).find(".totalPoint_input").val());         
      }

   });
   
   if(totalPrice >= 30000){
      deliveryPrice = 0;
   } else if(totalPrice == 0){
      deliveryPrice = 0;
   } else {
      deliveryPrice = 3000;   
   }
   
      finalTotalPrice = totalPrice + deliveryPrice;
   
      
   $(".totalPrice_span").text(totalPrice.toLocaleString());

   $(".totalCount_span").text(totalCount);
   
   $(".totalKind_span").text(totalKind);
   
   $(".totalPoint_span").text(totalPoint.toLocaleString());
   
   $(".delivery_price").text(deliveryPrice);   
   
   $(".finalTotalPrice_span").text(finalTotalPrice.toLocaleString());      
}

/* 주문 페이지 이동 */   
$(".order_btn").on("click", function(){
   
   
   
     if('${mvo.mem_cartNum}' == 0){ 
      alert("장바구니가 비었습니다!");
      event.preventDefault();
          }else{
            let form_contents ='';
            let orderNumber = 0;
            
            $(".cart_info_td").each(function(index, element){
               
               if($(element).find(".individual_cart_checkbox").is(":checked") == true){   //체크여부
                  
                  let cart_book_num = $(element).find(".bookId_input").val();
                  let bookCount = $(element).find(".bookCount_input").val();
                  
                  console.log(cart_book_num);
                  console.log(bookCount);
                   
                  let cart_book_num_input = "<input name='orders[" + orderNumber + "].cart_book_num' type='hidden' value='" + cart_book_num + "'>";
                  form_contents += cart_book_num_input;
                  
                  let bookCount_input = "<input name='orders[" + orderNumber + "].bookCount' type='hidden' value='" + bookCount + "'>";
                  form_contents += bookCount_input;
                  
                  orderNumber += 1;
                  
               }
            });   
         
            $(".order_form").html(form_contents);
            $(".order_form").submit();
             
      } /* else문 끝  */
      
            
   
});