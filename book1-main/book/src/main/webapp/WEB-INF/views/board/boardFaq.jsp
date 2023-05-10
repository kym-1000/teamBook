<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<style>
*{
	text-align: center;
}
.accordion-flush {
	margin: 50px auto;
	width: 500px;
	
}
.accordion-body{
	text-align: left;
}
</style>
</head>
<body>
	<jsp:include page="../layout/header.jsp"></jsp:include>
	<h1>FAQ TOP 10</h1>
	<div class="accordion accordion-flush" id="accordionFlushExample">
		<c:forEach items="${li }" var="faq" varStatus="i" begin="0" end="9">
			<div class="accordion-item">
				<h2 class="accordion-header" id="flush-heading${i.count }">
					<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse${i.count }" aria-expanded="false" aria-controls="flush-collapse${i.count }">${i.count} ${faq.faq_question }</button>
				</h2>
				<div id="flush-collapse${i.count }" class="accordion-collapse collapse" aria-labelledby="flush-heading${i.count }" data-bs-parent="#accordionFlushExample">
					<div class="accordion-body">${faq.faq_answer }</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
</html>