<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" 
crossorigin="anonymous">
<link href="../resources/css/memberLogin.css" type="text/css" rel="stylesheet">
<title>주문번호찾기</title>
</head>
<body>
	<div class="login-box">
		<div class="Non-search loginTopBtn3">
				<a href="/nonMem/orderNumsearch"><button>주문번호 찾기</button></a>
				<a href="/nonMem/orderPWsearch"><button>주문비밀번호 찾기</button></a> 
		</div>
		<div class="login-container">
			<div class="logo">
				<a href="/"><img src="../resources/img/logo.jpg" alt="로고"></a><br>
			</div>
			<div class="login">
				<form action="/nonMem/orderNumsearch" method="post">
					<input type="text" placeholder="이름" name="mem_name"><Br>
					<input type="text" placeholder="휴대폰 번호" name="mem_cell_num"><br><br>
					<a><button type="submit" class="btn btn-outline-secondary" onclick="result()">확인</button></a><br><br>
					<p><a href="/mem/joinPage">회원가입 하시겠습니까?</a></p>
				</form>				
			</div>
		</div>
	</div>
	<!-- 스크립트 -->
	<script type="text/javascript">
		const msg = '<c:out value="${msg}"/>';
		function result() {
			if (msg === '0' || msg == null) {
				alert("찾을 수 없습니다. 다시 입력해주세요!");
			} else {
				alert(`아이디는 ${msg} 입니다.`);
			}
		}
	</script>
</body>
</html>