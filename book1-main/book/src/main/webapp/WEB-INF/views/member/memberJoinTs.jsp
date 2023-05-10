<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>약관 동의 페이지</title>
</head>
<body>

	<h1>WW 회원가입</h1><Br> 
	<h3>WW에 오신 것을 환영합니다.</h3>
	<input type="checkbox" name="agree" value="1">이용약관 (필수) <a href="">내용보기</a><br><br>
	<input type="checkbox" name="agree" value="2">개인정보 수집 및 이용 동의 (필수) <a href="#">자세히 보기</a><br><br>
	<input type="checkbox" name="agree" value="3">마케팅 수신 동의 <a href="#">자세히 보기</a><br><br>
	<hr>
	<br>
	<input type="checkbox" name="all_check" id="all_check" >
	<label for="all_check">모두 동의합니다. </label><br>
	<a ><button>휴대폰 본인 인증</button></a>
	
	<!--스크립트-->
	<script type="text/javascript">
		const all_check = document.querySelector('input[name=all_check]');
		all_check.addEventListener('change',(e)=>{
			let agreeCheck = document.querySelectorAll('input[name=agree]');
			for(let i=0;i<agreeCheck.length;i++){
				agreeCheck[i].checked = e.target.checked;
			}
		})
	</script>
</body>
</html>