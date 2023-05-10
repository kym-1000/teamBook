<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.security.SecureRandom"%>
<%@ page import="java.math.BigInteger"%>

<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<link href="../resources/css/memberLogin.css" type="text/css" rel="stylesheet">
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<div class="login-box">
		<div class="memOrNon loginTopBtn">
			<a href="/mem/login-member"><button>회원</button></a> 
			<!-- <a href="/mem/login-Non-member"><button>비회원</button></a> -->
		</div>
		<div class="login-container">
			<div class="logo">
				<a href="/"><img src="../resources/img/logo.jpg" alt="로고"></a><br>
			</div>
			<div class="login">
				<form action="/mem/login" method="post">
					<input type="text" placeholder="ID" name="mem_id"><Br>
					<input type="password" placeholder="Password" name="mem_pw"><br>
					<br> <a><button type="submit"
							class="btn btn-outline-secondary">확인</button></a><br> <br>
				</form>
				<div class="login-menu-line">
					<p>
						<a href="/mem/MemPwSearch">비밀번호찾기</a> 
						<a href="/mem/MemIdSearch">아이디찾기</a>
						<a href="/mem/joinPage">회원가입</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>