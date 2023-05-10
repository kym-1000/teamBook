<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

   #pagetop{

       background-color: khaki;
       font-size: 22px;
      height: 150px;
      width : 100%;
      align-items : center; 
        color: black;
   }
   
   
   #pagetop2{
      padding-right: 160px;
   }
   #pagetop3{
      padding-right: 40px;
   }


</style>
</head>
<body>

   <div id="pagetop">
      <h2 style="text-align: left; font-size: 50px; padding-top: 10px">
         주/문/과/정
      </h2>
      <div style="text-align: right;">
      
      <c:choose >
      <c:when test="${msg eq 1}">
      <div style="color: red;" id="pagetop2">
      <sup>step1</sup>장바구니 
      </div>
      </c:when>
      <c:otherwise>
      <div id="pagetop2">
      <sup>step1</sup>장바구니 
      </div>
      </c:otherwise>
      </c:choose>
            
      <c:choose>
      <c:when test="${msg eq 3}">
      <div style="color: red" id="pagetop3">
      <sup>step2</sup>결제하기
      </div>
      </c:when>
      <c:otherwise>
      <div id="pagetop3">
      <sup>step2</sup>결제하기
      </div>
      </c:otherwise>
      </c:choose>
      
      
      </div>
   </div>

</body>
</html>