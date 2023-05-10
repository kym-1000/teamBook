<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.noticeBox {
	margin: 0 auto;
	width: 1260px;
}

hr {
	margin: 8px;
}

button {
	margin: 8px;
}

h1 {
	text-align: center;
}

.pagination {
	margin: 0 auto;
	width: 300px;
}

.pagination>a {
	margin: 20px auto;
}

.tableBox {
	width: 900px;
	margin: 0 auto;
}

.tableBox>table {
	text-align: center;
}

table {
	table-layout: fixed;
}

.noticeDetail {
	border: 1px solid gray;
}

.boardDetail-content {
	/* height: 300px; */
	margin: 50px;
}

.boardDetail-regdate {
	font-size: 10px;
	color: gray;
}

.boardDetail-writer {
	font-size: 15px;
	color: gray;
}

.noticeBtnBox>button {
	margin:0 auto;
}
.noticeBtnBox {
    text-align: center;
    margin-bottom: 23px;
}
</style>
</head>
<body>
	<div class="noticeBox">
		<jsp:include page="../layout/header.jsp"></jsp:include>
		<c:forEach items="${content}" var="content">
			<c:choose>
				<c:when test="${content eq 'notice_list'}">
					<h1>공지사항</h1>
					<div class="tableBox tableNormal">
						<table class="table table-hover">
							<thead class="table-dark">
								<tr>
									<th>NO</th>
									<th colspan="2">공지제목</th>
									<th>작성자</th>
									<th>작성일</th>
								</tr>
							</thead>

							<c:forEach items="${notice_list}" var="ntc">
								<tbody>
									<tr>
										<td>${ntc.ntc_num}</td>
										<td colspan="2"><a href="/ntc/noticeDetailOnly?ntc_num=${ntc.ntc_num}">${ntc.ntc_title}</a></td>
										<td>${ntc.ntc_writer}</td>
										<td>${ntc.ntc_regdate}</td>
									</tr>
								</tbody>
							</c:forEach>
						</table>
					</div>
					<div class="pagination">
						<c:if test="${pgh.prev}">
							<a href="/ntc/noticeOnly?pageNo=${pgh.startPage-1}&qty=${pgh.pgvo.qty}"> < </a>
						</c:if>
						<c:forEach begin="${pgh.startPage }" end="${pgh.endPage }" var="i">
							<a href="/ntc/noticeOnly?pageNo=${i}&qty=${pgh.pgvo.qty}">&nbsp ${i} &nbsp</a>
						</c:forEach>
						<c:if test="${pgh.next}">
							<a href="/ntc/noticeOnly?pageNo=${pgh.endPage+1}&qty=${pgh.pgvo.qty}">></a>
						</c:if>
					</div>
				</c:when>

				<c:when test="${content eq 'noticeDetail' }">
					<div class="noticeBox">
						<div class="tableBox noticeDetail">
							<%-- <span class="boardDetail-num">글번호 ${nvo.ntc_num}</span> --%>
							<h2>${nvo.ntc_title}</h2>
							<span class="boardDetail-writer">${nvo.ntc_writer}</span> <span class="boardDetail-regdate">${nvo.ntc_regdate}</span>
							<hr>
							<div class="boardDetail-content">${nvo.ntc_content}</div>

						</div>
						<div class="noticeBtnBox">
							<a href="/ntc/noticeOnly"><Br>
								<button type="button" class="btn btn-outline-secondary">리스트 목록 이동</button> </a> <br>
						</div>
					</div>
				</c:when>
			</c:choose>
		</c:forEach>
	</div>
	<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
</html>