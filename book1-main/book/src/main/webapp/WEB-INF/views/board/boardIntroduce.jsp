<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<head>
<meta charset="UTF-8">
<link href="../resources/css/introduce.css" type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../layout/header.jsp"></jsp:include>
		<div class="intro">	
				<a href="/content?content=okay1"><button>개요</button></a>
				<a href="/content?content=okay2"><button>광고안내</button></a>
				<a href="/content?content=okay3"><button>연락처/주소</button></a>		
		</div>
		<div class="main">
		<c:forEach items="${content}" var="content">
			<c:choose>
				<c:when test="${content eq	'okay1' || content == 'main'}">
					<div class="companyIntroduce">
						<img alt="로고" src="/resources/img/logo.jpg"><Br>
					 	'ww'는 when where 의 약자로서 언제든 어디서든 노력한다는 뜻입니다.<br>
					 	'ww'라는 브랜드에는 고객의 꿈을 위해 언제, 어디서든 노력한다는 기업정신이 담겨 있습니다.
					 	<br>
					 	'ww'는 수 없이 많은 새로운 서비스를 전자상거래에 도입하였으며 우리가 도입하면 
					 	 그것이 곧 업계의 표준이 되었습니다. <br>오늘도 'WW'는 혁신을 거듭하며 우리나라 
					 	 전자상거래의 역사를 새롭게 써나가고 있습니다.<br>
					 	 <div class="tableBox">
							<table class="table table-striped">
								<tr>
									<th>회사명</th>
									<td>(주)WW</td>
								</tr>
								<tr>
									<th>대표이사</th>
									<td>ABC</td>
								</tr>
								<tr>
									<th>소재지</th>
									<td>인천광역시 남동구 구월 5415</td>
								</tr>
								<tr>
									<th>사업자 등록번호</th>
									<td>123-45-67890</td>
								</tr>
								<tr>
									<th>통신판매업 신고번호</th>
									<td>2023-인천-00000</td>
								</tr>
								<tr>
									<th>개인정보관리 책임자</th>
									<td>ezen</td>
								</tr>
								<tr>
									<th>대량주문</th>
									<td>abc@ezen.ww.kr</td>
								</tr>
							</table>
						</div>
					</div>
				</c:when>
				<c:when test="${content eq	'okay2'}"></c:when>
				<c:when test="${content eq	'okay3'}">
					<div class="companyNumAndAddress">
<pre>
WW 본사에서는 도서를 직접 판매하는 매장이 없으며, 온라인에서 주문하신 도서를 직접 찾아가실 수도 없습니다.
오프라인 중고 매장을 찾으시는 경우에는 중고매장 리스트를 참고하시기 바랍니다.
							
							
주소
도로명 : 인천 남동구 구월 5415
지번 : 구월동 1400-00
							
찾아오는 길
[지하철]
인천 2호선 예술회관역 2번 출구로 나와서 20m 직진
인천 1호선 인천시청역 5번 출구로 나와서 500m 직진, 좌회전 200m
[버스]
예술회관 하차
파랑버스 (간선) : 42, 45
초록버스 (지선) : 534, 순환56
* 고객님의 배송 및 이용 문의는 고객지원센터 전화 (지역번호 없이)
  1544-2514 또는 1:1 문의를 이용해주십시오.
</pre>
				 	</div>
				</c:when>
			</c:choose>
		</c:forEach>
	</div>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
</html>