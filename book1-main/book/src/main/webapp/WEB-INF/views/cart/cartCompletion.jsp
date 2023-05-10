<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</head>
<body>

	<jsp:include page="../cart/cartHeader.jsp"></jsp:include>
	
	<h2 style="text-align: center">구매완료</h2>

    <table  class="table table hover table-striped text-center"   border="1" style="width: 100%; height: 1cm;">
        <tr>
            <td style="text-align: center; width: 10%">주문날짜</td>
            <td style="text-align: center; width: 8%">주문자</td>
            <td style="text-align: center; width: 40%">주소</td>
            <td style="text-align: center; width: 10%">주문상태</td>
        </tr>
       <c:forEach items="${Plist}" var="pvo">
        <tr>
            <th>${pvo.order_date}</th>
            <th>${pvo.addressee}</th>
            <th>${pvo.order_add2}</th>
            <th><a href="/order/Detail?order_num=${pvo.order_num}">${pvo.order_sta}</a></th>
        </tr>
       </c:forEach>
       
       </table>
	

</body>
</html>