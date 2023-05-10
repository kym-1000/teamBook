<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.main {
   margin: 0 auto;
   width: 1260px;
}

.box {
   width: 550px;
   float: left;
   display: inline-block;
   height: 310px;
   border: 1px solid gray;
   border-top-right-radius: 30px;
   border-bottom-right-radius: 30px;
   margin: 19px 38px
}

.footer {
   display: flow-root;
}

.button {
   float: center;
}

.information {
   display: contents;
}

.right {
   margin-right: 4px;
   width: 290px;
   height: 80%;
   float: right;
   padding-top: 20px;
   text-align: center;
}

.left {
   width: 0 auto;
   /* height: 80%; */
   float: left;
   display: inline-block;
}

.book_img {
   width: 240px;
   height: 295px;
   margin: 7;
}

.btnBox {
   height: 100px;
   margin-top: 30px;
}

.title {
   font-weight: bold;
   font-size: 25px;
   padding-top: 33px;
}

.btnBox button {
   margin-top: 8px;
}

.page {
   margin: 0 auto;
   width: 1260px;
   /* background-color: pink; */
   height: 70px;
   display: flex;
   /* text-align: center; */
   justify-content: center;
   align-items: center;
}
.info{
   padding-top: 50px;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/css/main.css">
</head>
<body>
   <jsp:include page="../layout/header.jsp"></jsp:include>
   <div class="main">

      <c:forEach items="${list}" var="list">
         <div class="box">

            <div class="left">

               <a href="/book/bkDetailView?book_num=${list.bvo.book_num}"> <img class="book_img" src="/upload/${fn:replace(list.save_dir,'\\','/')}/${list.uuid}_${list.file_name}" alt="책표지">
               </a>
            </div>
            <div class="right">
               <div class="title">${list.bvo.book_title}</div><br> 
               <div class="info">글쓴이 : ${list.bvo.book_writer}<br>
                가격 : ${list.bvo.book_price}<br> 
                재고 : ${list.bvo.book_count}<br>
                </div>
             
            </div>
         </div>
      </c:forEach>

      <div class="page">
         <c:if test="${pgh.prev}">
            <a href="/book/search?pageNo=${pgh.startPage-1}&qty=${pgh.pgvo.qty}&type=${pgh.pgvo.type}&keyword=${pgh.pgvo.keyword}">prev</a>
         </c:if>
         <c:forEach begin="${pgh.startPage }" end="${pgh.endPage }" var="i">
            <a href="/book/search?pageNo=${i}&qty=${pgh.pgvo.qty}&type=${pgh.pgvo.type}&keyword=${pgh.pgvo.keyword}">&nbsp ${i} &nbsp</a>
         </c:forEach>
         <c:if test="${pgh.next}">
            <a href="/book/search?pageNo=${pgh.endPage+1}&qty=${pgh.pgvo.qty}&type=${pgh.pgvo.type}&keyword=${pgh.pgvo.keyword}">next</a>
         </c:if>
      </div>
   </div>
   <jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
</html>