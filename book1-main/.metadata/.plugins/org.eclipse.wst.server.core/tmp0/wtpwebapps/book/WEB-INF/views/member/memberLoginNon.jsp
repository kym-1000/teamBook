<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" 
crossorigin="anonymous">
<link href="../resources/css/memberLogin.css" type="text/css" rel="stylesheet">
<title>로그인-비회원</title>
</head>
<body>
	<div class="login-box">
		<div class="memOrNon loginTopBtn">
			<a href="/mem/login-member"><button>회원</button></a>
			<a href="/mem/login-Non-member"><button>비회원</button></a>
		</div>
		<div class="login-container">
			<div class="logo">
				<a href="/"><img src="../resources/img/logo.jpg" alt="로고"></a><br>
			</div>
			<div class="login">
				<form action="/nonMem/login" method="post">
					<input type="text" placeholder="주문 번호" name="mem_num"><Br>
					<input type="password" placeholder="주문 비밀번호" name="mem_pw"><br><br>
					<a><button type="submit" class="btn btn-outline-secondary">확인</button></a><br><br>
				</form>
				<div>
					<p>
						<a href="/nonMem/orderNumsearch">주문번호 찾기</a>
						<a href="/nonMem/orderPWsearch">주문비밀번호 찾기</a> 
					</p>
				</div>			
			</div>
		</div>
	</div>
</body>
</html>