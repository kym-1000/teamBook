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
	
	<h2 style="text-align: center">구매 상세</h2>

    <table  class="table table hover table-striped text-center"   border="1" style="width: 100%; height: 1cm;">
        <tr>
            <td style="text-align: center; width: 10%">책이름</td>
            <td style="text-align: center; width: 8%">권수</td>
            <td style="text-align: center; width: 40%">총가격</td>
        </tr>
       <c:forEach items="${orderDetail}" var="pvo">
        <tr>
            <th>${pvo.book_name}</th>
            <th>${pvo.bookCount}</th>
            <th>${pvo.bookCount * pvo.book_price}</th>
            <th></th>
        </tr>
       </c:forEach>
       
       </table>
	

</body>
</html>