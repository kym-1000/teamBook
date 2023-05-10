<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link href="/resources/css/bookDetailView.css" rel="stylesheet" /> 
<style>
.intro {
	display: -webkit-box;
	word-wrap: break-word;
	-webkit-line-clamp: 3;
	-webkit-box-orient: vertical;
	overflow: hidden;
	text-overflow: ellipsis;
	line-height: 18px;
	height: 54px;
	text-decoration: none;
}

.bookDetail {
	width: 1260px;
	margin: 0 auto;
	display: flex;
	flex-direction: column;
	align-items: center;
}

.title {
	margin: 0 auto;
	width: 1260px;
	height: 100px;
	font-size: 40px;
	text-align: center;
}

.seoji, .infoEtc {
	width: 300px;
}

.infoEtc {
	    padding: 136px 0px;
    text-align: center;
}

.seoji {
	text-align: center;
	margin: 85px auto;
}

.intro {
	width: 600px;
}

.detail {
	width: 1000px;
	margin: 30px;
}

.review {
	
}

.detailViewBox {
	display: flex;
	width: 1000px;
	justify-content: space-between;
}

.arrow {
	display: flex;
	flex-direction: column;
}

img.upArrow, img.downArrow {
	width: 20px;
}

.qty {
	display: flex;
	flex-direction: row;
	justify-content: center;
}

.qty > input {
	height: 20px;
	width: 40px;
	margin: 15px 7px;
	text-align: right;
}

.qty > span {
	margin: 13px 0;
}

hr {
	width: 1260px;
}

#rightBoxHr {
	width: 300px;
}

.book_img {
	width: 400px;
	height: 450px;
}

textarea#reviewContents {
	width: 1000px;
}

button#revPostBtn:hover {
	background-color: #80808042;
}

button#revPostBtn {
	border-radius: 8px;
	background-color: white;
	border: 1px solid gray;
}

#cmtListArea {
	margin-bottom: 40px;
}

#writer {
	font-size: 35px;
}

#rightBoxHr {
	width: 285px;
	margin: 20px auto;
}

span#price {
	font-size: 45px;
}
.bcc{
   border-style: groove;
   width: 80px;
   height: 40px;
   line-height:40px;
}

.susu{
   margin-right: 20px;
   margin-top: 20px;
}
.btnBox {
    float: right;
    padding-right: 5px;
}
</style>
</head>

<body>
	<jsp:include page="../layout/header.jsp"></jsp:include>
	<div class="bookDetail">
		<div class="title">${bvo.book_title}</div>

			<div class="detailViewBox">
				<div class="infoEtc">
					<span id="writer">${bvo.book_writer}</span><br> <span>${bvo.book_publisher}</span>
					<spna>${bvo.book_date}</spna>
				</div>
				<div class="pyoji">
					<img class="book_img" src="/upload/${fn:replace(fList[0].save_dir,'\\','/')}/${fList[0].uuid}_${fList[0].file_name}" alt="bookThumbnail">
					<%-- <img src="/upload/${fn:replace(book.save_dir,'\\','/')}/${book.uuid}_${book.file_name} style="list-style: none;" alt="사진"> --%>
				</div>
				<div class="seoji">
					<%-- 원가 ${bvo.book_price}원<br> 판매가 ${bvo.book_saleprice}원 --%>
					<span id="price">${bvo.book_price}원</span>
					<hr id="rightBoxHr">
					<div class="qty">
						<!-- <span>수량</span>
						 <input type="number" name="book_count" min="1" value="1">
						  <div id="book_cnt">1</div>
						<div class="arrow">
							<a href="#"><img type="button" onclick='count("plus")' src="/resources/img/upArrow.png" class="upArrow" alt="upArrow"></a> 
							<a href="#"><img type="button" onclick='count("minus")' src="/resources/img/downArrow.png" class="downArrow" alt="downArrow"></a><br> <br>
							
						</div> -->
						 <div class="susu">수량</div>
                    <span class="bcc" id="book_cnt">1</span>
                  <div class="arrow">
                     <img onclick='count("plus")' src="/resources/img/upArrow.png" class="upArrow" alt="upArrow" style="width: 35px">
                     <img onclick='count("minus")' src="/resources/img/downArrow.png" class="downArrow" alt="downArrow" style="width: 35px"><br> <br>
                  </div>
					</div>
					
					<input type="hidden" id="mem_num" value="${ses.mem_num}">
					<input type="hidden" id="book_num" value="${bvo.book_num}">
					<div class="btnBox">
					<!-- 	<button type="button" class="btn btn-secondary">장바구니 담기</button>
						<button type="button" class="btn btn-success">바로구매</button> -->
						<!-- 로그인이 되었을때 -->
            <c:if test="${ses.mem_id !=null}">
			<button type="button" class="btn btn-secondary" id="Cart_btn" >장바구니</button>
			</c:if>
			
			<c:if test="${ses.mem_id != null}">
			<button type="button" class="btn btn-success" id="Purchase_btn" >바로구매</button>
				
			</c:if>
			<!-- 로그인 되지 않았을때 -->
			<c:if test="${ses.mem_id == null}">
					<button type="button" class="btn btn-secondary">
					<a href="/mem/loginPage" onclick="gologin(event)" style="color: white;">장바구니</a></button>
			</c:if>
			
			<c:if test="${ses.mem_id == null}">
			<button type="button" class="btn btn-success">
					<a href="/mem/loginPage" onclick="gologin(event)" style="color: white;">바로구매</a>
					</button>
			</c:if>
					
					</div>
				</div>
			</div>

					<input type="hidden" id="book_inventory" value="${bvo.book_count}">
		<br>


		<hr>

		<div class="detail">${bvo.book_content}</div>
		<div class="review">
			<form class="mb-3" name="myform" id="myform" method="post">
				<fieldset>
					<span class="text-bold">별점을 선택해주세요</span> <input type="radio" name="review_rating" value="5" id="rate1"> <label for="rate1">★</label> <input type="radio" name="review_rating" value="4" id="rate2"> <label for="rate2">★</label> <input type="radio" name="review_rating" value="3" id="rate3"> <label for="rate3">★</label> <input type="radio" name="review_rating" value="2" id="rate4"> <label for="rate4">★</label> <input type="radio" name="review_rating" value="1" id="rate5"> <label for="rate5">★</label>
				</fieldset>
				<div class="reviewBox">
					<span class="input-group-text" id="revWriter">${ses.mem_id }</span>
					<textarea class="col-auto form-control" name="review_content" id="reviewContents" placeholder="좋은 감상평을 남겨주시면 저자에게 큰 힘이 됩니다!"></textarea>
					<br> <span>${review_mem_id }</span>
					<span class="btnBox">
					<button type="button" id="revPostBtn" name="revPostBtn">리뷰등록</button></span>
				</div>
			</form>
			<div id="cmtListArea"></div>
		</div>
	</div>
	
	<script type="text/javascript">
		const revVal = '<c:out value="${bvo.book_num }" />';
		console.log(revVal);
	</script>
	<script type="text/javascript" src="/resources/js/reviewComment.js"></script>
	<script type="text/javascript" src="/resources/js/bookDetailCnt.js"></script>
	<script type="text/javascript">
		getReviewList(revVal);
	</script>

	<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>

</html>