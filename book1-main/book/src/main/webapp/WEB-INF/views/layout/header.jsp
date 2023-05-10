<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://kit.fontawesome.com/92e616dfba.js" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<!DOCTYPE html>
<html>
<head>
<style>
.header {
   margin: 0 auto;
   width: 1260px;
   height: 200px;
}

.menu {
   display: flex;
   justify-content: flex-end;
   padding: 5px;
}

.logo {
   width: 150px;
   height: 150px;
   background-color: blue;
}

.logo>a>img {
   width: 150px;
   height: 150px;
}

.searchBar {
   /* position:absolute; */
   width: 484px;
   height: 42px;
   /* background-color: gold; */
   margin-top: 54px;
   border-radius: 30px;
}

.bar {
   height: 150px;
   display: flex;
   flex-direction: row;
   flex-wrap: nowrap;
   justify-content: space-around;
   /*    align-items: baseline; */
}

.icons>a>i {
   font-size: 42px;
   color: black;
   margin-top: 54px;
   margin-right: 20px;
}
</style>
</head>
<body>
   <div class="header">
      <div class="menu">
         <c:if test="${ses.mem_id ==null}">
            <ul>
               <a href="/mem/loginPage">로그인</a>
            </ul>
            <ul>
               <a href="/mem/joinPage">회원가입</a>
            </ul>
         </c:if>
         <c:if test="${ses.mem_auth == '0' }">
            <ul>
               <a href="/mem/logOut">로그아웃</a>
            </ul>
            <ul>
               <a href="/mem/adminPage">관리인페이지</a>
            </ul>
         </c:if>
         <c:if test="${ses.mem_id !=null && ses.mem_auth !='0' }">
            <ul>
               <a href="/mem/logOut">로그아웃</a>
            </ul>
            <ul>
               <a href="/mem/mypage">마이페이지</a>
            </ul>
         </c:if>
         <%-- <ul>
            <a href="/cart/cartdetail?mem_num=${ses.mem_num}">장바구니</a>
         </ul> --%>
         <c:if test="${ses.mem_id !=null}">
         <ul>
            <a href="/cart/cartdetail?mem_num=${ses.mem_num}">장바구니</a>
         </ul>
         </c:if>
         <c:if test="${ses.mem_id == null}">
               <a href="/mem/loginPage" onclick="gologin(event)">&nbsp&nbsp&nbsp장바구니</a>
         </c:if>
      </div>
      <div class="bar">
         <div class="logo">
            <a href="/"><img src="/resources/img/logo.jpg" alt="로고"></a>
         </div>
         <div class="searchBar">
            <form action="/book/search" class="d-flex" role="search" method="get">
               <div class="input-group mb-3">
                  <!-- 값을 별도 저장 -->
                  <c:set value="${pgh.pgvo.type}" var="typed" />
                  <select class="form-select" name="type">
                     <option value="t" ${typed eq 't' ? 'selected' :'' }>책제목</option>
                     <option value="c" ${typed eq 'c' ? 'selected' :'' }>작가이름</option>
                     <option value="w" ${typed eq 'w' ? 'selected' :'' }>출판사</option>
                  </select> <input class="form-control me-2" type="text" name="keyword" placeholder="포함해서찾기"> <input type="hidden" name="pageNo" value="1"> <input type="hidden" name="qty" value="10">
                  <button class="btn btn-outline-success" type="submit">Search</button>
                  <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger"> ${pgh.totalCount}개 <span class="visually-hidden">unread messages</span>
                  </span>
               </div>
            </form>
         </div>
         <div class="icons">
            <!-- 로그인 되었을때 -->
            <c:if test="${ses.mem_id !=null}">
            <a href="/cart/cartdetail?mem_num=${ses.mem_num}">
               <i class="fa-solid fa-cart-shopping"></i>
            </a>
            </c:if>
            <!-- 로그인 안되었을때 -->
            <c:if test="${ses.mem_id == null}">
            <a href="/mem/loginPage" onclick="gologin(event)">
               <i class="fa-solid fa-cart-shopping"></i>
            </a>
            </c:if> 
            
            <c:if test="${ses.mem_auth == '0' }">
               <a href="/mem/adminPage">
                  <i class="fa-solid fa-user"></i>
               </a>
            </c:if>
            <c:if test="${ses.mem_auth != '0' }">
               <a href="/mem/mypage">
                  <i class="fa-solid fa-user"></i>
               </a>
            </c:if>
               
         </div>
      </div>
   </div>
   
   <script type="text/javascript">
      function gologin(event) {
         alert("로그인이 필요합니다!");
      }
      </script>
</body>
</html>