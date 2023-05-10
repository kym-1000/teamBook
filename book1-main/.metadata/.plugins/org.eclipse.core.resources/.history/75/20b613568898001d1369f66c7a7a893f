<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.net.HttpURLConnection"%>
<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.InputStreamReader"%>

<html>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/92e616dfba.js" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<head>
<title>Home</title>
<style>
* {
   text-align: center;
}

.home_main {
   margin: 0 auto;
   width: 1260px;
}

.slide {
   background-color: peru;
   margin: 0 auto;
   width: 1260px;
   height: 500px;
}

.todayBookImg {
   width: 300px;
   height: 300px;
   background-color: aqua;
}

.todayBookImg>img {
   width: 300px;
   height: 300px;
}

.todayBook {
   margin: 20px 0;
}

.todayBookIntroduce {
   margin: 0 auto;
   display: flex;
}

.Best_item {
   width: 230px;
   height: 310px;
   /* background-color: antiquewhite; */
   display: inline-block;
   vertical-align: top;
   margin-right: 10px;
   margin-bottom: 50px;
   border: 1px solid darkgray;
   border-radius: 20px;
}

.img_box {
   width: 220px;
   height: 200px;
   /* background-color: lightgray; */
   margin: 5px;
}

.book_img {
   width: 180px;
   height: 200px;
}

.main_book_header {
   font-size: 16px;
}

.main_book_writer {
   font-size: 10px;
}

.BestSellerList {
   list-style: none;
   padding: 0px;
   /* display: -moz-inline-box; */
}

.BestSellerList:nth-last-child(-n+5) {
   margin-top: 50px;
}

.bestSeller {
   /* display: flex; */
   
}

.d-block {
   height: 500px;
}
.rank{
   margin-top:8px;
}
.rank>i {
   margin-right:0px;
   padding: 0;
   text-align: center;
   /*    text-align: left; */
}

.fa-solid {
   font-size: 15px;
   
   margin-top:3px;
}

.foot-ad {
   /* background-color: purple; */
   height: 200px;
   margin: 20px 0px;
}

.foot-ad>a>img {
   height: 200px;
}

.ad {
   margin: 20px 0;
   height: 150px;
   display: flex;
   justify-content: space-around;
}

.ad_mini {
   width: 300px;
   height: 150px;
}

.ad_mini>a>img {
   border-radius: 10px;
   width: 300px;
   height: 150px;
}
.ellipsis-two {
   
   overflow: hidden;
text-overflow: ellipsis;
display: -webkit-box;
-webkit-line-clamp: 2; 
-webkit-box-orient: vertical;
padding-bottom: 0.14em
}
.main_book_header{
   margin:5px;
   font-size:15px;
   
}
</style>
</head>
<body>
   <jsp:include page="./layout/header.jsp"></jsp:include>


   <div class="home_main">
      <nav class="navbar navbar-expand-lg bg-light">
         <div class="container-fluid">
            <!-- <a class="navbar-brand" href="#">Navbar</a> -->
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
               <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
               <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                  <!-- <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">이벤트</a>
              </li> -->
                  <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"> 카테고리 </a>
                     <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/interest/?mem_cno=1">소설</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="/interest/?mem_cno=2">에세이</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="/interest/?mem_cno=3">건강/취미</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="/interest/?mem_cno=4">컴퓨터/모바일</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="/interest/?mem_cno=5">문제집</a></li>
                     </ul></li>
                  <li class="nav-item"><a class="nav-link" href="/"></a></li>
                  
                  
                  <c:if test="${ses.mem_id ne null}">
                        <c:if test="${ses.mem_rating eq 'D'}">                  
                        <li class="nav-item"><a class="nav-link" href="/event">이벤트</a></li>                  
                        <li class="nav-item"><a class="nav-link" href="/interest/?mem_cno=${ses.mem_cno}">나의 관심 카테고리 책</a></li>
                        </c:if>                        
                        <c:if test="${ses.mem_rating ne 'D'}">
                        <li class="nav-item"><a class="nav-link" href="/event">이벤트참여완료</a></li>                  
                        <li class="nav-item"><a class="nav-link" href="/interest/?mem_cno=${ses.mem_cno}">나의 관심 카테고리 책</a></li>
                        </c:if>
                       </c:if>
               </ul>
            </div>
         </div>
      </nav>
      <div class="slide">
         <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="false">
            <div class="carousel-indicators">
               <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
               <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
               <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
               <div class="carousel-item active">
                  <img src="../resources/img/main-slide-ad1.jpg" class="d-block w-100" alt="...">
               </div>
               <div class="carousel-item">
                  <img src="../resources/img/main-slide-ad2.jpg" class="d-block w-100" alt="...">
               </div>
               <div class="carousel-item">
                  <img src="../resources/img/main-slide-ad3.jpg" class="d-block w-100" alt="...">
               </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
               <span class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
               <span class="carousel-control-next-icon" aria-hidden="true"></span> <span class="visually-hidden">Next</span>
            </button>
         </div>
      </div>

      <div class="ad">
         <div class="ad_mini">
            <a href="#"> <img src="../resources/img/mini-ad1.jpg">
            </a>
         </div>
         <div class="ad_mini">
            <a href="#"> <img src="../resources/img/mini-ad1.jpg">
            </a>
         </div>
         <div class="ad_mini">
            <a href="#"> <img src="../resources/img/mini-ad1.jpg">
            </a>
         </div>
      </div>

      <c:choose>
         <c:when test="${content eq 'main'}">
            <div class="hidden">
               <h1>베스트 셀러</h1>
               <div class="BestSeller">
                  <ul class="BestSellerList">
                     <c:forEach items="${book_list}" var="list" varStatus="i" begin="0" end="9">
                        <li class="Best_item">
                           <div class="rank">      
                              <i class="fa-solid fa-${i.count}"></i>
                              <c:if test="${i.count > 9}">
                                 <i class="fa-solid fa-1"></i>
                                 <i class="fa-solid fa-0"></i>
                              </c:if>
                           </div>
                           <div class="img_box">
                              <a href="/book/bkDetailView?book_num=${list.bvo.book_num}"> 
                                 <img class="book_img" src="/upload/${fn:replace(list.save_dir,'\\','/')}/${list.uuid}_${list.file_name}" alt="bookThumbnail">
                              </a>
                           </div>
                           <div class="info_box">
                              <span class="main_book_header ellipsis-two">${list.bvo.book_title}</span> 
             
                              <span class="main_book_writer">${list.bvo.book_writer} : ${list.bvo.book_publisher}</span>
                           </div>
                        </li>
                     </c:forEach>
                  </ul>
               </div>
            </div>
             <div class="todayBook">
         <h1>오늘의 책</h1>
         <div class="BestSeller">
            <ul class="BestSellerList">
               <c:forEach items="${randombook}" var="list" begin="0" end="9">
                  <li class="Best_item">
                     <div class="rank">
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                        <i class="fa-solid fa-star"></i>
                     </div>
                     <div class="img_box">
                        <a href="/book/bkDetailView?book_num=${list.bvo.book_num}"> 
                        <img class="book_img" src="/upload/${fn:replace(list.save_dir,'\\','/')}/${list.uuid}_${list.file_name}" alt="bookThumbnail">
                        </a>
                     </div>
                     <div class="info_box">
                        <span class="main_book_header ellipsis-two">${list.bvo.book_title}</span>
                        <span class="main_book_writer">${list.bvo.book_writer} : ${list.bvo.book_publisher}</span>
                     </div>
                  </li>
               </c:forEach>
            </ul>
         </div>
         </div>
         </c:when>

         <c:when test="${content eq 'novel' }">

            <div class="hidden">
               <h1>소설 top10</h1>
               <div class="BestSeller">
                  <ul class="BestSellerList">
                        <c:forEach items="${book_list}" var="list" varStatus="i" begin="0" end="9">
                        <li class="Best_item">
                           <div class="rank">      
                              <i class="fa-solid fa-${i.count}"></i>
                              <c:if test="${i.count > 9}">
                                 <i class="fa-solid fa-1"></i>
                                 <i class="fa-solid fa-0"></i>
                              </c:if>
                           </div>
                           <div class="img_box">
                              <a href="/book/bkDetailView?book_num=${list.bvo.book_num}"> 
                              <img class="book_img" src="/upload/${fn:replace(list.save_dir,'\\','/')}/${list.uuid}_${list.file_name}" alt="bookThumbnail">
                              </a>
                           </div>
                           <div class="info_box">
                              <span class="main_book_header ellipsis-two">${list.bvo.book_title}</span>
                              <span class="main_book_writer">${list.bvo.book_writer} : ${list.bvo.book_publisher}</span>
                           </div>
                        </li>
                     </c:forEach>
                  </ul>
               </div>
            </div>

         </c:when>
         <c:when test="${content eq 'essay'}">

            <div class="hidden">
               <h1>essay top10</h1>
               <div class="BestSeller">
                  <ul class="BestSellerList">
                        <c:forEach items="${book_list}" var="list" varStatus="i" begin="0" end="9">
                        <li class="Best_item">
                           <div class="rank">      
                              <i class="fa-solid fa-${i.count}"></i>
                              <c:if test="${i.count > 9}">
                                 <i class="fa-solid fa-1"></i>
                                 <i class="fa-solid fa-0"></i>
                              </c:if>
                           </div>
                           <div class="img_box">
                              <a href="/book/bkDetailView?book_num=${list.bvo.book_num}"> 
                              <img class="book_img" src="/upload/${fn:replace(list.save_dir,'\\','/')}/${list.uuid}_${list.file_name}" alt="bookThumbnail">
                              </a>
                           </div>
                           <div class="info_box">
                              <span class="main_book_header ellipsis-two">${list.bvo.book_title}</span>
                               <span class="main_book_writer">${list.bvo.book_writer} : ${list.bvo.book_publisher}</span>
                           </div>
                        </li>
                     </c:forEach>
                  </ul>
               </div>
            </div>

         </c:when>
         <c:when test="${content eq 'life'}">

            <div class="hidden">
               <h1>건강/취미 top10</h1>
               <div class="BestSeller">
                  <ul class="BestSellerList">
                        <c:forEach items="${book_list}" var="list" varStatus="i" begin="0" end="9">
                        <li class="Best_item">
                           <div class="rank">      
                              <i class="fa-solid fa-${i.count}"></i>
                              <c:if test="${i.count > 9}">
                                 <i class="fa-solid fa-1"></i>
                                 <i class="fa-solid fa-0"></i>
                              </c:if>
                           </div>
                           <div class="img_box">
                              <a href="/book/bkDetailView?book_num=${list.bvo.book_num}"> 
                              <img class="book_img" src="/upload/${fn:replace(list.save_dir,'\\','/')}/${list.uuid}_${list.file_name}" alt="bookThumbnail">
                              </a>
                           </div>
                           <div class="info_box">
                              <span class="main_book_header ellipsis-two">${list.bvo.book_title}</span>
                              <span class="main_book_writer">${list.bvo.book_writer} : ${list.bvo.book_publisher}</span>
                           </div>
                        </li>
                     </c:forEach>
                  </ul>
               </div>
            </div>

         </c:when>
         <c:when test="${content eq 'computer'}">

            <div class="hidden">
               <h1>컴퓨터/과학 top10</h1>
               <div class="BestSeller">
                  <ul class="BestSellerList">
                        <c:forEach items="${book_list}" var="list" varStatus="i" begin="0" end="9">
                        <li class="Best_item">
                           <div class="rank">      
                              <i class="fa-solid fa-${i.count}"></i>
                              <c:if test="${i.count > 9}">
                                 <i class="fa-solid fa-1"></i>
                                 <i class="fa-solid fa-0"></i>
                              </c:if>
                           </div>
                           <div class="img_box">
                              <a href="/book/bkDetailView?book_num=${list.bvo.book_num}"> 
                              <img class="book_img" src="/upload/${fn:replace(list.save_dir,'\\','/')}/${list.uuid}_${list.file_name}" alt="bookThumbnail">
                              </a>
                           </div>
                           <div class="info_box">
                              <span class="main_book_header ellipsis-two">${list.bvo.book_title}</span>
                              <span class="main_book_writer">${list.bvo.book_writer} : ${list.bvo.book_publisher}</span>
                           </div>
                        </li>
                     </c:forEach>
                  </ul>
               </div>
            </div>

         </c:when>
         <c:when test="${content eq 'problem'}">

            <div class="hidden">
               <h1>문제집 top10</h1>
               <div class="BestSeller">
                  <ul class="BestSellerList">
                        <c:forEach items="${book_list}" var="list" varStatus="i" begin="0" end="9">
                        <li class="Best_item">
                           <div class="rank">      
                              <i class="fa-solid fa-${i.count}"></i>
                              <c:if test="${i.count > 9}">
                                 <i class="fa-solid fa-1"></i>
                                 <i class="fa-solid fa-0"></i>
                              </c:if>
                           </div>
                           <div class="img_box">
                              <a href="/book/bkDetailView?book_num=${list.bvo.book_num}"> 
                              <img class="book_img" src="/upload/${fn:replace(list.save_dir,'\\','/')}/${list.uuid}_${list.file_name}" alt="bookThumbnail">
                              </a>
                           </div>
                           <div class="info_box">
                              <span class="main_book_header ellipsis-two">${list.bvo.book_title}</span>
                              <span class="main_book_writer">${list.bvo.book_writer} : ${list.bvo.book_publisher}</span>
                           </div>
                        </li>
                     </c:forEach>
                  </ul>
               </div>
            </div>

         </c:when>

      </c:choose>
     


      </div>
      <!-- 광고 -->
      <div class="foot-ad">
         <a href="#"> <img src="/resources/img/newYearAD.jpg" alt="하단광고">
         </a>
      </div>
   </div>
   <jsp:include page="./layout/footer.jsp"></jsp:include>
</body>
</html>