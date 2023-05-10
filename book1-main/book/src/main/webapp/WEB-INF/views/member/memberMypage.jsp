<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script type="text/javascript" src="/resources/js/memberJoin.js"></script>
<script type="text/javascript" src="/resources/js/memberCharge.js"></script>
<script type="text/javascript" src="/resources/js/boardComment.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://kit.fontawesome.com/92e616dfba.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>


<link rel="stylesheet" type="text/css" href="/resources/css/mypage.css">
<link rel="stylesheet" type="text/css" href="/resources/css/mypageCharge.css">
<link rel="stylesheet" type="text/css" href="/resources/css/mypageModify.css">
<link rel="stylesheet" type="text/css" href="/resources/css/mypageDelete.css">
<link rel="stylesheet" type="text/css" href="/resources/css/mypageOrderList.css">
<link rel="stylesheet" type="text/css" href="/resources/css/mypageBuyList.css">
<link rel="stylesheet" type="text/css" href="/resources/css/mypageBoardList.css">

<link rel="stylesheet" type="text/css" href="/resources/css/mypageBoardDetail.css">
<link rel="stylesheet" type="text/css" href="/resources/css/mypageBoardRegisterAndModify.css">
</head>
<body>
   <jsp:include page="../layout/header.jsp"></jsp:include>

   <script type="text/javascript">
      const ses = '<c:out value="${ses.mem_id}" />';
      if (ses == null || ses == '') {
         alert('로그인시 이용가능합니다. 메인 페이지로 이동합니다.');
         location.href = '/';
      }
   </script>

   <div class="main">
      <!-- 왼쪽 메뉴 -->
      <div class="select">
         <table class="mypage-left">
            <tr>  
               <td>
                  <h4>${ses.mem_name}님<br>환영합니다!!<br><br></h4>
                  지갑: <strong class="mem_cash"><fmt:formatNumber value="${ses.mem_cash}" pattern="#,### 원" /></strong><br>포인트: <strong>${ses.mem_point}</strong>포인트
               </td>
            </tr>
           
            <tr>
               <td><a href="/mem/modify" class="box">회원정보수정</a></td>
            </tr>
            <tr>
               <td><a href="/mem/charge?mem_num=${ses.mem_num}" class="box">충전하기</a></td>
            </tr>
            <tr>
               <td><a href="/mem/orderCheck?mem_num=${ses.mem_num}">주문/배송조회</a></td>
            </tr>
            <tr>
               <td><a href="/board/list" class="box">1대1문의</a></td>
            </tr>
            <tr>
               <td><a href="/mem/delete" class="box Withdrawal">회원탈퇴</a></td>
            </tr>
         </table>
      </div>
      <!-- 오른쪽 div 구역 -->
      <c:forEach items="${content}" var="content">
         <c:choose>
            <c:when test="${content eq 'modify' || content == 'main' }">
               <script type="text/javascript" src="/resources/js/memberJoin.js"></script>
               <form action="/mem/modify" method="post">
                  <div class="MypageModify mypage-right">
                     <h4>회원정보수정</h4>
                     <input type="text" name="mem_num" value="${ses.mem_num}" hidden><br>
                     <lable for="mem_id">ID</lable>
                     <br> <input type="text" class="join-input" name="mem_id" value="${ses.mem_id}" id="mem_id" placeholder="아이디" onchange="checkId()" readonly="readonly" required> <Br>
                     <lable for="mem_pw">PW</lable>
                     <br> <input type="password" class="join-input" name="mem_pw" id="mem_pw" placeholder="영문(대소문자 구분X), 숫자, 특수문자 조합, 9~12자리" onchange="checkPw()" required> <span class="pw_ok"><i class="fa-solid fa-check"></i></span> <span class="pw_rewrite"><i class="fa-solid fa-x"></i></span> <span class="pw_null"><i class="fa-solid fa-x"></i></span> <br>
                     <lable for="mem_pwRe">PW Re</lable>
                     <br> <input type="password" class="join-input" name="mem_pwRe" id="mem_pwRe" placeholder="비밀번호 확인을 위해 한번 더 입력해주세요" onchange="checkPwRe()" required> <span class="pwRe_ok"><i class="fa-solid fa-check"></i></span> <span class="pwRe_rewrite"><i class="fa-solid fa-x"></i></span> <span class="pwRe_null"><i class="fa-solid fa-x"></i></span> <br>
                     <lable for="mem_name">NAME</lable>
                     <br> <input type="text" class="join-input" name="mem_name" placeholder="이름" value="${ses.mem_name}" required> <br>
                     <lable for="mem_postzip">ADDRESS</lable>
                     <br> <input type="text" class="join-input zip" id="postcode" name="mem_postzip" placeholder="우편번호" value="${ses.mem_postzip}" required> 
                     <input type="button" class="join-input zip btn btn-outline-primary" onclick="execDaumPostcode()" value="우편번호 찾기"> <br> 
                     <input type="text" class="join-input" id="address" name="address" placeholder="주소" value="${ses.mem_ad.substring(0,ses.mem_ad.indexOf('/'))}" required> <br> 
                     <input type="text" class="join-input" id="detailAddress" name="detailAddress" placeholder="상세주소" value="${ses.mem_ad.substring(ses.mem_ad.indexOf('/')+2,ses.mem_ad.lastIndexOf('/'))}" required><br> 
                     <input type="text" class="join-input" id="extraAddress" name="extraAddress" placeholder="참고항목" value="${ses.mem_ad.substring(ses.mem_ad.lastIndexOf('/')+1)}" readonly="readonly"> <br>
                     <lable for="mem_age">AGE</lable>
                     <br> <input type="number" class="join-input" name="mem_age" placeholder="나이" value="${ses.mem_age}" required> <br>
                     <lable for="mem_cell_num">PHONE</lable>
                     <br> <input type="number" class="join-input" name="mem_cell_num" id="mem_cell_num" value="${ses.mem_cell_num}" placeholder="숫자만 써주세요" onchange="checkCellNum()" required> <span class="cellNum_ok"><i class="fa-solid fa-check"></i></span> <span class="cellNum_duplicate"><i class="fa-solid fa-x"></i></span> <span class="cellNum_null"><i class="fa-solid fa-x"></i></span> <br>
                     <lable for="mno_cno">FAVORITE</lable>
                     <br> <select class="join-input" name="mem_cno">
                        <option value="1">소설</option>
                        <option value="2">에세이</option>
                        <option value="3">건강/취미</option>
                        <option value="4">컴퓨터/모바일</option>
                        <option value="5">문제집</option>
                     </select> <Br> <br>
                     <button type=submit " class="btn btn-outline-secondary btn-submit">수정하기</button>
                  </div>
               </form>
            </c:when>
            <c:when test="${content eq 'charge'}">

               <div class="moneyCharge mypage-right">
                  <div class="cashBox">
                     <span id="cashNow">현재 충전금액 </span> 
                     <input type="text" value="${ses.mem_cash}원" id="cash">
                  </div>
                  <br>


                  <form src="/mem/charge2" method="post">
                     <input type="text" name="mem_num" value="${ses.mem_num}" hidden> 
                     <input type="text" name="mem_id" value="${ses.mem_id}" id="mem_id" hidden> 
                     <input type="text" name="mem_pw" value="${ses.mem_pw}" hidden> 
                     <input type="number" name="mem_cash" id="mem_cash">
                     <button type="button" onclick="charge()">충전하기</button>
                  </form>
                  <div class="cashImgBox">
                     <img src="/resources/img/coin.png" style="width: 600px;">
                  </div>
               </div>
               <hr id="chargeHr">
               <script type="text/javascript">
                  function charge() {
                     let mem_cash = document.getElementById('mem_cash').value;
                     let mem_id = document.getElementById('mem_id').value;
                     console.log("js mem_cash 테스트 : " + mem_cash);
                     console.log("js mem_id 테스트 : " + mem_id);
                     $.ajax({
                              url : '/mem/charge2', //Controller에서 요청 받을 주소
                              type : 'post', //POST 방식으로 전달
                              data : {
                                 mem_cash : mem_cash,
                                 mem_id : mem_id
                              },
                              success : function(cashNow2) { //컨트롤러에서 넘어온 값을 받는다 
                                 console.log("컨트롤러에서 건너온 sum : "
                                       + cashNow2); //결과값 : [object XMLDocument]

                                 document.getElementById('mem_cash').value = ""; //입력한 값은 지워주기
                                 document.getElementById('cash').value = cashNow2+"원"; //잔액 변동사항을 반영
                                 

                              },
                              error : function(request, status, error) {
                                 console.log("code:"
                                       + request.status + "\n"
                                       + "message:"
                                       + request.responseText
                                       + "\n" + "error:" + error);
                              }

                           });
                  };
               </script>
            </c:when>
            <c:when test="${content eq 'orderList'}">
               <div class="memberOrderList mypage-right">
                  <h4>주문/배송조회</h4>
                  <table class="table">
                     <thead>
                        <tr>
                           <th scope="col">주문번호</a></th>
                           <th scope="col">주문자</th>
                           <th scope="col">주문상태</th>
                           <th scope="col">주소</th>
                           <th scope="col">구매결정</th>
                        </tr>
                     </thead>
                     <tbody>
                        <c:forEach items="${list}" var="order">
                           <tr>
                              <th scope="row"><a href="/mem/orderListDetail?order_num=${order.order_num}">${order.order_num}</a></th>
                              <td>${ses.mem_id}</td>
                              <td>${order.order_sta}</td>
                              <td>${order.order_add1}&nbsp${order.order_add2}</td>
                              <td><button type="button" onclick="confirmed(event)" class="btn btn-outline-secondary"><a href="/order/Confirmed/?order_num=${order.order_num}&order_mem_num=${order.order_mem_num}" >구매결정</a></button></td>
                           </tr>
                        </c:forEach>

                     </tbody>
                  </table>
                  <div>
                     <c:if test="${pgh.prev}">
                        <a href="/mem/orderCheck?pageNo=${pgh.startPage-1}&qty=${pgh.pgvo.qty}&mem_num=${ses.mem_num}">prev</a>
                     </c:if>
                     <c:forEach begin="${pgh.startPage }" end="${pgh.endPage }" var="i">
                        <a href="/mem/orderCheck?pageNo=${i}&qty=${pgh.pgvo.qty}&mem_num=${ses.mem_num}">${i} ｜ </a>
                     </c:forEach>
                     <c:if test="${pgh.next}">
                        <a href="/mem/orderCheck?pageNo=${pgh.endPage+1}&qty=${pgh.pgvo.qty}&mem_num=${ses.mem_num}">next</a>
                     </c:if>
                  </div>

               </div>
            </c:when>

            <c:when test="${content eq 'orderDetail' }">
               <div class="mypage-right">
                  <h4>주문상세화면</h4>
                  <table class="table ">
                     <thead>
                        <tr>
                           <th scope="col">이미지</th>
                           <th scope="col">책이름</th>
                           <th scope="col">책가격</th>
                           <th scope="col">주문권수</th>
                           <th scope="col">적립포인트</th>

                        </tr>
                     </thead>
                     <tbody>
                        <c:forEach items="${list}" var="order">
                           <tr>
                              <td class="linecenter">
                                  <a href="/book/bkDetailView?book_num=${order.book_num}"> 
                                 <img class="book_img" src="/upload/${fn:replace(order.imageList[0].save_dir,'\\','/')}/${order.imageList[0].uuid}_${order.imageList[0].file_name}" style="height: 80px; width: 70px;" alt="bookThumbnail">
                                 </a>
                             </td>
                             <td class="linecenter"><a href="/book/bkDetailView?book_num=${order.book_num}">${order.book_name}</a></td>
                             <td class="linecenter">${order.book_price}</td>
                             <td class="linecenter">${order.bookCount}</td>
                             <c:if test="${ses.mem_rating eq 'A'}">
                             <td class="linecenter">${(order.savePoint*4)*order.bookCount}</td>
                             </c:if>
                             <c:if test="${ses.mem_rating eq 'B'}">
                             <td class="linecenter">${(order.savePoint*3)*order.bookCount}</td>
                             </c:if>
                             <c:if test="${ses.mem_rating eq 'C'}">
                             <td class="linecenter">${(order.savePoint*2)*order.bookCount}</td>
                             </c:if>
                             <c:if test="${ses.mem_rating eq 'D'}">
                             <td class="linecenter">${order.savePoint*order.bookCount}</td>
                              </c:if>
                           </tr>
                        </c:forEach>

                     </tbody>
                  </table>
                  <div></div>
               </div>

            </c:when>


            <c:when test="${content eq 'boardList'}">
               <div class="mypage-right">
                  <table class="table">
                     <h4>1대1문의</h4>
                     <thead>
                        <tr>
                           <th scope="col">글번호</th>
                           <th scope="col">제목</th>
                           <th scope="col">카테고리</th>
                           <th scope="col">글쓴이</th>
                           <th scope="col">작성일자</th>
                           <th scope="col">조회수</th>
                        </tr>
                     </thead>


                     <c:forEach items="${list}" var="board">
                        <c:choose>
                           <c:when test="${ses.mem_auth == '0'|| ses.mem_id == board.brd_writer}">
                              <tbody>
                                 <tr>
                                    <td scope="row">${board.brd_num}</td>
                                    <td><a href="/board/boardDetail?brd_num=${board.brd_num}">${board.brd_title}</a></td>
                                    <td>${board.brd_category}</td>
                                    <td>${board.brd_writer}</td>
                                    <td>${board.brd_regdate}</td>
                                    <td>${board.brd_views}</td>

                                 </tr>
                              </tbody>
                           </c:when>

                           <c:otherwise>
                              <tr>
                                 <td>${board.brd_num}</td>
                                 <td><a href="/board/boardDetail?brd_num=${board.brd_num}">${board.brd_title}</a></td>
                                   
                                 <td>${board.brd_category}</td>
                                 <c:choose>
                                    <c:when test="${ses.mem_id eq board.brd_writer}">
                                       <td>${board.brd_writer}</td>
                                    </c:when>
                                    <c:otherwise>
                                       <td>******</td>
                                    </c:otherwise>
                                 </c:choose>
                                 <td>${board.brd_regdate}</td>
                                 <td>${board.brd_views}</td>
                              </tr>
                           </c:otherwise>
                        </c:choose>
                     </c:forEach>


                  </table>
                  <div>
                     <c:if test="${pgh.prev}">
                        <a href="/board/list?pageNo=${pgh.startPage-1}&qty=${pgh.pgvo.qty}&type=${pgh.pgvo.type}&keyword=${pgh.pgvo.keyword}">prev</a>
                     </c:if>
                     <c:forEach begin="${pgh.startPage }" end="${pgh.endPage }" var="i">
                        <a href="/board/list?pageNo=${i}&qty=${pgh.pgvo.qty}&type=${pgh.pgvo.type}&keyword=${pgh.pgvo.keyword}">${i} ｜ </a>
                     </c:forEach>
                     <c:if test="${pgh.next}">
                        <a href="/board/list?pageNo=${pgh.endPage+1}&qty=${pgh.pgvo.qty}&type=${pgh.pgvo.type}&keyword=${pgh.pgvo.keyword}">next</a>
                     </c:if>
                  </div>
                  <!-- search -->

                  <div class="col-sm-12 col-md-6">
                     <form action="/board/list" method="get">
                        <div class="input-group mb-3">
                           <!-- 값을 별도 저장 -->
                           <c:set value="${pgh.pgvo.type}" var="typed" />
                           <select class="form-select" name="type">
                              <option ${typed==null ? 'selected' :'' }>항목</option>
                              <option value="t" ${typed eq 't' ? 'selected' :'' }>제목</option>
                              <option value="c" ${typed eq 'c' ? 'selected' :'' }>내용</option>
                              <option value="w" ${typed eq 'w' ? 'selected' :'' }>작성자</option>
                           </select> <input class="form-control" type="text" name="keyword" placeholder="포함해서찾기" value="${pgn.pgvo.keyword }"> <input type="hidden" name="pageNo" value="1"> <input type="hidden" name="qty" value="${pgh.pgvo.qty }">
                           <button type="submit" class="btn btn-success position-relative">
                              결과 <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger"> ${pgh.totalCount}개 <span class="visually-hidden">unread messages</span>
                              </span>
                           </button>
                        </div>
                     </form>
                  </div>
                  <a href="/board/register"><button class="btn btn-secondary">1대1문의 작성하기</button></a>
               </div>
            </c:when>
            <c:when test="${content eq 'delete' }">
               <div class="delete mypage-right">
                  <h4>탈퇴 안내</h4>

                  <div class="short">회원탈퇴를 신청하기 전에 안내 사항을 꼭 확인해주세요.</div>
                  <div class="long">사용하고 계신 아이디(${ses.mem_id})는 탈퇴할 경우 아이디에 대한 데이터 재사용 및 복구가 불가능합니다.</div>
                  <div class="short">탈퇴후 복구가 불가하오니 신중하게 선택하시기 바랍니다.</div>
                  <div class="long">탈퇴 후 회원정보 및 개인형 서비스 이용기록은 모두 삭제됩니다.</div>
                  <div class="short">회원정보 및 주소 등 개인형 서비스 이용기록은 모두 삭제되며, 삭제된 데이터는 복구되지 않습니다.</div>
                  <div class="long">탈퇴 후에도 게시판형 서비스에 등록한 게시물은 그대로 남아 있습니다.</div>
                  <div class="short">게시글 및 댓글은 탈퇴 시 자동 삭제되지 않고 그대로 남아 있습니다. 삭제를 원하는 게시글이 있다면 반드시 탈퇴 전 삭제하시기 바랍니다. 탈퇴 후에는 회원정보가 삭제되어 본인 여부를 확인할 수 있는 방법이 없어, 게시글을 임의로 삭제해드릴 수 없습니다.</div>
                  <div class="deleteTableBox">
                     <table class="table table-bordered">                  
                        <tr>
                           <td>개인정보</td>
                           <td>개인정보 전체 삭제</td>
                        </tr>
                        <tr>
                           <td>1대1문의게시판</td>
                           <td>질문,답변 삭제되지 않음.</td>
                        </tr>
                     </table>
                  </div>
                  탈퇴 후에는 아이디 ${ses.mem_id}에 대한 데이터는 복구할 수 없습니다. 게시판형 서비스에 남아 있는 게시글은 탈퇴 후 삭제할 수 없습니다.
                  <form action="/mem/delete?mem_num=${ses.mem_num}" method="post">
                     <input type="checkbox" class="checkbox" required> 안내 사항을 모두 확인하였으며, 이에 모두 동의합니다. <br>
                     <div class="button">
                        <button type="submit" class="btn btn-secondary">탈퇴</button>
                     </div>
                  </form>
               </div>
            </c:when>
            <c:when test="${content eq 'boardRegister' }">
               <div class="boardRegister mypage-right">
                  <div class="boardRegisterBox">
                     <form action="/board/register" method="post">
                        <div class="brd_category">
                           <label for="brd_category">카테고리</label> <select name="brd_category">
                              <option>질문</option>
                              <option>자유</option>
                              <option>테스트</option>
                           </select>
                        </div>
                        <div class="brd_titleAndWriter">
                           <label for="brd_title">제목</label> <input type="text" name="brd_title" class="brd_title" required> <label for="brd_writer">작성자</label> <input type="text" name="brd_writer" value="${ses.mem_id}" readonly><br>
                        </div>
                        <div class="brd_content">
                           <label for="brd_content">내용</label><br>
                           <textarea rows="10" cols="100" name="brd_content"></textarea>
                           <br>
                        </div>

                        <button type="submit" class="btn btn-secondary">작성하기</button>
                        <div name="brd_mem_num" value="${ses.mem_num}"></div>
                     </form>
                  </div>
               </div>
            </c:when>
            <c:when test="${content eq 'boardDetail' }">
                  <c:choose>
                   <c:when test="${ses.mem_auth == '0'|| ses.mem_id == board.brd_writer}">
               <div class="mypage-right boardDetail">
                   	글번호 ${board.brd_num}
                  <h2>${board.brd_title}</h2>
                  <sapn class="boardDetail-writer">${board.brd_writer}</sapn>
                  <span class="boardDetail-regdate">${board.brd_regdate}</span>
                  <hr>
                  <div class="boardDetail-content">${board.brd_content}</div>
                  <Br> <a href="/board/boardModify?brd_num=${board.brd_num}">
                     <button type="button" class="btn btn-success">수정</button>
                  </a> <a href="/board/remove?brd_num=${board.brd_num}">
                     <button type="button" class="btn btn-danger">삭제</button>
                  </a><a href="/board/list">
                     <button type="button" class="btn btn-outline-secondary">1대1문의 리스트 목록</button>
                  </a> <br>

                  <div class="container">
                     <div class="input-group my-3">
                        <span class="input-group-text" id="cmtWriter">${ses.mem_id}</span> <input type="text" class="form-control" id="cmtText" placeholder="Test Add Comment ">
                        <button class="btn btn-success" id="cmtPostBtn" type="button">Post</button>
                     </div>
                     <ul class="list-group list-group-flush" id="cmtListArea">
                        <li class="list-group-item d-flex justify-content-between align-items-start">
                           <div class="ms-2 me-auto">
                              <div class="fw-bold">
                                 Writer <span class="badge bg-dark rounded-pill">modAt</span>
                              </div>
                              Content for Comment
                           </div>
                        </li>
                     </ul>
                  </div>
                   
                  <script type="text/javascript">
                     const bnoVal = '<c:out value="${board.brd_num}" />';

                     const auth = '<c:out value="${ses.mem_auth}"/>';

                     console.log(auth);
                     console.log(bnoVal);
                  </script>
                  <script type="text/javascript" src="/resources/js/boardComment.js"></script>
                  <script type="text/javascript">
                     getCommentList(bnoVal, auth);
                  </script>
               		</div>
                   </c:when>
               		
               		
                    <c:otherwise>
                      <div class="mypage-right boardDetail">
                    글번호 ${board.brd_num}
                  <h2>${board.brd_title}</h2>
                  <sapn class="boardDetail-writer">******</sapn>
                  <span class="boardDetail-regdate">${board.brd_regdate}</span>
                  <hr>
                  <div class="boardDetail-content">${board.brd_content}</div>
                  <a href="/board/list">
                     <button type="button" class="btn btn-outline-secondary">1대1문의 리스트 목록</button>
                  </a> <br>

                  <div class="container">
                     <div class="input-group my-3">
                        <span class="input-group-text" id="cmtWriter">${ses.mem_id}</span> <input type="text" class="form-control" id="cmtText" placeholder="Test Add Comment ">
                        <button class="btn btn-success" id="cmtPostBtn" type="button">Post</button>
                     </div>
                     <ul class="list-group list-group-flush" id="cmtListArea">
                        <li class="list-group-item d-flex justify-content-between align-items-start">
                           <div class="ms-2 me-auto">
                              <div class="fw-bold">
                                 Writer <span class="badge bg-dark rounded-pill">modAt</span>
                              </div>
                              Content for Comment
                           </div>
                        </li>
                     </ul>
                  </div>
                    <script type="text/javascript">
                     const bnoVal = '<c:out value="${board.brd_num}" />';

                     const auth = '<c:out value="${ses.mem_auth}"/>';

                     console.log(auth);
                     console.log(bnoVal);
                  </script>
                  <script type="text/javascript" src="/resources/js/boardComment.js"></script>
                  <script type="text/javascript">
                     getCommentList(bnoVal, auth);
                  </script>
                    
                    </div>
                    </c:otherwise>
                   </c:choose>
             






            </c:when>
            <c:when test="${content eq 'boardModify' }">
               <div class="boardRegister mypage-right">
                  <div class="boardRegisterBox">
                     <form action="/board/modify" method="post">
                        <input type="text" name="brd_num" value="${board.brd_num}" readonly hidden><br>

                        <div class="brd_titleAndWriter">
                           <label for="brd_title">제목</label> <input type="text" name="brd_title" class="brd_title" value="${board.brd_title}" required> <label for="brd_writer">작성자</label> <input type="text" name="brd_writer" value="${ses.mem_id}" value="${board.brd_writer}" readonly><br>
                        </div>
                        <div class="brd_regdate">
                           <label for="brd_regdate">작성일</label> <input type="text" name="brd_regdate" value="${board.brd_regdate}" readonly><br>
                        </div>
                        <div class="brd_content">
                           <label for="brd_content">내용</label><br> <input type="text" name="brd_content" class="brd_content" value="${board.brd_title}" required>

                        </div>
                        <button type="submit" class="btn btn-secondary btnModify">수정</button>
                        <div name="brd_mem_num" value="${ses.mem_num}"></div>
                     </form>
                  </div>
               </div>
            </c:when>
         </c:choose>
      </c:forEach>
   </div>
   <jsp:include page="../layout/footer.jsp"></jsp:include>
   
   <script type="text/javascript">
   function confirmed(event) {
      let input = confirm('구매확정 하시겠습니까?');
      
      if(input){
         
      } else {
         event.preventDefault();
      }
   }
   
   
   </script>
   


</body>

</html>