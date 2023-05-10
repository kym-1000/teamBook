<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>

<head>

<link rel="stylesheet" type="text/css" href="/resources/css/adminpage.css">
<link rel="stylesheet" type="text/css" href="/resources/css/adminBoardDetail.css">
<link rel="stylesheet" type="text/css" href="/resources/css/adminpageNotice.css">
<link rel="stylesheet" type="text/css" href="/resources/css/adminpageProduct.css">
<link rel="stylesheet" type="text/css" href="/resources/css/mypageBuyList.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

<style type="text/css">
a {
	text-decoration: none;
	color: black;
	text-transform: none;
}

.pagination {
	margin: 0 auto;
	width: 300px;
}

.pagination>a {
	margin: 20px auto;
}

.col-sm-12 {
	margin: 30px auto;
}

.tableBoxBig td {
	line-height: 97px;
}
/* .adminPageImg{
	background-image: url("/resources/img/adminPageImg.png");
	background-size: cover;
	width:500px;
	height: 500px;
} */
</style>
</head>

<body>
	<script type="text/javascript">
		const ses = '<c:out value="${ses.mem_id}" />';
		if (ses == null || ses == '') {
			alert('로그인시 이용가능합니다. 메인 페이지로 이동합니다.');
			location.href = '/';
		}
	</script>
	<div class="main">
		<div class="menu">
			<div class="menu_logo">
				<a href="/"> <img src="/resources/img/logo.jpg" alt="로고" id="logo"></a>
			</div>
			<div class="menu_wrap">
				<ul class="de01">

					<li><a href="/admin/memList">회원관리</a>
						<ul class="de02">
							<li><a href="/admin/memList">리스트</a></li>
						</ul></li>
					<li><a href="/ntc/noticeList">공지사항</a>
						<ul class="de02">
							<li><a href="/ntc/noticeList">리스트</a></li>
							<li><a href="/ntc/noticeRegister">등록</a></li>
						</ul></li>
					<li><a href="/faq/faqList">FAQ</a>
						<ul class="de02">
							<li><a href="/faq/faqList">리스트</a></li>
							<li><a href="/faq/faqReg">등록</a></li>
						</ul></li>
					<li><a href="/admin/list">1대1문의</a>
						<ul class="de02">
							<li><a href="/admin/list">리스트</a></li>
						</ul></li>
					<li><a href="/book/list">상품관리</a>
						<ul class="de02">
							<li><a href="/book/list">리스트</a></li>
							<li><a href="/book/bkRegister">등록</a></li>
						</ul></li>
					<li><a href="/mem/logOut">로그아웃</a></li>
				</ul>
			</div>

			<!-- <div class="adminPageImg">
				
			</div> -->
		</div>
		<div>
			<c:forEach items="${category}" var="category">
				<c:forEach items="${content}" var="content">
					<c:choose>
						<c:when test="${category eq 'member'}">
							<h1>회원관리</h1>
							<div class="tableBox tableNormal">
								<table class="table table-hover">
									<thead class="table-dark">
										<tr>
											<th>회원번호</th>
											<th>아이디</th>
											<th>이름</th>
											<th>가입일자</th>
											<th>회원탈퇴</th>
										</tr>
									</thead>
									<c:forEach items="${memLi }" var="ad">
										<tbody>
											<tr>
												<td>${ad.mem_num }</td>
												<td>${ad.mem_id }</td>
												<td>${ad.mem_name }</td>
												<td>${ad.mem_date }</td>
												<td><a href="/admin/memRemove?mem_num=${ad.mem_num }">탈퇴</a></td>
											</tr>
										</tbody>
									</c:forEach>
								</table>
							</div>
							<div class="pagination">
								<c:if test="${pgh.prev}">
									<a href="/admin/memList?pageNo=${pgh.startPage-1}&qty=${pgh.pgvo.qty}"> < </a>
								</c:if>
								<c:forEach begin="${pgh.startPage }" end="${pgh.endPage }" var="i">
									<a href="/admin/memList?pageNo=${i}&qty=${pgh.pgvo.qty}">&nbsp ${i} &nbsp</a>
								</c:forEach>
								<c:if test="${pgh.next}">
									<a href="/admin/memList?pageNo=${pgh.endPage+1}&qty=${pgh.pgvo.qty}"> > </a>
								</c:if>
							</div>

							<!-- search -->

							<div class="col-sm-12 col-md-6">
								<form action="/admin/memList" method="get">
									<div class="input-group mb-3">
										<!-- 값을 별도 저장 -->
										<c:set value="${pgh.pgvo.type}" var="typed" />
										<select class="form-select" name="type" style="height: 50px; width: 30px;">
											<option ${typed==null ? 'selected' :'' }>항목</option>
											<option value="t" ${typed eq 't' ? 'selected' :'' }>아이디</option>
											<option value="c" ${typed eq 'c' ? 'selected' :'' }>이름</option>
										</select> <input class="form-control" type="text" name="keyword" placeholder="포함해서찾기" value="${pgh.pgvo.keyword }" style="height: 50px;"> <input type="hidden" name="pageNo" value="1"> <input type="hidden" name="qty" value="${pgh.pgvo.qty }">
										<button type="submit" class="btn btn-success position-relative" style="height: 50px; margin-top: 0px">
											결과 <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger"> ${pgh.totalCount}개 <span class="visually-hidden">unread messages</span>
											</span>
										</button>
									</div>
								</form>
							</div>
						</c:when>


						<c:when test="${category eq 'notice'}">
							<c:choose>
								<c:when test="${content eq 'notice_list'}">
									<h1>공지사항 관리</h1>
									<div class="tableBox tableNormal">
										<table class="table table-hover">
											<thead class="table-dark">
												<tr>
													<th>NO</th>
													<th>공지제목</th>
													<th>작성자</th>
													<th>작성일</th>
												</tr>
											</thead>

											<c:forEach items="${notice_list}" var="ntc">
												<tbody>
													<tr>
														<td>${ntc.ntc_num}</td>
														<td class="ellipsis-one"><a href="/ntc/noticeDetail?ntc_num=${ntc.ntc_num}">${ntc.ntc_title}</a></td>
														<td>${ntc.ntc_writer}</td>
														<td>${ntc.ntc_regdate}</td>
													</tr>
												</tbody>
											</c:forEach>
										</table>
									</div>
									<div class="pagination">
										<c:if test="${pgh.prev}">
											<a href="/ntc/noticeList?pageNo=${pgh.startPage-1}&qty=${pgh.pgvo.qty}"> < </a>
										</c:if>
										<c:forEach begin="${pgh.startPage }" end="${pgh.endPage }" var="i">
											<a href="/ntc/noticeList?pageNo=${i}&qty=${pgh.pgvo.qty}">&nbsp ${i} &nbsp</a>
										</c:forEach>
										<c:if test="${pgh.next}">
											<a href="/ntc/noticeList?pageNo=${pgh.endPage+1}&qty=${pgh.pgvo.qty}">></a>
										</c:if>
									</div>
									<form action="/ntc/noticeList" method="get">
										<div class="input-group mb-3">
											<!-- 값을 별도 저장 -->
											<c:set value="${pgh.pgvo.type}" var="typed" />
											<select class="form-select" name="type" style="height: 50px; width: 30px;">
												<option ${typed==null ? 'selected' :'' }>항목</option>
												<option value="t" ${typed eq 't' ? 'selected' :'' }>공지제목</option>
												<option value="c" ${typed eq 'c' ? 'selected' :'' }>내용</option>
												<option value="w" ${typed eq 'w' ? 'selected' :'' }>작성자</option>
											</select> <input class="form-control" type="text" name="keyword" placeholder="포함해서찾기" value="${pgh.pgvo.keyword }" style="height: 50px;"> <input type="hidden" name="pageNo" value="1"> <input type="hidden" name="qty" value="${pgh.pgvo.qty }">
											<button type="submit" class="btn btn-success position-relative" style="height: 50px; margin-top: 0px">
												결과 <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger"> ${pgh.totalCount}개 <span class="visually-hidden">unread messages</span>
												</span>
											</button>
										</div>
									</form>


								</c:when>
								<c:when test="${content eq 'noticeRegister' }">
									<h1>공지사항 등록</h1>
									<div class="boardRegisterBox">
										<form action="/ntc/noticeRegister" method="post">
											<div class="brd_titleAndWriter">
												<label for="ntc_title">제목</label> <input type="text" name="ntc_title" class="ntc_title" required> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <label for="ntc_title">작성자</label> <input type="text" name="ntc_writer" value="${ses.mem_id}" readonly><br>
											</div>
											<div class="contentBox">
												<label for="ntc_content" class="contentLabel">내용</label><br>
												<textarea rows="10" cols="100" name="ntc_content"></textarea>
												<br>
											</div>

											<button type="submit" class="btn btn-secondary">작성하기</button>
										</form>
									</div>

								</c:when>
								<c:when test="${content eq 'noticeDetail' }">
									<div class="mypage-right boardDetail tableNormal noticeDetail">
										글번호 ${nvo.ntc_num}
										<h2>${nvo.ntc_title}</h2>
										<sapn class="boardDetail-writer">${nvo.ntc_writer}</sapn>
										<span class="boardDetail-regdate">${nvo.ntc_regdate}</span>
										<hr>
										<div class="boardDetail-content">${nvo.ntc_content}</div>
										<Br> <a href="/ntc/noticeModify?ntc_num=${nvo.ntc_num}">
											<button type="button" class="btn btn-success">수정</button>
										</a> <a href="/ntc/noticeDelete?ntc_num=${nvo.ntc_num}">
											<button type="button" class="btn btn-danger">삭제</button>
										</a><a href="/ntc/notice"><Br>
											<button type="button" class="btn btn-outline-secondary">목록</button> </a> <br>

									</div>





								</c:when>
								<c:when test="${content eq 'noticeModify' }">
									<h1>공지사항 수정</h1>
									<div class="boardRegisterBox">
										<form action="/ntc/noticeModify" method="post">
											<div class="brd_titleAndWriter">
												<label for="ntc_title">제목</label> <input type="text" name="ntc_title" class="ntc_title" value="${nvo.ntc_title}" required> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <label for="ntc_title">작성자</label> <input type="text" name="ntc_writer" value="${nvo.ntc_writer}" readonly><br>
											</div>
											<div class="contentBox-Input">
												<label for="ntc_content" class="contentLabel">내용</label><br>
												<%-- <input type="text" name="ntc_content" value="${nvo.ntc_content}">  --%>
												<br>
												<textarea rows="10" cols="100" name="ntc_content">${nvo.ntc_content}</textarea>
											</div>

											<button type="submit" class="btn btn-secondary">수정완료</button>
											<a href="/ntc/noticeList"><button type="button" class="btn btn-secondary">목록</button></a>
										</form>
									</div>
								</c:when>
							</c:choose>
						</c:when>


						<c:when test="${category eq 'faq'}">
							<c:choose>

								<c:when test="${content eq 'faqList' }">
									<h1>FAQ 관리</h1>
									<div class="tableBox tableNormal">
										<table class="table table-hover">
											<thead class="table-dark">
												<tr>
													<th>공지사항 번호</th>
													<th colspan="2">질문</th>
													<th>답변</th>

												</tr>

											</thead>
											<tbody>
												<c:forEach items="${li }" var="faq">
													<tr>
														<td class="ellipsis-one">${faq.faq_num }</td>
														<td colspan="2"><a href="/faq/faqDetail?faq_num=${faq.faq_num}">${faq.faq_question
																			}</a></td>
														<td class="ellipsis-one">${faq.faq_answer }</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
									<div class="pagination">
										<c:if test="${pgh.prev}">
											<a href="/faq/faqList?pageNo=${pgh.startPage-1}&qty=${pgh.pgvo.qty}"> << /a> 
										</c:if>
										<c:forEach begin="${pgh.startPage }" end="${pgh.endPage }" var="i">
											<a href="/faq/faqList?pageNo=${i}&qty=${pgh.pgvo.qty}">&nbsp ${i} &nbsp</a>
										</c:forEach>
										<c:if test="${pgh.next}">
											<a href="/faq/faqList?pageNo=${pgh.endPage+1}&qty=${pgh.pgvo.qty}">></a>
										</c:if>
									</div>

									<div class="col-sm-12 col-md-6">
										<form action="/faq/faqList" method="get">
											<div class="input-group mb-3">
												<!-- 값을 별도 저장 -->
												<c:set value="${pgh.pgvo.type}" var="typed" />
												<select class="form-select" name="type" style="height: 50px; width: 30px;">
													<option ${typed==null ? 'selected' :'' }>항목</option>
													<option value="t" ${typed eq 't' ? 'selected' :'' }>질문</option>
													<option value="c" ${typed eq 'c' ? 'selected' :'' }>답변</option>

												</select> <input class="form-control" type="text" name="keyword" placeholder="포함해서찾기" value="${pgh.pgvo.keyword }" style="height: 50px;"> <input type="hidden" name="pageNo" value="1"> <input type="hidden" name="qty" value="${pgh.pgvo.qty }">
												<button type="submit" class="btn btn-success position-relative" style="height: 50px; margin-top: 0px">
													결과 <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger"> ${pgh.totalCount}개 <span class="visually-hidden">unread messages</span>
													</span>
												</button>
											</div>
										</form>
									</div>
								</c:when>
								<c:when test="${content eq 'faqRegister' }">
									<h1>FAQ 등록</h1>
									<div class="boardRegisterBox">
										<form action="/faq/faqReg" method="post">
											<div class="brd_titleAndWriter">
												<label for="faq_question">질문</label> <input type="text" name="faq_question" class="faq_question" style="width: 763px" required> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp

											</div>
											<div class="contentBox">
												<label for="faq_answer" class="contentLabel">답변</label><br>
												<textarea rows="10" cols="100" name="faq_answer"></textarea>
												<br>
											</div>

											<button type="submit" class="btn btn-secondary">작성하기</button>
										</form>
									</div>


								</c:when>
								<c:when test="${content eq 'faqDetail' }">
									<div class="mypage-right boardDetail tableNormal noticeDetail">
										글번호 ${fo.faq_num }
										<h2>${fo.faq_question }</h2>

										<hr>
										<div class="boardDetail-content">${fo.faq_answer }</div>
										<Br> <a href="/faq/faqModify?faq_num=${fo.faq_num}">
											<button type="button" class="btn btn-success">수정</button>
										</a> <a href="/faq/faqRemove?faq_num=${fo.faq_num}">
											<button type="button" class="btn btn-danger">삭제</button>
										</a><a href="/faq/faqList"><Br>
											<button type="button" class="btn btn-outline-secondary">목록</button> </a> <br>

									</div>




								</c:when>
								<c:when test="${content eq 'faqModify' }">
									<h1>FAQ 수정</h1>
									<div class="boardRegisterBox">
										<form action="/faq/faqModify?faq_num=${fo.faq_num }" method="post">
											<div class="brd_titleAndWriter">
												<label for="faq_question">질문</label> <input type="text" name="faq_question" class="faq_question" value="${fo.faq_question }" style="width: 763px" required> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp

											</div>
											<div class="contentBox-Input">
												<label for="faq_answer" class="contentLabel">답변</label><br> <input name="faq_answer" value="${fo.faq_answer }"> <br>
											</div>

											<button type="submit" class="btn btn-secondary">수정하기</button>
										</form>
									</div>





								</c:when>
							</c:choose>
						</c:when>

						<c:when test="${category eq 'mantoman'}">
							<c:choose>

								<c:when test="${content eq 'boardList' }">
									<h1>1대1 문의 관리</h1>
									<div class="tableBox tableNormal">
										<table class="table table-hover">

											<thead class="table-dark">
												<tr>
													<th scope="col">글번호</th>
													<th scope="col">제목</th>
													<th scope="col">카테고리</th>
													<th scope="col">글쓴이</th>
													<th scope="col">작성일자</th>

												</tr>
											</thead>


											<c:forEach items="${list}" var="board">
												<c:choose>
													<c:when test="${ses.mem_auth == '0'|| ses.mem_id == board.brd_writer}">
														<tbody>
															<tr>
																<td scope="row">${board.brd_num}</td>
																<td><a href="/admin/boardDetail?brd_num=${board.brd_num}">${board.brd_title}</a></td>
																<td>${board.brd_category}</td>
																<td>${board.brd_writer}</td>
																<td>${board.brd_regdate}</td>


															</tr>
														</tbody>
													</c:when>

													<c:otherwise>
														<tr>
															<td>${board.brd_num}</td>
															<td><c:choose>
																	<c:when test="${ses.mem_id eq board.brd_writer}">
																					${board.brd_title}
																				</c:when>
																	<c:otherwise>
																					${board.brd_title}
																				</c:otherwise>
																</c:choose></td>
															<td>${board.brd_category}</td>
															<c:choose>
																<c:when test="${ses.mem_id eq board.brd_writer}">
																	<td>${board.brd_writer}</td>
																</c:when>
																<c:otherwise>
																	<td>******</td>
																</c:otherwise>
															</c:choose>
															<td>${board.brd_regdate}</td>
															<td>${board.brd_views}</td>
														</tr>
													</c:otherwise>
												</c:choose>
											</c:forEach>


										</table>
									</div>
									<div class="pagination">
										<c:if test="${pgh.prev}">
											<a href="/admin/list?pageNo=${pgh.startPage-1}&qty=${pgh.pgvo.qty}&type=${pgh.pgvo.type}&keyword=${pgh.pgvo.keyword}">prev</a>
										</c:if>
										<c:forEach begin="${pgh.startPage }" end="${pgh.endPage }" var="i">
											<a href="/admin/list?pageNo=${i}&qty=${pgh.pgvo.qty}&type=${pgh.pgvo.type}&keyword=${pgh.pgvo.keyword}">&nbsp ${i} &nbsp</a>
										</c:forEach>
										<c:if test="${pgh.next}">
											<a href="/admin/list?pageNo=${pgh.endPage+1}&qty=${pgh.pgvo.qty}&type=${pgh.pgvo.type}&keyword=${pgh.pgvo.keyword}">next</a>
										</c:if>
									</div>
									<!-- search -->

									<div class="col-sm-12 col-md-6">
										<form action="/admin/list" method="get">
											<div class="input-group mb-3">
												<!-- 값을 별도 저장 -->
												<c:set value="${pgh.pgvo.type}" var="typed" />
												<select class="form-select" name="type" style="height: 50px; width: 30px;">
													<option ${typed==null ? 'selected' :'' }>항목</option>
													<option value="t" ${typed eq 't' ? 'selected' :'' }>제목</option>
													<option value="c" ${typed eq 'c' ? 'selected' :'' }>내용</option>
													<option value="w" ${typed eq 'w' ? 'selected' :'' }>작성자</option>
												</select> <input class="form-control" type="text" name="keyword" placeholder="포함해서찾기" value="${pgh.pgvo.keyword }" style="height: 50px;"> <input type="hidden" name="pageNo" value="1"> <input type="hidden" name="qty" value="${pgh.pgvo.qty }">
												<button type="submit" class="btn btn-success position-relative" style="height: 50px; margin-top: 0px">
													결과 <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger"> ${pgh.totalCount}개 <span class="visually-hidden">unread messages</span>
													</span>
												</button>
											</div>
										</form>
									</div>


								</c:when>

								<c:when test="${content eq 'boardDetail' }">
									<div class="mypage-right boardDetail tableNormal">
										글번호 ${board.brd_num}
										<h2>${board.brd_title}</h2>
										<sapn class="boardDetail-writer">${board.brd_writer}</sapn>
										<span class="boardDetail-regdate">${board.brd_regdate}</span>
										<hr>
										<div class="boardDetail-content">${board.brd_content}</div>
										<Br> </a> <a href="/admin/boardRemove?brd_num=${board.brd_num}">
											<button type="button" class="btn btn-danger">삭제</button>
										</a><a href="/admin/list"><Br>
											<button type="button" class="btn btn-outline-secondary">목록</button> </a> <br>

										<div class="container">
											<div class="input-group my-3">
												<span class="input-group-text" id="cmtWriter">${ses.mem_id}</span> <input type="text" class="form-control" id="cmtText" placeholder="Test Add Comment ">
												<button class="btn btn-success" id="cmtPostBtn" type="button">Post</button>
											</div>
											<ul class="list-group list-group-flush" id="cmtListArea">
												<li class="list-group-item d-flex justify-content-between align-items-start">
													<div class="ms-2 me-auto">
														<div class="fw-bold">Writer</div>
														Content for Comment
													</div> <span class="badge bg-dark rounded-pill">modAt</span>
												</li>
											</ul>
										</div>


										<script type="text/javascript">
											const bnoVal = '<c:out value="${board.brd_num}" />';

											const auth = '<c:out value="${ses.mem_auth}"/>';

											console.log(auth);
											console.log(bnoVal);
										</script>
										<script type="text/javascript" src="/resources/js/boardComment.js"></script>
										<script type="text/javascript">
											getCommentList(bnoVal, auth);
										</script>
									</div>

								</c:when>

							</c:choose>

						</c:when>

						<c:when test="${category eq 'product'}">
							<c:choose>
								<c:when test="${content eq 'bookList' }">
									<h1>상품 관리</h1>
									<div class="tableBoxBig">
										<table class="table table-hover tableBig">
											<thead class="table-dark">
												<tr>
													<th>책번호</th>
													<th>썸네일</th>
													<th colspan="2">책제목</th>
													<th>저자</th>
													<th>정상가격</th>
													<th>할인가격</th>
													<th>판매량</th>
													<th>출판사</th>
													<th>출판일</th>
													<th>수량</th>
													<!-- <th>책내용</th> -->
													<th>카테고리</th>
													<th colspan="2">control</th>
												</tr>
											</thead>
											<c:forEach items="${li }" var="bo">
												<tbody>
													<tr>
														<td>${bo.bvo.book_num }</td>
														<td><img src="/upload/${fn:replace(bo.save_dir,'\\','/')}/${bo.uuid}_th_${bo.file_name}" alt="bookThumbnail"></td>
														<td class="ellipsis-one" colspan="2">${bo.bvo.book_title }</td>
														<td class="ellipsis-one">${bo.bvo.book_writer }</td>
														<td>${bo.bvo.book_price }</td>
														<td>${bo.bvo.book_saleprice }</td>
														<td>${bo.bvo.book_sales }</td>
														<td class="ellipsis-one">${bo.bvo.book_publisher }</td>
														<td>${bo.bvo.book_date }</td>
														<td>${bo.bvo.book_count }</td>
														<%-- <td class="ellipsis-one">${bo.bvo.book_content
																		}</td> --%>
														<td>${bo.bvo.book_cno }</td>
														<td colspan="2">
															<div class="btn-group btn-group-sm" role="group" aria-label="Small button group">
																<a href="/book/detail?book_num=${bo.bvo.book_num }">
																	<button type="button" class="btn btn-outline-dark">view</button>
																</a><br> <a href="/book/bkRemove?book_num=${bo.bvo.book_num }">
																	<button type="button" class="btn btn-outline-dark">Delete</button>
																</a>
															</div>

														</td>
													</tr>
												</tbody>
											</c:forEach>
										</table>
									</div>



									<div class="pagination">
										<c:if test="${pgn.prev}">
											<a href="/book/list?pageNo=${pgn.startPage-1}&qty=${pgn.pgvo.qty}">&nbsp<&nbsp</a>
										</c:if>
										<c:forEach begin="${pgn.startPage }" end="${pgn.endPage }" var="i">
											<a href="/book/list?pageNo=${i}&qty=${pgn.pgvo.qty}">&nbsp ${i} &nbsp</a>
										</c:forEach>
										<c:if test="${pgn.next}">
											<a href="/book/list?pageNo=${pgn.endPage+1}&qty=${pgn.pgvo.qty}">&nbsp>&nbsp</a>
										</c:if>
									</div>
									<div class="col-sm-12 col-md-6">
										<form action="/book/list" method="get">
											<div class="input-group mb-3">
												<!-- 값을 별도 저장 -->
												<c:set value="${pgn.pgvo.type}" var="typed" />
												<select class="form-select" name="type" style="height: 50px; width: 30px;">
													<option ${typed==null ? 'selected' :'' }>항목</option>
													<option value="t" ${typed eq 't' ? 'selected' :'' }>책제목</option>
													<option value="c" ${typed eq 'c' ? 'selected' :'' }>저자</option>
													<option value="w" ${typed eq 'w' ? 'selected' :'' }>출판사</option>
												</select> <input class="form-control" type="text" name="keyword" placeholder="포함해서찾기" value="${pgn.pgvo.keyword }" style="height: 50px;"> <input type="hidden" name="pageNo" value="1"> <input type="hidden" name="qty" value="${pgn.pgvo.qty }">
												<button type="submit" class="btn btn-success position-relative" style="height: 50px; margin-top: 0px">
													결과 <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger"> ${pgh.totalCount}개 <span class="visually-hidden">unread messages</span>
													</span>
												</button>
											</div>
										</form>
									</div>

									<!-- <a href="/book/bkRegister">
										<button type="button" class="btn btn-outline-dark">상품등록</button>
									</a> -->
								</c:when>

								<c:when test="${content eq 'bookDetail' }">

									<div class="tableBox tableNormal">

										<table border="1" class="table table-hover trBorder">
											<tr>
												<th>책제목</th>
												<td>${bo.book_title }</td>
											</tr>
											<tr>
												<th>저자</th>
												<td>${bo.book_writer }</td>
											</tr>
											<tr>
												<th>정상가격</th>
												<td>${bo.book_price }</td>
											</tr>
											<tr>
												<th>할인가격</th>
												<td>${bo.book_saleprice }</td>
											</tr>
											<tr>
												<th>판매량</th>
												<td>${bo.book_sales }</td>
											</tr>
											<tr>
												<th>출판사</th>
												<td>${bo.book_publisher }</td>
											</tr>

											<tr>
												<th>출판일</th>
												<td>${bo.book_date }</td>
											</tr>
											<tr>
												<th>수량</th>
												<td>${bo.book_count }</td>
											</tr>
											<tr>
												<th>책내용</th>
												<td><textarea rows="5" cols="50" readonly="readonly">${bo.book_content }</textarea></td>
											</tr>
											<tr>
												<th>카테고리</th>
												<td>${bo.book_cno }</td>
											</tr>
											<tr>
												<th>책사진</th>
												<td>
													<!-- file 표현라인 -->
													<div>
														<ul style="list-style: none;">
															<!-- c:if 파일이 없으면 첨부 File이 없습니다. 출력 -->
															<c:forEach items="${fList }" var="fvo">
																<!-- 파일이 여러개 일 때 반복적으로 li 추가 -->
																<li><c:choose>
																		<c:when test="${fvo.file_type > 0 }">
																			<div>
																				<!--D:~fileUpload/2022/12/28/dog.jpg -->
																				<img src="/upload/${fn:replace(fvo.save_dir,'\\','/')}/${fvo.uuid}_th_${fvo.file_name}" style="list-style: none;">
																			</div>
																		</c:when>
																		<c:otherwise>
																			<div>
																				<!-- 파일모양 아이콘을 넣어서 일반 파일임을 표현하면 됨. -->
																			</div>
																		</c:otherwise>
																	</c:choose> <!-- 파일이름, 등록일, 사이즈 -->
																	<div>
																		<br>
																		<div>${fvo.file_name }</div>
																	</div></li>
															</c:forEach>
														</ul>
													</div>

												</td>
											</tr>
										</table>
										<a href="/book/bkModify?book_num=${bo.book_num}"><button type="button" class="btn btn-outline-secondary">책 수정</button></a>
									</div>
								</c:when>
								<c:when test="${content eq 'bookRegister' }">
									<h1>상품등록</h1>
									<div class="tableBox tableNormal">
										<form action="/book/bkRegister" method="post" enctype="multipart/form-data">
											<table border="1" class="table table-hover trBorder">
												<tr>
													<td>책제목</td>
													<td><input type="text" name="book_title"></td>
												</tr>
												<tr>
													<td>작가</td>
													<td><input type="text" name="book_writer"></td>
												</tr>
												<tr>
													<td>출판사</td>
													<td><input type="text" name="book_publisher"></td>
												</tr>

												<tr>
													<td>출판일</td>
													<td><input type="date" name="book_date"></td>
												</tr>
												<tr>
													<td>책가격</td>
													<td><input type="text" name="book_price"></td>
												</tr>
												<tr>
													<td>할인가격</td>
													<td><input type="text" name="book_saleprice"></td>
												</tr>
												<tr>
													<td>판매량</td>
													<td><input type="text" name="book_sales" value=0></td>
												</tr>

												<tr>
													<td>책수량</td>
													<td><input type="text" name="book_count" value=100></td>
												</tr>
												<tr>
													<td>책이미지</td>
													<td><input type="file" style="display: none;" id="files" name="files" multiple>
														<button type="button" id="trigger" class="btn btn-secondary">Files Upload</button></td>
												</tr>
												<tr>
													<td>책소개내용</td>
													<td><textarea rows="5" cols="50" name="book_content" style="resize: none; width: 185px;"></textarea></td>
												</tr>
												<tr>
													<td>카테고리</td>
													<td><select class="join-input" name="book_cno">
															<option value="1">소설</option>
															<option value="2">에세이</option>
															<option value="3">건강/취미</option>
															<option value="4">컴퓨터/모바일</option>
															<option value="5">문제집</option>
													</select></td>
												</tr>
											</table>

											<div id="fileZone"></div>
											<button type="submit" id="regBtn" class="btn btn-secondary">책 등록</button>
										</form>
									</div>
									<script src="/resources/js/bookRegister.js"></script>
								</c:when>
								<c:when test="${content eq 'bookModify' }">
									<h1>상품수정</h1>
									<div class="tableBox tableNormal">
										<form action="/book/modify" method="post" enctype="multipart/form-data">
											<table border="1" class="table table-hover">
												<tr>
													<th>책번호</th>
													<td><input type="text" name="book_num" value="${bo.book_num }" readonly></td>
												</tr>
												<tr>
													<th>책제목</th>
													<td><input type="text" name="book_title" value="${bo.book_title }"></td>
												</tr>
												<tr>
													<th>저자</th>
													<td><input type="text" name="book_writer" value="${bo.book_writer }"></td>
												</tr>
												<tr>
													<th>정상가격</th>
													<td><input type="text" name="book_price" value="${bo.book_price }"></td>
												</tr>
												<tr>
													<th>출판사</th>
													<td><input type="text" name="book_publisher" value="${bo.book_publisher }"></td>
												</tr>
												<tr>
													<th>수량</th>
													<td><input type="text" name="book_count" value="${bo.book_count }"></td>
												</tr>
												<tr>
													<th>책내용</th>
													<td><textarea rows="5" cols="50" name="book_content">${bo.book_content }</textarea></td>
												</tr>
												<tr>
													<th>책사진</th>
													<td>
														<!-- file 표현라인 -->
														<div>
															<ul style="list-style: none;">
																<c:forEach items="${fList }" var="fvo">
																	<!-- 파일이 여러개 일 때 반복적으로 li 추가 -->
																	<li><c:choose>
																			<c:when test="${fvo.file_type > 0 }">
																				<div>
																					<!--D:~fileUpload/2022/12/28/dog.jpg -->
																					<img src="/upload/${fn:replace(fvo.save_dir,'\\','/')}/${fvo.uuid}_th_${fvo.file_name}">
																				</div>
																			</c:when>
																			<c:otherwise>
																				<div>
																					<!-- 파일모양 아이콘을 넣어서 일반 파일임을 표현하면 됨. -->
																				</div>
																			</c:otherwise>
																		</c:choose> <!-- 파일이름, 등록일, 사이즈 -->
																		<div>
																			<div>${fvo.file_name }</div>
																			${fvo.reg_at }
																		</div> <span>${fvo.file_size } Byte</span>
																		<button type="button" data-uuid=${fvo.uuid } class="file-x">X</button></li>
																</c:forEach>
															</ul>
														</div>


													</td>
												</tr>
											</table>
											<!-- 파일 수정에 따른 등록라인 -->
											<input type="file" style="display: none;" id="files" name="files" multiple>
											<button type="button" id="trigger" class="btn btn-secondary">Files Upload</button>


											<div id="fileZone"></div>
											<button type="submit" id="regBtn" class="btn btn-secondary">수정</button>
										</form>
									</div>
									<script src="/resources/js/bookRegister.js"></script>
									<script src="/resources/js/bookRemove.js"></script>
								</c:when>

							</c:choose>
						</c:when>



					</c:choose>
				</c:forEach>
			</c:forEach>
		</div>
	</div>

</body>

</html>